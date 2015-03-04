package main.scala

/*
  austin : 3/2/2015
  Reads in newline deliminated text from stdin and returns a count and citation of occurence each line 
  
  Run from project root as: 
    sbt 'project concordance' 'run-main main.scala.Concordance' < test/resources/concordance.txt
*/
case class Concordance(word: String, count: Int, pageIndexes: Seq[Int]) {
  override def toString(): String = {
    f"$word%-15s{$count:${pageIndexes.mkString(",")}}"
  }
}

object Concordance {

  def main(args: Array[String]): Unit = {
    val text = io.Source.stdin.getLines.toSeq
    computeConcordance(text).foreach(println)
  }

  def computeConcordance(text: String): Seq[Concordance] = computeConcordance(text.split("\n"))

  def computeConcordance(text: Array[String]): Seq[Concordance] = computeConcordance(text.toSeq)

  def computeConcordance(text: Seq[String]): Seq[Concordance] = {
    // Lower case and remove punctuation
    // preservers dot characters e.g., i.e., etc., but strips period from sentence
    val cleanText = text.map{line => 
      val cleanLine = line.stripSuffix(".").toLowerCase.replaceAll("[^a-z. ]", "")
      val words = cleanLine.split(" ").filter(_.size != 0)
      words
    }

    // computes word count and annotates words with the count and page indices
    val concordance = cleanText.zipWithIndex.flatMap{case(words, pageIndex) => words.map{word => word -> pageIndex}}
      .groupBy{case(word, pageIndex) => word}
      .map{case(word, pageIndexes) => Concordance(word, pageIndexes.size, pageIndexes.map(_._2).toSeq.sorted)}
      .toSeq.sortBy{concordance => concordance.word}

    concordance
  }
}

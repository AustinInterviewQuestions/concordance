package main.scala

import cc.factorie.app.nlp.segment.PunktSentenceSegmenter.Punkt._

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

trait ConcordanceComputation {
  def extractSentences(text: String): Seq[String]
  def extractWords(sentence: String): Seq[String] 

  // computes word count and annotates words with the count and page indices
  
  def computeConcordance(sentences: String): Seq[Concordance] = computeConcordance(extractSentences(sentences))
  def computeConcordance(sentences: Array[String]): Seq[Concordance] = computeConcordance(sentences.toSeq)
  def computeConcordance(sentences: Seq[String]): Seq[Concordance] = {
    sentences.zipWithIndex.flatMap{case(sentence, pageIndex) => extractWords(sentence).map{word => word -> pageIndex}}
      .groupBy{case(word, pageIndex) => word}
      .map{case(word, pageIndexes) => Concordance(word, pageIndexes.size, pageIndexes.map(_._2).toSeq.sorted)}
      .toSeq.sortBy{concordance => concordance.word}
  }
}

object NaiveConcordance extends ConcordanceComputation {

  def extractSentences(text: String): Seq[String] = text.split("\n").toSeq
  
  // Lower case and remove punctuation
  // preservers dot characters e.g., i.e., etc., but strips period from sentence
  def extractWords(sentence: String): Seq[String] = {
    val cleanLine = sentence.stripSuffix(".").toLowerCase.replaceAll("[^a-z. ]", "")
    val words = cleanLine.split(" ").filter(_.size != 0)
    words
  }
}

object PunktConcordance extends ConcordanceComputation {

  val punktTokenizer = new PunktSentenceTokenizer()  

  def extractSentences(text: String): Seq[String] = punktTokenizer.sentencesFromText(text).toSeq
  def extractWords(sentence: String): Seq[String] = NaiveConcordance.extractWords(sentence)
}

object Concordance {
  def main(args: Array[String]): Unit = {
    val text = io.Source.stdin.getLines.mkString(" ")
    println("== naive ==")
    NaiveConcordance.computeConcordance(text).foreach(println)
    println("== punkt ==")
    PunktConcordance.computeConcordance(text).foreach(println)
  }
}

package main.scala

import org.scalatest.Matchers
import org.scalatest.FunSuite

class ConcordanceTest extends FunSuite with Matchers {
  test("single word") {
    Concordance.computeConcordance("Scala.") should be(Seq(Concordance("scala", 1, Seq(0))))
  }

  test("paragraph input") {
    val stream = getClass.getResourceAsStream("/concordance.txt")
    val text = scala.io.Source.fromInputStream(stream).getLines.toSeq
    val concordance = Concordance.computeConcordance(text)
    stream.close()
    concordance.size should be(71)
    concordance.head should be(Concordance("a", 6, Seq(0, 0, 0, 1, 1, 1)))
    concordance.find(_.word == "the").map(_.pageIndexes) should be(Some(Seq(0,0,1,1,1,1,2,2,2,3)))
  }
}

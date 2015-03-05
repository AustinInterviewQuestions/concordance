package main.scala

import org.scalatest.Matchers
import org.scalatest.FunSuite

class PunktTest extends FunSuite with Matchers {

  test("Sentence extraction from punkt") {
    val stream = getClass.getResourceAsStream("/concordance.txt")
    val text = scala.io.Source.fromInputStream(stream).getLines.mkString(" ")
    stream.close()
    val sentences = PunktConcordance.extractSentences(text)
    sentences.size should be (4)
    sentences.head.contains("e.g.") should be (true)
  }

}

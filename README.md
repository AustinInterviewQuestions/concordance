# concordance

Given newline delimited text, splits on white space and computes the "concordance":
an alphabetical list of the words in the text with the word count and citations of each appearance by line number

Run as: 

```
sbt 'project concordance' 'run-main main.scala.Concordance' < src/test/resources/concordance.txt
```

Test as:

```
sbt 'project concordance' 'test-only main.scala.ConcordanceTest'
```

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

Output should be:

```
$ sbt 'project concordance' 'run-main main.scala.Concordance' < src/test/resources/concordance.txt

[info] Loading project definition from /Users/austin/domino/test-checkout/concordance/project
[info] Updating {file:/Users/austin/domino/test-checkout/concordance/project/}concordance-build...
[info] Resolving org.fusesource.jansi#jansi;1.4 ...
[info] Done updating.
[info] Compiling 1 Scala source to /Users/austin/domino/test-checkout/concordance/project/target/scala-2.10/sbt-0.13/classes...
[warn] there were 1 deprecation warning(s); re-run with -deprecation for details
[warn] one warning found
[info] Set current project to Concordance (in build file:/Users/austin/domino/test-checkout/concordance/)
[info] Set current project to Concordance (in build file:/Users/austin/domino/test-checkout/concordance/)
[info] Updating {file:/Users/austin/domino/test-checkout/concordance/}concordance...
[info] Resolving jline#jline;2.12 ...
[info] Done updating.
[info] Compiling 1 Scala source to /Users/austin/domino/test-checkout/concordance/target/scala-2.11/classes...
[info] Running main.scala.Concordance
a              {6:0,0,0,1,1,1}
alphabetical   {1:0}
an             {2:0,1}
and            {4:0,1,2,3}
appears        {2:0,0}
arbitrary      {1:1}
assume         {1:3}
be             {1:1}
can            {1:1}
case           {1:2}
choice         {1:1}
citations      {2:0,2}
concordance    {3:0,1,1}
contains       {1:3}
count          {2:0,2}
document       {1:1}
e.g.           {1:0}
each           {3:0,0,2}
english        {3:1,3,3}
file.          {1:1}
for            {1:2}
from           {1:1}
generate       {1:1}
how            {1:0}
in             {6:0,0,1,1,2,2}
input          {1:3}
is             {1:0}
it             {1:2}
language       {1:1}
letters        {1:3}
list           {2:0,2}
marks          {1:3}
may            {1:3}
newlines       {1:3}
number         {2:0,2}
occurs.        {1:2}
of             {6:0,0,0,1,1,2}
often          {1:0}
only           {1:3}
or             {1:1}
output         {1:1}
page           {1:0}
present        {1:0}
print          {1:2}
program        {2:1,1}
programming    {1:1}
punctuation    {1:3}
read           {1:1}
sentence       {1:2}
should         {2:1,2}
sorted         {1:2}
spaces         {1:3}
standard       {2:3,3}
stdin          {1:1}
stdout         {1:1}
text           {4:0,0,1,1}
that           {3:1,2,3}
the            {10:0,0,1,1,1,1,2,2,2,3}
this           {1:2}
to             {1:1}
where          {1:0}
which          {1:2}
will           {1:1}
with           {1:0}
word           {4:0,0,2,2}
words          {1:0}
write          {1:1}
written        {1:1}
you            {1:3}
your           {1:1}
zeroindexed    {1:2}
```

and

```
$ sbt 'project concordance' 'test-only main.scala.ConcordanceTest'
[info] Loading project definition from /Users/austin/domino/test-checkout/concordance/project
[info] Set current project to Concordance (in build file:/Users/austin/domino/test-checkout/concordance/)
[info] Set current project to Concordance (in build file:/Users/austin/domino/test-checkout/concordance/)
[info] Compiling 1 Scala source to /Users/austin/domino/test-checkout/concordance/target/scala-2.11/test-classes...
[info] ConcordanceTest:
[info] - single word
[info] - paragraph input
[info] Run completed in 345 milliseconds.
[info] Total number of tests run: 2
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 2, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
[success] Total time: 6 s, completed Mar 3, 2015 4:14:34 PM
```

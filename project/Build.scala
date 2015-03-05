import sbt._
import Keys._

object ConcordanceBuild extends Build {
  lazy val concordance = Project("concordance", file("."), settings = concordanceSettings)

  def concordanceSettings = Defaults.defaultSettings ++ Seq(
    name := "Concordance",
    scalaVersion := "2.11.4",
    resolvers := Seq("IESL Release" at "http://dev-iesl.cs.umass.edu/nexus/content/groups/public"),
    libraryDependencies ++= Seq(
      "cc.factorie" % "factorie" % "1.0",
      "org.scalatest" %% "scalatest" % "2.2.1" % "test"
    )
  )
}

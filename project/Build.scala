import sbt._
import Keys._

object ConcordanceBuild extends Build {
  lazy val concordance = Project("concordance", file("."), settings = concordanceSettings)

  def concordanceSettings = Defaults.defaultSettings ++ Seq(
    name := "Concordance",
    scalaVersion := "2.11.4",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "2.2.1" % "test"
    )
  )
}

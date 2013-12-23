import sbt._
import sbt.Keys._

object ChalkExampleBuild extends Build {

  lazy val chalkExample = Project(
    id = "chalk-example",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "Chalk Example",
      organization := "com.hase1031",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.2"
      // add other settings here
    )
  )
}

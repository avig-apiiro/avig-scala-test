ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.5"


lazy val root = (project in file("."))
  .settings(
    name := "untitled",
    libraryDependencies += "org.scala-lang" %% "toolkit-test" % "0.1.7" % Test,
    libraryDependencies +=   "com.softwaremill.sttp.client4" %% "core" % "4.0.0-RC1",
    libraryDependencies +=   "com.softwaremill.sttp.client4" %% "upickle" % "4.0.0-RC1"

)

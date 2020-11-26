lazy val commonSettings = Seq(
  name := "scala_example",
  version := "1.0-SNAPSHOT",
  scalaVersion := "2.13.3",
  scalacOptions ++= Seq(
    "-deprecation",
    "-Xfatal-warnings",
    "-Ywarn-value-discard",
    "-Xlint:missing-interpolator",
    "-Xmacro-settings:materialize-derivations"
  )
)

lazy val Http4sVersion = "0.21.1"

lazy val CirceVersion = "0.13.0"

lazy val LogbackVersion = "1.2.3"

lazy val ScalaTestVersion = "3.1.1"

lazy val ScalaMockVersion = "4.4.0"

lazy val root = (project in file("."))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-blaze-server" % Http4sVersion,
      "org.http4s" %% "http4s-circe" % Http4sVersion,
      "org.http4s" %% "http4s-dsl" % Http4sVersion,
      "org.http4s" %% "http4s-blaze-client" % Http4sVersion % "test",
      "io.circe" %% "circe-generic" % CirceVersion,
      "io.circe" %% "circe-core" % CirceVersion,
      "io.circe" %% "circe-generic" % CirceVersion,
      "io.circe" %% "circe-parser" % CirceVersion,
      "io.circe" %% "circe-literal" % CirceVersion % "test",
      "io.circe" %% "circe-optics" % CirceVersion,
      "ch.qos.logback" % "logback-classic" % LogbackVersion,
      "org.scalatest" %% "scalatest" % ScalaTestVersion % "test",
      "org.scalamock" %% "scalamock" % ScalaMockVersion % "test"
    )
  )

organization := "io.mth"

name := "unfiltered-cors"

scalaVersion := "2.10.0"

crossScalaVersions := Seq("2.9.2", "2.9.3", "2.10.0")

libraryDependencies ++= Seq(
  "net.databinder" %% "unfiltered" % "0.6.7",
  "net.databinder" %% "unfiltered-filter" % "0.6.7" % "test",
  "net.databinder" %% "unfiltered-jetty" % "0.6.7" % "test",
  "io.argonaut" %% "argonaut" % "6.0-M3" % "test"
)

resolvers ++= Seq(
  "java m2" at "http://download.java.net/maven/2",
  "oss snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "oss releases" at "http://oss.sonatype.org/content/repositories/releases"
)

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

licenses := Seq("BSD-3-Clause" -> url("http://www.opensource.org/licenses/BSD-3-Clause"))

homepage := Some(url("https://github.com/markhibberd/unfiltered-cors"))

useGpg := true

pomExtra := (
      <scm>
        <url>git@github.com:markhibberd/unfiltered-cors.git</url>
        <connection>scm:git:git@github.com:markhibberd/argonaut.git</connection>
      </scm>
      <developers>
        <developer>
          <id>mth</id>
          <name>Mark Hibberd</name>
          <url>http://mth.io</url>
        </developer>
      </developers>
)

publishTo <<= version.apply(v => {
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
})

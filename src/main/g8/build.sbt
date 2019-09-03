
name := "$name$"

organization := "$organization$"

scalaVersion := "$scala_version$"


mainClass := Some("$package$.Application")

resolvers += "sfxcode-maven" at "https://bintray.com/sfxcode/maven/"


libraryDependencies += "org.specs2" %% "specs2-core" % "4.7.0" % Test

val JavaFXVersion = "12.0.2"

val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux") => "linux"
  case n if n.startsWith("Mac") => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}

libraryDependencies ++= Seq("base", "controls", "fxml", "graphics", "media", "swing", "web").map(m => "org.openjfx" % s"javafx-\$m" % JavaFXVersion classifier osName)


libraryDependencies +=   "com.sfxcode.sapphire" %% "sapphire-core" % "$sapphire_core_version$"

libraryDependencies +=   "com.sfxcode.sapphire" %% "sapphire-extension" % "$sapphire_extension_version$"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

enablePlugins(BuildInfoPlugin)

buildInfoPackage := "$package$"

buildInfoOptions += BuildInfoOption.BuildTime


enablePlugins(JavaFxPlugin)

javaFxMainClass := "$package$.Application"

javaFxJvmargs := Seq("-Xms512m", "-Xmx1024m", "-XX:ReservedCodeCacheSize=128m")

javaFxTitle := "$name$"

javaFxCategory := "Aplication"

javaFxNativeBundles := "image"

javaFxVerbose := true



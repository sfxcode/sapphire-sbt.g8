
name := "$name$"

organization := "$organization$"

scalaVersion := "$scala_version$"


mainClass := Some("$package$.Application")

libraryDependencies += "org.specs2" %% "specs2-core" % "4.3.6" % Test

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



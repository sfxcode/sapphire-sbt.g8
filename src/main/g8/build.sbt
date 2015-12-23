import no.vedaadata.sbtjavafx.JavaFXPlugin.JFX

name := "$name$"

organization := "$organization$"

version := "$version$"

scalaVersion := "$scala_version$"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions += "-target:jvm-1.7"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions += "-target:jvm-1.7"

mainClass := Some("$package$.Application")

libraryDependencies += "org.specs2" %% "specs2-core" % "3.6.6" % "test"

libraryDependencies +=   "com.sfxcode.sapphire" %% "sapphire-core" % "$sapphire_core_version$"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3"


jfxSettings

JFX.mainClass := Some("$package$.Application")

JFX.nativeBundles := "none"


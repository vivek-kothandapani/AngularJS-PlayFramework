name := """dneuronsbks"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  cache,
  javaWs,
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  "mysql" % "mysql-connector-java" % "5.1.6",  
  "org.hibernate" % "hibernate-core" % "4.3.8.Final",  
  "org.hibernate" % "hibernate-entitymanager" % "4.3.8.Final",
  "com.typesafe.play" %% "play-mailer" % "2.4.0",
  "commons-io" % "commons-io" % "2.4",
  "org.apache.poi" % "poi" % "3.9",
  "org.apache.poi" % "poi-ooxml" % "3.9"
)

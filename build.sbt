enablePlugins(ScalaJSPlugin, WorkbenchPlugin)

ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.cell.client"
ThisBuild / organizationName := "home"

lazy val root = (project in file("."))
  .settings(
    name := "scala-cell-client",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8",
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.7",
    libraryDependencies += "com.lihaoyi" %%% "scalatags" % "0.7.0",
    libraryDependencies += "com.lihaoyi" %%% "upickle" % "0.8.0"
  )

mainClass in Compile := Some("Pedesis")

scalaJSUseMainModuleInitializer := true

scalaJSMainModuleInitializer in Compile := Some(
  org.scalajs.core.tools.linker.ModuleInitializer.mainMethodWithArgs("Pedesis", "main")
)

workbenchCompression := true
workbenchDefaultRootObject := Some(("./src/main/resources/index-dev.html", "./target/scala-2.13/"))  // (defaultRootObject, rootDirectory)
workbenchStartMode := WorkbenchStartModes.OnCompile


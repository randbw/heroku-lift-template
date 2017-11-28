name := "template for lift on heroku"

version := "0.0.1"

organization := ""

scalaVersion := "2.11.6"

resolvers ++= Seq(
  "snapshots"     at "https://oss.sonatype.org/content/repositories/snapshots",
  "releases"        at "https://oss.sonatype.org/content/repositories/releases"
)

lazy val root = project
  .in(file("."))
  .settings(Defaults.coreDefaultSettings)

enablePlugins(JettyPlugin)

unmanagedResourceDirectories in Test += (baseDirectory) { _ / "src/main/webapp" }.value

scalacOptions ++= Seq("-deprecation", "-unchecked")

val liftVersion = "3.1.0"

libraryDependencies ++= {
  Seq(
    "net.liftweb"             %% "lift-webkit"              % liftVersion     % "compile",
    "net.liftmodules"         %% "lift-jquery-module_3.1" % "2.10"        % "compile", // https://github.com/karma4u101/lift-jquery-module
    "org.eclipse.jetty"       % "jetty-webapp"              % "9.2.7.v20150116"     % "compile",
    "org.eclipse.jetty"       % "jetty-plus"                % "9.2.7.v20150116"     % "container,test", // For Jetty Config
    "org.eclipse.jetty.orbit" % "javax.servlet"             % "3.0.0.v201112011016" % "container,test" artifacts Artifact("javax.servlet", "jar", "jar"),
    "ch.qos.logback"          % "logback-classic"           % "1.0.6"               % "runtime",
    "org.specs2"              %% "specs2"                   % "2.3.12"              % "test"
  )
}

enablePlugins(JavaAppPackaging)

enablePlugins(HerokuDeploy)
herokuAppName := "<insert heroku app name>"

bashScriptConfigLocation := Some("${app_home}/../conf/jvmopts")

import sbt._
import sbt.Keys._

object RootBuild extends Build {

  val liftVersion = SettingKey[String]("liftVersion", "Full version number of the Lift Web Framework")
  val liftEdition = SettingKey[String]("liftEdition", "Lift Edition (short version number to append to artifact name)")

  lazy val root =
    Project("root", file("."))
      .settings(
        Defaults.coreDefaultSettings ++
          Seq(liftEdition := "3.1.0")
      )
}

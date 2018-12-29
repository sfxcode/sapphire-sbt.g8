package $package$

import com.sfxcode.sapphire.core.cdi.FXApp

import com.typesafe.config.ConfigFactory

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.stage.Stage

object Application extends FXApp {

  JFXApp.AutoShow = true

  override def applicationStage:Stage  = {
    val conf = ConfigFactory.load()
    new PrimaryStage {
      title = "%s (%s)".format(conf.getString("project.name"), conf.getString("project.version"))
      minHeight = conf.getInt("stage.default.height")
      minWidth = conf.getInt("stage.default.width")
      scene = new Scene {
      }
    }
  }
}



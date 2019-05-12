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
      title = "%s (%s)".format(configStringValue("project.name"), BuildInfo.version)
      minHeight = configIntValue("stage.default.height")
      minWidth = configIntValue("stage.default.width")
      scene = new Scene {
      }
    }
  }
}



package $package$

import com.name.app.controller.MainViewController
import com.sfxcode.sapphire.javafx.controller.SFXApplicationController
import com.sfxcode.sapphire.javafx.application.SFXApplicationEnvironment

class ApplicationController extends SFXApplicationController {

  lazy val mainViewController = getController[MainViewController]()

  def applicationDidLaunch() {
    logger.info("start " + this)
    SFXApplicationEnvironment.loadResourceBundle("bundles/application")
    replaceSceneContent(mainViewController)
  }

  def applicationName: ApplicationName = {
    ApplicationName(configStringValue("application.name"))
  }

  def replacePrimarySceneContent(): Unit = {
    // Styling
    reloadStyles()
    // Resources
    SFXApplicationEnvironment.clearResourceBundleCache()
    SFXApplicationEnvironment.loadResourceBundle("bundles/application")
    // FXML
    val newMainViewController = getController[MainViewController]()
    replaceSceneContent(newMainViewController)
  }
}

case class ApplicationName(name: String)

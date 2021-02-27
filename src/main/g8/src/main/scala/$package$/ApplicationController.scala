package $package$

import com.name.app.controller.MainViewController
import com.sfxcode.sapphire.javafx.controller.BaseApplicationController
import com.sfxcode.sapphire.javafx.application.ApplicationEnvironment

class ApplicationController extends BaseApplicationController {

  lazy val mainViewController = getController[MainViewController]()

  def applicationDidLaunch() {
    logger.info("start " + this)
    ApplicationEnvironment.loadResourceBundle("bundles/application")
    replaceSceneContent(mainViewController)
  }

  def applicationName: ApplicationName = {
    ApplicationName(configStringValue("application.name"))
  }

  def replacePrimarySceneContent(): Unit = {
    // Styling
    reloadStyles()
    // Resources
    ApplicationEnvironment.clearResourceBundleCache()
    ApplicationEnvironment.loadResourceBundle("bundles/application")
    // FXML
    val newMainViewController = getController[MainViewController]()
    replaceSceneContent(newMainViewController)
  }
}

case class ApplicationName(name: String)

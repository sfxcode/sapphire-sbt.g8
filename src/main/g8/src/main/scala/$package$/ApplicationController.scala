package $package$

import com.typesafe.config.ConfigFactory
import com.sfxcode.sapphire.core.controller.BaseApplicationController


import $package$.controller.MainViewController

class ApplicationController extends BaseApplicationController {

  lazy val mainViewController = getController[MainViewController]()

  def applicationDidLaunch() {
    logger.info("start " + this)
    applicationEnvironment.loadResourceBundle("bundles/application")
    replaceSceneContent(mainViewController)
  }

  def applicationName: ApplicationName = {
    ApplicationName(configStringValue("application.name"))
  }

  def replacePrimarySceneContent(): Unit = {
    // Styling
    reloadStyles()
    // Resources
    applicationEnvironment.clearResourceBundleCache()
    applicationEnvironment.loadResourceBundle("bundles/application")
    // FXML
    val newMainViewController = getController[MainViewController]()
    replaceSceneContent(newMainViewController)
  }
}

case class ApplicationName(name: String)

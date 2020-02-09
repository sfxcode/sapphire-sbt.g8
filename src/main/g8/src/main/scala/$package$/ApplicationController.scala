package $package$

import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Produces
import javax.inject.Named
import com.typesafe.config.ConfigFactory
import com.sfxcode.sapphire.core.controller.DefaultWindowController

import $package$.controller.MainViewController


@Named
@ApplicationScoped
class ApplicationController extends DefaultWindowController {

  lazy val mainViewController = getController[MainViewController]()

  def applicationDidLaunch() {
    logger.info("start " + this)
    applicationEnvironment.loadResourceBundle("bundles/application")
    replaceSceneContent(mainViewController)
  }

  @Produces
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

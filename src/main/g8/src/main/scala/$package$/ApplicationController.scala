package $package$

import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Produces
import javax.inject.Named
import com.typesafe.config.ConfigFactory
import com.sfxcode.sapphire.core.controller.AppController

import $package$.controller.MainWindowController


@Named
@ApplicationScoped
class ApplicationController extends AppController {
  val conf = ConfigFactory.load()

  lazy val mainWindowController = getController[MainWindowController]()

  def applicationDidLaunch() {
    logger.info("start " + this)
    applicationEnvironment.loadResourceBundle("bundles/application")
    replaceSceneContent(mainWindowController)
  }

  @Produces
  def applicationName: ApplicationName = {
    ApplicationName(conf.getString("application.name"))
  }

  def replacePrimarySceneContent(): Unit = {
    val newMainWindowController = getController[MainWindowController]()
    replaceSceneContent(newMainWindowController)
  }
}

case class ApplicationName(name: String)

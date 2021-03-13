package $package$.controller

import com.sfxcode.sapphire.javafx.controller.SFXViewController
import com.sfxcode.sapphire.javafx.application.SFXApplicationEnvironment

import com.typesafe.scalalogging.LazyLogging
import $package$.ApplicationController

abstract class AbstractViewController extends SFXViewController with LazyLogging{


  override def didGainVisibility(): Unit = {
    statusBarController.statusLabel.setText("%s loaded".format(getClass.getSimpleName))
  }

  def applicationController: ApplicationController = SFXApplicationEnvironment.applicationController[ApplicationController]


  def mainViewController:MainViewController = applicationController.mainViewController


  def statusBarController: StatusBarController = mainViewController.statusBarController

  /**
    *
   * @return workspace manager resolved by parent
    */
  def workspaceManager = mainViewController.workspaceManager

}

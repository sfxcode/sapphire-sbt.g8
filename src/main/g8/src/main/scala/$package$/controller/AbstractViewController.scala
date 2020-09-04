package $package$.controller

import com.sfxcode.sapphire.core.controller.ViewController
import com.typesafe.scalalogging.LazyLogging
import $package$.ApplicationController

abstract class AbstractViewController extends ViewController with LazyLogging{


  override def didGainVisibility(): Unit = {
    statusBarController.statusLabel.setText("%s loaded".format(getClass.getSimpleName))
  }

  def applicationController: ApplicationController = ApplicationEnvironment.applicationController[ApplicationController]


  def mainViewController:MainViewController = applicationController.mainViewController

  /**
    *
   * @return
    */
  def statusBarController = getBean[StatusBarController]()

  /**
    *
   * @return workspace manager resolved by parent
    */
  def workspaceManager = mainViewController.workspaceManager

}

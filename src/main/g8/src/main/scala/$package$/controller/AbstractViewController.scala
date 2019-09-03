package $package$.controller

import com.sfxcode.sapphire.core.controller.ViewController
import com.typesafe.scalalogging.LazyLogging
import $package$.ApplicationController

abstract class AbstractViewController extends ViewController with LazyLogging{


  override def didGainVisibility(): Unit = {
    statusBarController.statusLabel.setText("%s loaded".format(getClass.getSimpleName))
  }

  def applicationController:ApplicationController = {
    getBean[ApplicationController]()

  }

  def mainWindowController:MainWindowController = {
    parent.asInstanceOf[MainWindowController]
  }

  /**
    *
   * @return
    */
  def statusBarController = getBean[StatusBarController]()

  /**
    *
   * @return workspace manager resolved by parent
    */
  def workspaceManager = mainWindowController.workspaceManager

}

package $package$.controller

import javafx.event.ActionEvent
import javafx.scene.control.Button

class NavigationController extends AbstractViewController {

  def actionClickButton(event: ActionEvent) {
    logger.debug(event.toString)
    statusBarController.updateLabel(event.getSource.asInstanceOf[Button])
  }

  def actionHotReload(event: ActionEvent) {
    applicationController.replacePrimarySceneContent()
    logger.debug("Hot Reload Succeeded")
    statusBarController.updateLabel(event.getSource.asInstanceOf[Button])
  }
}

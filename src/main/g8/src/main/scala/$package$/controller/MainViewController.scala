package $package$.controller

import javafx.fxml.FXML
import javafx.scene.control.MenuBar
import javafx.scene.layout.Pane

import com.sfxcode.sapphire.javafx.controller.SFXViewController
import com.sfxcode.sapphire.javafx.scene.{ContentDidChangeEvent, SFXContentManager}
import com.typesafe.scalalogging.LazyLogging

class MainViewController extends SFXViewController with LazyLogging {

  @FXML
  var menuBar: MenuBar = _

  @FXML
  var workspacePane: Pane = _
  @FXML
  var statusPane: Pane = _
  @FXML
  var navigationPane: Pane = _

  lazy val workspaceController = getController[WorkspaceController]()
  lazy val navigationController = getController[NavigationController]()
  lazy val statusBarController: StatusBarController = new StatusBarController()

  var workspaceManager: SFXContentManager = _
  var navigationManager: SFXContentManager = _
  var statusBarManager: SFXContentManager = _

  override def didGainVisibilityFirstTime() {
    menuBar.setUseSystemMenuBar(true)

    navigationManager = SFXContentManager(navigationPane, this, navigationController)
    statusBarManager = SFXContentManager(statusPane, this, statusBarController)
    workspaceManager = SFXContentManager(workspacePane, this, workspaceController)
  }

}

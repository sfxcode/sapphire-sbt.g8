package $package$.controller

import javafx.fxml.FXML
import javafx.scene.control.MenuBar
import javafx.scene.layout.Pane
import javax.enterprise.event.Observes

import com.sfxcode.sapphire.core.controller.ViewController
import com.sfxcode.sapphire.core.scene.{ContentDidChangeEvent, ContentManager}
import com.typesafe.scalalogging.LazyLogging

class MainWindowController extends ViewController with LazyLogging {

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
  lazy val statusBarController = getBean[StatusBarController]()

  var workspaceManager: ContentManager = _
  var navigationManager: ContentManager = _
  var statusBarManager: ContentManager = _

  override def didGainVisibilityFirstTime() {
    menuBar.setUseSystemMenuBar(true)

    navigationManager = ContentManager(navigationPane, this, navigationController)
    statusBarManager = ContentManager(statusPane, this, statusBarController)
    workspaceManager = ContentManager(workspacePane, this, workspaceController)
  }

  def listenToChanges(@Observes event: ContentDidChangeEvent) {
    logger.debug(event.toString)
  }


}

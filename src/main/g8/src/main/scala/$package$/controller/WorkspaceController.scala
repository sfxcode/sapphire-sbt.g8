package $package$.controller

import javafx.fxml.FXML
import javafx.scene.control.Label
import javax.inject.Inject

import $package$.ApplicationName


class WorkspaceController extends AbstractViewController {

  @Inject
  var applicationName: ApplicationName = applicationController.applicationName

  @FXML
  var infoLabel: Label = _

  override def didGainVisibilityFirstTime() {
    infoLabel.setText(applicationName.name)
  }
}



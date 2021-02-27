package $package$

import com.sfxcode.sapphire.javafx.ConfigValues
import com.sfxcode.sapphire.javafx.application.BaseApplication
import com.sfxcode.sapphire.javafx.controller.BaseApplicationController

object Application extends BaseApplication with ConfigValues {

  override def title: String = configStringValue("project.name")

  override val applicationController: BaseApplicationController = new ApplicationController

}



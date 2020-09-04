package $package$

import com.sfxcode.sapphire.core.ConfigValues
import com.sfxcode.sapphire.core.application.BaseApplication
import com.sfxcode.sapphire.core.controller.BaseApplicationController

object Application extends BaseApplication with ConfigValues {

  override def title: String = configStringValue("project.name")

  override val applicationController: BaseApplicationController = new ApplicationController

}



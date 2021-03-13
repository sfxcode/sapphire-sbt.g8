package $package$

import com.sfxcode.sapphire.data.Configuration
import com.sfxcode.sapphire.javafx.application.SFXApplication
import com.sfxcode.sapphire.javafx.controller.SFXApplicationController

object Application extends SFXApplication with Configuration {

  override def title: String = configStringValue("project.name")

  override val applicationController: SFXApplicationController = new ApplicationController

}



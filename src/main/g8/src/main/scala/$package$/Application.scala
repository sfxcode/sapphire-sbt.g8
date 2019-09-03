package $package$

import com.sfxcode.sapphire.core.ConfigValues
import com.sfxcode.sapphire.core.application.FXApp

object Application extends FXApp with ConfigValues {

  override def title: String = configStringValue("project.name")

}



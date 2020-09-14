package com.github.minidigger.firstspiritlanguagesupport

import com.intellij.lang.Language

class FirstSpiritTemplateLanguage : Language("FirstSpiritTemplate") {

    companion object {
        var instance: FirstSpiritTemplateLanguage = FirstSpiritTemplateLanguage()
    }
}

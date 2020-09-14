package com.github.minidigger.firstspiritlanguagesupport

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class FirstSpiritTemplateFileType : LanguageFileType(FirstSpiritTemplateLanguage.instance) {

    override fun getName(): String {
        return "FirstSpiritTemplate"
    }

    override fun getDescription(): String {
        return "FirstSpirit Template File"
    }

    override fun getDefaultExtension(): String {
        return "fstemplate"
    }

    override fun getIcon(): Icon? {
        return TEMPLATE_ICON
    }

    companion object {
        @JvmStatic
        val INSTANCE: FirstSpiritTemplateFileType = FirstSpiritTemplateFileType()
    }
}

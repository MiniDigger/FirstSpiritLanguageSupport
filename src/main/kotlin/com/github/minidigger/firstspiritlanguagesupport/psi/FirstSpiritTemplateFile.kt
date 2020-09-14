package com.github.minidigger.firstspiritlanguagesupport.psi

import com.github.minidigger.firstspiritlanguagesupport.FirstSpiritTemplateFileType
import com.github.minidigger.firstspiritlanguagesupport.FirstSpiritTemplateLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import org.jetbrains.annotations.NotNull

class FirstSpiritTemplateFile(@NotNull viewProvider: FileViewProvider) :
        PsiFileBase(viewProvider, FirstSpiritTemplateLanguage.instance) {

    @NotNull
    override fun getFileType(): FileType {
        return FirstSpiritTemplateFileType.INSTANCE
    }

    override fun toString(): String {
        return "FirstSpiritTemplate File"
    }
}

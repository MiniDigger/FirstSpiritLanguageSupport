package com.github.minidigger.firstspiritlanguagesupport.formatter

import com.github.minidigger.firstspiritlanguagesupport.FirstSpiritTemplateLanguage
import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleSettings

class FirstSpiritTemplateFormattingModelBuilder : FormattingModelBuilder {

    override fun createModel(element: PsiElement, settings: CodeStyleSettings): FormattingModel {
        return FormattingModelProvider.createFormattingModelForPsiFile(element.containingFile,
                FirstSpiritTemplateBlock(element.node, Wrap.createWrap(WrapType.NONE, false),
                        null, createSpaceBuilder(settings)), settings)
    }

    private fun createSpaceBuilder(settings: CodeStyleSettings): SpacingBuilder {
        return SpacingBuilder(settings, FirstSpiritTemplateLanguage.instance)
    }


    override fun getRangeAffectingIndent(file: PsiFile?, offset: Int, elementAtOffset: ASTNode?): TextRange? {
        return null
    }
}

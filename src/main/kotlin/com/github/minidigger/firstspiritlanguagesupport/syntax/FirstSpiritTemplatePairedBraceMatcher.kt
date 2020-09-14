package com.github.minidigger.firstspiritlanguagesupport.syntax

import com.github.minidigger.firstspiritlanguagesupport.psi.FirstSpiritTemplateTypes
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType


class FirstSpiritTemplatePairedBraceMatcher : PairedBraceMatcher {

    private val bracePairs = arrayOf( // '(' and ( ')$' or ')' )
            BracePair(FirstSpiritTemplateTypes.FSTEMPLATE_PAR_LEFT, FirstSpiritTemplateTypes.FSTEMPLATE_PAR_RIGHT, false),
            BracePair(FirstSpiritTemplateTypes.FSTEMPLATE_PAR_LEFT, FirstSpiritTemplateTypes.FSTEMPLATE_PAR_RIGHT_DOLLAR, false),  // all FirstSpirit group-expressions of '$CMS_' with '_END_'
            BracePair(FirstSpiritTemplateTypes.FSTEMPLATE_IF, FirstSpiritTemplateTypes.FSTEMPLATE_IF_END, true),  //TODO: add cases for cms_elsif
            BracePair(FirstSpiritTemplateTypes.FSTEMPLATE_FOR, FirstSpiritTemplateTypes.FSTEMPLATE_FOR_END, true),
            BracePair(FirstSpiritTemplateTypes.FSTEMPLATE_SET, FirstSpiritTemplateTypes.FSTEMPLATE_SET_END, true),
            BracePair(FirstSpiritTemplateTypes.FSTEMPLATE_SWITCH, FirstSpiritTemplateTypes.FSTEMPLATE_SWITCH_END, true),
            BracePair(FirstSpiritTemplateTypes.FSTEMPLATE_TRIM, FirstSpiritTemplateTypes.FSTEMPLATE_TRIM_END, true))

    override fun getPairs(): Array<BracePair> {
        return bracePairs
    }

    override fun isPairedBracesAllowedBeforeType(type1: IElementType, type2: IElementType?): Boolean {
        return true
    }

    override fun getCodeConstructStart(paramPsiFile: PsiFile?, paramInt: Int): Int {
        return paramInt
    }
}

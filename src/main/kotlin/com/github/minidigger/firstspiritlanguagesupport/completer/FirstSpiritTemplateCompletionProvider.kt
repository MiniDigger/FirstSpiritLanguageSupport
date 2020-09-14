package com.github.minidigger.firstspiritlanguagesupport.completer

import com.github.minidigger.firstspiritlanguagesupport.TEMPLATE_ICON
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.ProcessingContext

class FirstSpiritTemplateCompletionProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, resultSet: CompletionResultSet) {
        resultSet.addElement(LookupElementBuilder.create("$-- comment --$").withIcon(TEMPLATE_ICON).withInsertHandler { insertionContext, _ ->
            run {
                // TODO: implement insertion of user comment here
                insertionContext.tailOffset = insertionContext.startOffset + 4
                //insertionContext.trackOffset(insertionContext.getStartOffset() + 3, true)
                insertionContext.setAddCompletionChar(true)
                insertionContext.commitDocument()
            }
        })
        resultSet.addElement(LookupElementBuilder.create("\$CMS_FOR(element,elements)$\$CMS_END_FOR$").withIcon(TEMPLATE_ICON))
        resultSet.addElement(LookupElementBuilder.create("\$CMS_IF(var)$\$CMS_ELSE$\$CMS_END_IF$").withIcon(TEMPLATE_ICON))
        resultSet.addElement(LookupElementBuilder.create("\$CMS_IF(var)$\$CMS_ELSIF(var)$\$CMS_ELSE$\$CMS_END_IF$").withIcon(TEMPLATE_ICON))
        resultSet.addElement(LookupElementBuilder.create("\$CMS_IF(var)$\$CMS_END_IF$").withIcon(TEMPLATE_ICON))
        resultSet.addElement(LookupElementBuilder.create("\$CMS_IF(var)$").withIcon(TEMPLATE_ICON))
        resultSet.addElement(LookupElementBuilder.create("\$CMS_INCLUDE()$").withIcon(TEMPLATE_ICON))
        resultSet.addElement(LookupElementBuilder.create("\$CMS_REF(var)$").withIcon(TEMPLATE_ICON))
        resultSet.addElement(LookupElementBuilder.create("\$CMS_RENDER()$").withIcon(TEMPLATE_ICON))
        resultSet.addElement(LookupElementBuilder.create("\$CMS_SET(var)$\$CMS_END_SET$").withIcon(TEMPLATE_ICON))
        resultSet.addElement(LookupElementBuilder.create("\$CMS_SWITCH()$\$CMS_CASE()$\$CMS_END_SWITCH$").withIcon(TEMPLATE_ICON))
        resultSet.addElement(LookupElementBuilder.create("\$CMS_TRIM(level:3)$ \$CMS_END_TRIM$").withIcon(TEMPLATE_ICON))
        resultSet.addElement(LookupElementBuilder.create("\$CMS_VALUE(var)$").withIcon(TEMPLATE_ICON).withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE))
        resultSet.addElement(LookupElementBuilder.create("\$CMS_VALUE(var, default:\"\")$").withIcon(TEMPLATE_ICON))
    }
}

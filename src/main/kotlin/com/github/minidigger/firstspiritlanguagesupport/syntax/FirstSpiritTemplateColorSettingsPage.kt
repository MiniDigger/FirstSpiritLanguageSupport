package com.github.minidigger.firstspiritlanguagesupport.syntax


import com.github.minidigger.firstspiritlanguagesupport.TEMPLATE_ICON
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon


class FirstSpiritTemplateColorSettingsPage : ColorSettingsPage {

    private val DESCRIPTORS = arrayOf(
            AttributesDescriptor("keyword", FSKEYWORD),
            AttributesDescriptor("bracket", BRACKET),
            AttributesDescriptor("bad character", BAD_CHARACTER),
            AttributesDescriptor("comment", COMMENT),
            AttributesDescriptor("string", STRING),
            AttributesDescriptor("normal templating text", NON_FS))

    override fun getIcon(): Icon? {
        return TEMPLATE_ICON
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return FirstSpiritTemplateSyntaxHighlighter()
    }

    override fun getDemoText(): String {
        return """$-- some block comment
   which has two lines --$
 some text comes here
${"$"}CMS_IF(my_variable_is_true)$ 
    ${"$"}CMS_IF(var1)$ 
    ${"$"}CMS_END_IF$
    ${"$"}CMS_VALUE(anystring, default:"foo")$
    ${"$"}CMS_VALUE(anystring)$
    ${"$"}CMS_IF(var2)$ 
    ${"$"}CMS_END_IF$
${"$"}CMS_END_IF$"""
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): kotlin.collections.Map<String?, TextAttributesKey?>? {
        return null
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "FirstSpiritTemplate"
    }
}

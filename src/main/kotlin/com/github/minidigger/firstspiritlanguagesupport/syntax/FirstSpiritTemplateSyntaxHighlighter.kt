package com.github.minidigger.firstspiritlanguagesupport.syntax

import com.github.minidigger.firstspiritlanguagesupport.parser.FirstSpiritTemplateLexerAdapter
import com.github.minidigger.firstspiritlanguagesupport.psi.FirstSpiritTemplateTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NotNull

val FSKEYWORD: TextAttributesKey = createTextAttributesKey("FIRSTSPIRIT_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
val NON_FS: TextAttributesKey = createTextAttributesKey("NON_FIRSTSPIRIT")
val STRING: TextAttributesKey = createTextAttributesKey("FIRSTSPIRIT_STRING", DefaultLanguageHighlighterColors.STRING)
val COMMENT: TextAttributesKey = createTextAttributesKey("FIRSTSPIRIT_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT)
val BRACKET: TextAttributesKey = createTextAttributesKey("FIRSTSPIRIT_BRACKET", DefaultLanguageHighlighterColors.BRACKETS)

val BAD_CHARACTER: TextAttributesKey = createTextAttributesKey("FIRSTSPIRIT_BAD_CHARACTER")

class FirstSpiritTemplateSyntaxHighlighter : SyntaxHighlighterBase() {

    private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
    private val KEYWORDS = arrayOf(FSKEYWORD)
    private val STRING_KEYS = arrayOf(STRING)
    private val NON_FS_KEYS = arrayOf(NON_FS)

    private val COMMENT_KEYS = arrayOf(COMMENT)
    private val BRACKET_KEYS = arrayOf(BRACKET)
    private val EMPTY_KEYS = emptyArray<TextAttributesKey>()

    @NotNull
    override fun getHighlightingLexer(): Lexer {
        return FirstSpiritTemplateLexerAdapter()
    }

    @NotNull
    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return if (tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_STRING) {
            STRING_KEYS
        } else if (tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_SOMETHING) {
            NON_FS_KEYS
        } else if (tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_COMMENT) {
            COMMENT_KEYS
        } else if (tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_PAR_LEFT
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_PAR_RIGHT) {
            BRACKET_KEYS
        } else if (tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_IF
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_IF_ELSE
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_IF_END
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_SET
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_SET_END
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_VALUE
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_FOR
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_FOR_END
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_CASE
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_INCLUDE
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_RENDER
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_SWITCH
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_SWITCH_END
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_TRIM
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_TRIM_END
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_TRIM_LEVEL
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_PAR_RIGHT_DOLLAR
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_DEFAULT
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_MEDIA
                || tokenType == FirstSpiritTemplateTypes.FSTEMPLATE_SCRIPT) {
            KEYWORDS
        } else if (tokenType == TokenType.BAD_CHARACTER) {
            BAD_CHAR_KEYS
        } else {
            EMPTY_KEYS
        }
    }
}

package com.github.minidigger.firstspiritlanguagesupport.parser

import com.github.minidigger.firstspiritlanguagesupport.FirstSpiritTemplateLanguage
import com.github.minidigger.firstspiritlanguagesupport.psi.FirstSpiritTemplateFile
import com.github.minidigger.firstspiritlanguagesupport.psi.FirstSpiritTemplateTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.jetbrains.annotations.NotNull

class FirstSpiritTemplateParserDefinition : ParserDefinition {

    private val whitespaces = TokenSet.create(TokenType.WHITE_SPACE)
    private val comments = TokenSet.create(FirstSpiritTemplateTypes.FSTEMPLATE_COMMENT)

    private val file = IFileElementType(FirstSpiritTemplateLanguage.instance)

    @NotNull
    override fun createLexer(project: Project?): Lexer {
        return FirstSpiritTemplateLexerAdapter()
    }

    @NotNull
    override fun getWhitespaceTokens(): TokenSet {
        return whitespaces
    }

    @NotNull
    override fun getCommentTokens(): TokenSet {
        return comments
    }

    @NotNull
    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    @NotNull
    override fun createParser(project: Project): PsiParser {
        return FirstSpiritTemplateParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return file
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return FirstSpiritTemplateFile(viewProvider)
    }

    override fun spaceExistanceTypeBetweenTokens(left: ASTNode, right: ASTNode): SpaceRequirements? {
        return SpaceRequirements.MAY
    }

    @NotNull
    override fun createElement(node: ASTNode): PsiElement {
        return FirstSpiritTemplateTypes.Factory.createElement(node)
    }
}

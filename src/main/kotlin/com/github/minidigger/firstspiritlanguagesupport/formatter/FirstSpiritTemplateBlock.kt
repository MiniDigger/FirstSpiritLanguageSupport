package com.github.minidigger.firstspiritlanguagesupport.formatter

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
import com.intellij.psi.formatter.common.AbstractBlock
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable
import java.util.*

class FirstSpiritTemplateBlock(
        node: @NotNull ASTNode,
        wrap: @Nullable Wrap?,
        alignment: @Nullable Alignment?,
        private val spacingBuilder: SpacingBuilder
) : AbstractBlock(node, wrap, alignment) {

    override fun buildChildren(): MutableList<Block> {
        val blocks: MutableList<Block> = ArrayList<Block>()
        var child = myNode.firstChildNode
        var previousChild: ASTNode? = null
        while (child != null) {
            if (child.elementType !== TokenType.WHITE_SPACE &&
                    (previousChild == null || previousChild.elementType !== TokenType.NEW_LINE_INDENT || child.elementType !== TokenType.NEW_LINE_INDENT)) {
                val block: Block = FirstSpiritTemplateBlock(child, Wrap.createWrap(WrapType.NORMAL, false), Alignment.createAlignment(),
                        spacingBuilder)
                blocks.add(block)
            }
            previousChild = child
            child = child.treeNext
        }
        return blocks
    }

    override fun getIndent(): Indent? {
        return Indent.getNormalIndent()
    }

    override fun getSpacing(child1: Block?, child2: Block): Spacing? {
        return spacingBuilder.getSpacing(this, child1, child2)
    }

    override fun isLeaf(): Boolean {
        return myNode.firstChildNode == null
    }
}

package com.github.minidigger.firstspiritlanguagesupport.completer

import com.intellij.lang.Commenter

class FirstSpiritTemplateCommenter : Commenter {

    override fun getLineCommentPrefix(): String? {
        return null
    }

    override fun getBlockCommentPrefix(): String? {
        return "$--"
    }

    override fun getBlockCommentSuffix(): String? {
        return "--$"
    }

    override fun getCommentedBlockCommentPrefix(): String? {
        return null
    }

    override fun getCommentedBlockCommentSuffix(): String? {
        return null
    }
}

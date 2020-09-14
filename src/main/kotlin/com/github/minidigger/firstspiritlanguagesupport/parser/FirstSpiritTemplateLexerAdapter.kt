package com.github.minidigger.firstspiritlanguagesupport.parser

import com.github.minidigger.firstspiritlanguagesupport._FirstSpiritTemplateLexer
import com.intellij.lexer.FlexAdapter

class FirstSpiritTemplateLexerAdapter : FlexAdapter(_FirstSpiritTemplateLexer(null))

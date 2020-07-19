package mango.intellij.syntax

import com.intellij.lexer.FlexAdapter

class MangoLexerAdapter : FlexAdapter(MangoLexer(null)) {

}
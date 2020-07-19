package mango.intellij.syntax

import com.intellij.psi.tree.IElementType
import mango.intellij.MangoLanguage

class MangoTokenType(
    debugName: String
) : IElementType(debugName, MangoLanguage.INSTANCE) {

    override fun toString() = "MangoTokenType." + super.toString()
}
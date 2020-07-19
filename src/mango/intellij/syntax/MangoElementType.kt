package mango.intellij.syntax

import com.intellij.psi.tree.IElementType
import mango.intellij.MangoLanguage

class MangoElementType(
    debugName: String
) : IElementType(debugName, MangoLanguage.INSTANCE) {

}
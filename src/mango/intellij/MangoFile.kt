package mango.intellij

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class MangoFile(
    viewProvider: FileViewProvider
) : PsiFileBase(viewProvider, MangoLanguage.INSTANCE) {

    override fun getFileType() = MangoFileType.INSTANCE
    override fun toString() = "mango file"
}
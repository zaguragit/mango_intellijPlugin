package mango.intellij.syntax

import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

class MangoSyntaxHighlighterFactory : SyntaxHighlighterFactory() {

    override fun getSyntaxHighlighter(
        p0: Project?,
        p1: VirtualFile?
    ) = MangoSyntaxHighlighter()
}
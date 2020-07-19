package mango.intellij.syntax

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import mango.intellij.MangoFile
import mango.intellij.MangoLanguage

class MangoParserDefinition : ParserDefinition {

    override fun createParser(p: Project?) = Parser()

    override fun createFile(f: FileViewProvider) = MangoFile(f)

    override fun getStringLiteralElements() = TokenSet.EMPTY

    override fun getFileNodeType() = FILE

    override fun createLexer(p: Project?) = MangoLexerAdapter()

    override fun createElement(node: ASTNode?) = MangoTypes.Factory.createElement(node)

    override fun getCommentTokens() = COMMENTS

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode?, right: ASTNode?) = ParserDefinition.SpaceRequirements.MAY

    override fun getWhitespaceTokens() = WHITE_SPACES

    companion object {
        val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
        val COMMENTS = TokenSet.create(MangoTypes.COMMENT)
        val FILE = IFileElementType(MangoLanguage.INSTANCE)
    }
}
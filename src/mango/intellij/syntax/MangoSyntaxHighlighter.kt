package mango.intellij.syntax

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType


class MangoSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer() = MangoLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (tokenType) {
            TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS
            MangoTypes.LINECOMMENT -> LINE_COMMENT_KEYS
            MangoTypes.BLOCKCOMMENT -> BLOCK_COMMENT_KEYS
            MangoTypes.FN, MangoTypes.VAL, MangoTypes.VAR, MangoTypes.USE, MangoTypes.IF, MangoTypes.ELSE, MangoTypes.RETURN ->
                KEYWORD_KEYS
            MangoTypes.LITERAL -> LITERAL_KEYS
            MangoTypes.ANNOTATION -> ANNOTATION_KEYS
            MangoTypes.DOT -> arrayOf(TextAttributesKey.createTextAttributesKey(
                    "MANGO_DOT", DefaultLanguageHighlighterColors.DOT))
            MangoTypes.COMMA -> arrayOf(TextAttributesKey.createTextAttributesKey(
                    "MANGO_COMMA", DefaultLanguageHighlighterColors.COMMA))
            MangoTypes.OPENROUNDBRACKET, MangoTypes.CLOSEDROUNDBRACKET -> arrayOf(TextAttributesKey.createTextAttributesKey(
                    "MANGO_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES))
            MangoTypes.OPENBRACE, MangoTypes.CLOSEDBRACE -> arrayOf(TextAttributesKey.createTextAttributesKey(
                    "MANGO_BRACES", DefaultLanguageHighlighterColors.BRACES))
            else -> EMPTY_KEYS
        }
    }

    companion object {
        private val EMPTY_KEYS = arrayOf<TextAttributesKey>()
        private val BAD_CHAR_KEYS = arrayOf(TextAttributesKey.createTextAttributesKey(
                "MANGO_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER))
        private val LINE_COMMENT_KEYS = arrayOf(TextAttributesKey.createTextAttributesKey(
                "MANGO_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT))
        private val BLOCK_COMMENT_KEYS = arrayOf(TextAttributesKey.createTextAttributesKey(
                "MANGO_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT))
        private val KEYWORD_KEYS = arrayOf(TextAttributesKey.createTextAttributesKey(
                "MANGO_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD))
        private val LITERAL_KEYS = arrayOf(TextAttributesKey.createTextAttributesKey(
                "MANGO_LITERAL", DefaultLanguageHighlighterColors.NUMBER))
        private val ANNOTATION_KEYS = arrayOf(TextAttributesKey.createTextAttributesKey(
                "MANGO_ANNOTATION", DefaultLanguageHighlighterColors.METADATA))
    }
}
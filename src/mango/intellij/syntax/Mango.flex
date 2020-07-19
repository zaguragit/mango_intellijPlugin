package mango.intellij.syntax;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import mango.intellij.syntax.MangoTypes;
import com.intellij.psi.TokenType;

%%

%class MangoLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

WHITE_SPACE=[\ \n\t\f\r]+
LINE_COMMENT="//"[^\r\n]*
BLOCK_COMMENT="/*"([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+"/"
STRING=\".*?\"
LITERAL=(true|false|[0-9]+|[0-9]*\.[0-9]+|{STRING})
IDENTIFIER=[_a-zA-Z][_a-zA-Z0-9]*
ANNOTATION=\[{IDENTIFIER}(:{WHITE_SPACE}*{LITERAL})?\]

%state WAITING_VALUE

%%

{WHITE_SPACE} {
    yybegin(YYINITIAL);
    return TokenType.WHITE_SPACE;
}

{LINE_COMMENT} {
    yybegin(YYINITIAL);
    return MangoTypes.LINECOMMENT;
}

{BLOCK_COMMENT} {
    yybegin(YYINITIAL);
    return MangoTypes.BLOCKCOMMENT;
}

{LITERAL} {
    yybegin(YYINITIAL);
    return MangoTypes.LITERAL;
}

{ANNOTATION} {
    yybegin(YYINITIAL);
    return MangoTypes.ANNOTATION;
}

fn        { yybegin(YYINITIAL); return MangoTypes.FN; }
val       { yybegin(YYINITIAL); return MangoTypes.VAL; }
var       { yybegin(YYINITIAL); return MangoTypes.VAR; }
use       { yybegin(YYINITIAL); return MangoTypes.USE; }
if        { yybegin(YYINITIAL); return MangoTypes.IF; }
else      { yybegin(YYINITIAL); return MangoTypes.ELSE; }
return    { yybegin(YYINITIAL); return MangoTypes.RETURN; }

\.        { yybegin(YYINITIAL); return MangoTypes.DOT; }
,         { yybegin(YYINITIAL); return MangoTypes.COMMA; }
//:         { yybegin(YYINITIAL); return MangoTypes.COLON; }
->        { yybegin(YYINITIAL); return MangoTypes.ARROW; }
=         { yybegin(YYINITIAL); return MangoTypes.EQUALS; }
\*        { yybegin(YYINITIAL); return MangoTypes.STAR; }

\{        { yybegin(YYINITIAL); return MangoTypes.OPENBRACE; }
\}        { yybegin(YYINITIAL); return MangoTypes.CLOSEDBRACE; }
\(        { yybegin(YYINITIAL); return MangoTypes.OPENROUNDBRACKET; }
\)        { yybegin(YYINITIAL); return MangoTypes.CLOSEDROUNDBRACKET; }
//\[        { yybegin(YYINITIAL); return MangoTypes.OPENSQUAREBRACKET; }
//\]        { yybegin(YYINITIAL); return MangoTypes.CLOSEDSQUAREBRACKET; }

([-+/*]|"=="|"!="|"<="|">="|">"|"<"|"|"|"||"|"&"|"&&"|"==="|"!==") {
    yybegin(YYINITIAL);
    return MangoTypes.BINARYOPERATOR;
}

[-!+] {
    yybegin(YYINITIAL);
    return MangoTypes.BINARYOPERATOR;
}

{IDENTIFIER} {
    yybegin(YYINITIAL);
    return MangoTypes.IDENTIFIER;
}

[^] {
    return TokenType.BAD_CHARACTER;
}
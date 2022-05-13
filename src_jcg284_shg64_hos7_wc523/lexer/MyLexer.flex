package src_jcg284_shg64_hos7_wc523.lexer;

import src_jcg284_shg64_hos7_wc523.parser.sym;
import java_cup.runtime.Symbol;


/* The generated lexer class will have an API as specified here:
 * http://jflex.de/manual.html#ScannerMethods
**/
 

%%


%public

/* the name of your lexer class */
%class MyLexer

%unicode
%pack
%cup

/* declare variables */
%{
  StringBuffer string = new StringBuffer();
  int stringLine = 0;
  int stringColumn = 0;

%} 

/* switch line and column counting on */
%line
%column

/* declare a new lexical state */
%state STRING

Whitespace = [ \t\f\r\n]
Comment    = \/\/[^\n]*
Id         = [a-zA-Z][a-zA-Z0-9'_]*
Hex        = \\x[0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F]
Char       = '([^'\n\\]|(\\[\\n\'\"])|{Hex})'
Int        = 0|[1-9][0-9]*


%% 


/* lexical rules */
<YYINITIAL> {
  {Whitespace}   { /* DO NOTHING */ }
  {Comment}     { /* DO NOTHING */ }


  \" {
    yybegin(STRING);
    string.setLength(0);
    stringLine = yyline;
    stringColumn = yycolumn;
  }

  {Int} {
    try {
      long attr = Long.parseUnsignedLong(yytext());
      return new Symbol(sym.INTEGER_LITERAL, new Token(sym.INTEGER_LITERAL, attr, yyline, yycolumn));
    } catch (NumberFormatException e) {
      return new Symbol (sym.error, new Token( 
        sym.error, "error: Int literal too big " + yytext(),
        yyline, yycolumn
      ));
    }
  }

  /* key words*/
  "use"     { return new Symbol(sym.USE, new Token(sym.USE, yytext(), yyline, yycolumn)); }
  "if"      { return new Symbol(sym.IF, new Token(sym.IF, yytext(), yyline, yycolumn)); }
  "while"   { return new Symbol(sym.WHILE, new Token(sym.WHILE, yytext(), yyline, yycolumn)); }
  "else"    { return new Symbol(sym.ELSE, new Token(sym.ELSE, yytext(), yyline, yycolumn)); }
  "return"  { return new Symbol(sym.RETURN, new Token(sym.RETURN, yytext(), yyline, yycolumn)); }
  "length"  { return new Symbol(sym.LENGTH, new Token(sym.LENGTH, yytext(), yyline, yycolumn)); }
  "int"     { return new Symbol(sym.INT, new Token(sym.INT, yytext(), yyline, yycolumn)); }
  "bool"    { return new Symbol(sym.BOOL, new Token(sym.BOOL, yytext(), yyline, yycolumn)); }
  "true"    { return new Symbol(sym.TRUE, new Token(sym.TRUE, yytext(), yyline, yycolumn)); }
  "false"   { return new Symbol(sym.FALSE, new Token(sym.FALSE, yytext(), yyline, yycolumn)); }

  // "break"   { return new Symbol(sym.BREAK, new Token(sym.BREAK, yytext(), yyline, yycolumn)); }

  {Char} {
    String s = yytext();
    s = s.substring(1, s.length() - 1);

    char attr = s.charAt(0);

    if (s.length() > 2) {
      attr = (char)Integer.parseInt(s.substring(2), 16);
    } else if (s.equals("\\n")) {
      attr = '\n';
    } else if (s.equals("\\t")) {
      attr = '\t';
    } else if (s.equals("\\'")) {
      attr = '\'';
    } else if (s.equals("\\\"")) {
      attr = '\"';
    } else if (s.equals("\\\\")) {
      attr = '\\';
    }

    return new Symbol(sym.CHARACTER_LITERAL, new Token(sym.CHARACTER_LITERAL, attr, yyline, yycolumn));
  }

  {Id} {
    return new Symbol(sym.IDENTIFIER, new Token(sym.IDENTIFIER, yytext(), yyline, yycolumn));
  }

  /* symbols*/
  "<="    { return new Symbol(sym.LEQ, new Token(sym.LEQ, yytext(), yyline, yycolumn)); }
  ">="    { return new Symbol(sym.GEQ, new Token(sym.GEQ, yytext(), yyline, yycolumn)); }
  "=="    { return new Symbol(sym.EQUAL, new Token(sym.EQUAL, yytext(), yyline, yycolumn)); }
  "\!="   { return new Symbol(sym.NOT_EQUAL, new Token(sym.NOT_EQUAL, yytext(), yyline, yycolumn)); }
  "\*>>"  { return new Symbol(sym.UPPER, new Token(sym.UPPER, yytext(), yyline, yycolumn)); }

  "\+"    { return new Symbol(sym.PLUS, new Token(sym.PLUS, yytext(), yyline, yycolumn)); }
  "-"     { return new Symbol(sym.MINUS, new Token(sym.MINUS, yytext(), yyline, yycolumn)); }
  "/"     { return new Symbol(sym.DIVIDE, new Token(sym.DIVIDE, yytext(), yyline, yycolumn)); }
  "\*"    { return new Symbol(sym.TIMES, new Token(sym.TIMES, yytext(), yyline, yycolumn)); }
  "="     { return new Symbol(sym.GETS, new Token(sym.GETS, yytext(), yyline, yycolumn)); }
  "\|"    { return new Symbol(sym.OR, new Token(sym.OR, yytext(), yyline, yycolumn)); }
  "&"     { return new Symbol(sym.AND, new Token(sym.AND, yytext(), yyline, yycolumn)); }
  "!"     { return new Symbol(sym.NOT, new Token(sym.NOT, yytext(), yyline, yycolumn)); }
  "%"     { return new Symbol(sym.MODULO, new Token(sym.MODULO, yytext(), yyline, yycolumn)); }
  "<"     { return new Symbol(sym.LT, new Token(sym.LT, yytext(), yyline, yycolumn)); }
  ">"     { return new Symbol(sym.GT, new Token(sym.GT, yytext(), yyline, yycolumn)); }
  "\["    { return new Symbol(sym.OPEN_BRACKET, new Token(sym.OPEN_BRACKET, yytext(), yyline, yycolumn)); }
  "\]"    { return new Symbol(sym.CLOSE_BRACKET, new Token(sym.CLOSE_BRACKET, yytext(), yyline, yycolumn)); }
  "\{"    { return new Symbol(sym.OPEN_BRACE, new Token(sym.OPEN_BRACE, yytext(), yyline, yycolumn)); }
  "\}"    { return new Symbol(sym.CLOSE_BRACE, new Token(sym.CLOSE_BRACE, yytext(), yyline, yycolumn)); }
  "\("    { return new Symbol(sym.OPEN_PAREN, new Token(sym.OPEN_PAREN, yytext(), yyline, yycolumn)); }
  "\)"    { return new Symbol(sym.CLOSE_PAREN, new Token(sym.CLOSE_PAREN, yytext(), yyline, yycolumn)); }
  ":"     { return new Symbol(sym.COLON, new Token(sym.COLON, yytext(), yyline, yycolumn)); }
  ";"     { return new Symbol(sym.SEMICOLON, new Token(sym.SEMICOLON, yytext(), yyline, yycolumn)); }
  "_"     { return new Symbol(sym.UNDERSCORE, new Token(sym.UNDERSCORE, yytext(), yyline, yycolumn)); }
  ","     { return new Symbol(sym.COMMA, new Token(sym.COMMA, yytext(), yyline, yycolumn)); }

  <<EOF>> { return new Symbol(sym.EOF, new Token(sym.EOF, "EOF" , yyline, yycolumn)); }

  [^] { 
    return new Symbol (sym.error, new Token( 
      sym.error, "error: Unknown token " + yytext(),
      yyline, yycolumn
    ));
  }
}

<STRING> {
    \" { 
    yybegin(YYINITIAL); 
    return new Symbol(sym.STRING_LITERAL, new Token(
      sym.STRING_LITERAL,
      string.toString(),
      stringLine,
      stringColumn
    ));
  }

    [^\n\"\\]+  { string.append(yytext()); }
    \\n         { string.append('\n'); }
    \\t         { string.append('\t'); }
    \\\"        { string.append('\"'); }
    \\\'        { string.append('\''); }
    \\\\        { string.append('\\'); }

  {Hex} {
    string.append((char)Integer.parseInt(yytext().substring(2), 16));
  }

	<<EOF>> {
		return new Symbol(sym.error, new Token(
				sym.error, "error: Unexpected EOF in string" , yyline, yycolumn - 1
		));
	}

  [^] { 
    return new Symbol(sym.error, new Token(
      sym.error, "error: Bad string", yyline, yycolumn
    ));
  }
}

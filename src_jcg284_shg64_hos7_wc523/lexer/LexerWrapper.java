package src_jcg284_shg64_hos7_wc523.lexer;

import src_jcg284_shg64_hos7_wc523.parser.*;
import java.io.*;

/**
 * Wrapper for the lexer, allowing us to pass input to the lexer and parser
 * without having the input consumed by one or the other.
 */
public class LexerWrapper implements java_cup.runtime.Scanner{
  BufferedWriter writer;
  MyLexer lexer;
  String extension;
  Boolean first;

  public LexerWrapper(BufferedWriter writer, MyLexer lexer, String extension) {
    this.writer = writer;
    this.lexer = lexer;
    this.extension = extension;
    this.first = true;
  }

  /**
   * Wrapper for the lexer's next_token method. It calls the lexer's 
   * next_token, writes the token to a diagnostic file, and returns it.
   * @return The next lexical token.
   */
  public java_cup.runtime.Symbol next_token() throws IOException, LexicalError {
    if (this.first) {
      this.first = false;
      int filetype;
      if (this.extension.equals(".ixi")) filetype = sym.IXI;
      else filetype = sym.XI;
      return new java_cup.runtime.Symbol(filetype);
    } else {
      java_cup.runtime.Symbol token = lexer.next_token();
      if (token.value == null || token.sym == sym.EOF) return token;

      Token t = (Token)token.value;

      if (writer != null) {
        writer.write(t.toString());
        writer.newLine();
        writer.flush();
      }

      if (token.sym == sym.error) {
        throw new LexicalError(t.getMessage(), t.getLine(), t.getColumn());
      }

      return token;
    }
  }
}
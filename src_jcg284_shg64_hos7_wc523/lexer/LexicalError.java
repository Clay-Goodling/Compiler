package src_jcg284_shg64_hos7_wc523.lexer;

/**
 * Exception thrown when a lexical error is encountered.
 */
public class LexicalError extends Exception {
  public int line;
  public int column;
  public String msg;

  public LexicalError(String msg, int line, int column) {
    this.line = line;
    this.column = column;
    this.msg = msg;
  }

  public String getMessage() {
    return String.format("%d:%d error: %s", line, column, msg);
  }

}
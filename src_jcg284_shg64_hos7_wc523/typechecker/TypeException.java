package src_jcg284_shg64_hos7_wc523.typechecker;

public class TypeException extends Exception {
  public int line;
  public int column;
  public String msg;

  public TypeException(String msg, int line, int column) {
    this.line = line;
    this.column = column;
    this.msg = msg;
  }

  public String getMessage() {
    return String.format("%d:%d error: %s", line, column, msg);
  }
}
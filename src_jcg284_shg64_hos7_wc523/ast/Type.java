package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;

public abstract class Type {

  /**
   * Print an S-Expression representing this AST node.
   * @param printer The output device.
   */
  public void pprint(SExpPrinter printer) {}


  /**
   * Test whether this type is a subtype of the type t.
   * @param t The type to be tested against.
   * @return whether this type is a subtype of t.
   */
  public boolean subtypeof(Type t) {
    return false;
  }

  /**
   * Test whether this is equal to the type t.
   * @param t The type to be tested against.
   * @return whether this type is a subtype of t.
   */
  public boolean equals(Type t) {
    return this.subtypeof(t) && t.subtypeof(this);
  }

  /**
   * Returns the ir encoding of the type.
   * @return the ir encoding of the type.
   */
  public String encoding() {
    return "";
  }
}

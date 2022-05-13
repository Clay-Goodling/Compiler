package src_jcg284_shg64_hos7_wc523.codeGen;

import java.util.List;
import edu.cornell.cs.cs4120.xic.ir.IRNode;

public abstract class Tile {
  public List<Assembly> asm;
  public AsmOp asmTarget;
  public int score;

  /**
   * Returns whether n is a positive power of 2 less than or equal to 8
   * 
   * @param n The integer to be tested
   */
  public static boolean isPower(long n) {
    return n == 1 || n == 2 || n == 4 || n == 8;
  }

  /**
   * Returns whether this tile covers the root of the given IR tree.
   * Has a side effect of generating the assembly representing the IR tree,
   * storing it in asm, and storing the target of the computation in asmTarget.
   * @param node The IR tree to be tested against.
   */
  public boolean matchIRTree(IRNode node, CodeGenerator cg) {
    return false;
  }
}
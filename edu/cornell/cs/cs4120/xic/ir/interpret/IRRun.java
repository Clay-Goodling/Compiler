package edu.cornell.cs.cs4120.xic.ir.interpret;

import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import edu.cornell.cs.cs4120.util.SExpPrinter;
import edu.cornell.cs.cs4120.xic.ir.IRBinOp;
import edu.cornell.cs.cs4120.xic.ir.IRBinOp.OpType;
import edu.cornell.cs.cs4120.xic.ir.IRCallStmt;
import edu.cornell.cs.cs4120.xic.ir.IRCompUnit;
import edu.cornell.cs.cs4120.xic.ir.IRConst;
import edu.cornell.cs.cs4120.xic.ir.IRFuncDecl;
import edu.cornell.cs.cs4120.xic.ir.IRMove;
import edu.cornell.cs.cs4120.xic.ir.IRName;
import edu.cornell.cs.cs4120.xic.ir.IRNodeFactory_c;
import edu.cornell.cs.cs4120.xic.ir.IRReturn;
import edu.cornell.cs.cs4120.xic.ir.IRSeq;
import edu.cornell.cs.cs4120.xic.ir.IRStmt;
import edu.cornell.cs.cs4120.xic.ir.IRTemp;
import edu.cornell.cs.cs4120.xic.ir.parse.IRLexer;
import edu.cornell.cs.cs4120.xic.ir.parse.IRParser;
import edu.cornell.cs.cs4120.xic.ir.visit.CheckCanonicalIRVisitor;
import edu.cornell.cs.cs4120.xic.ir.visit.CheckConstFoldedIRVisitor;

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

public class IRRun {
    private IRCompUnit program;

    public IRRun(IRCompUnit program) {
        this.program = program;
    }

    /**
     * Runs the IR tree compUnit on the given IRSimulator and returns the
     * result
     */
    private static void runIR(IRCompUnit compUnit) {

        // IR interpreter demo
        {
            IRSimulator sim = new IRSimulator(compUnit);
            long result = sim.call("b", 2, 1);
            System.out.println("b(2,1) == " + result);
        }

        // IR canonical checker demo
        //{
          //  CheckCanonicalIRVisitor cv = new CheckCanonicalIRVisitor();
          //  System.out.print("Canonical?: ");
          //  System.out.println(cv.visit(compUnit));
        //}

        // IR constant-folding checker demo
        //{
            // CheckConstFoldedIRVisitor cv = new CheckConstFoldedIRVisitor();
            // System.out.print("Constant-folded?: ");
            // System.out.println(cv.visit(compUnit));
        //}

        // IR parser demo: parse the code printed above back
        //IRCompUnit compUnit2 = parse(prettyPrintedProgram);
        //if (compUnit2 != null) {
          //  IRSimulator sim = new IRSimulator(compUnit2);
          //  long result = sim.call("b", 2, 1);
          //  System.out.println("b(2,1) == " + result);
        //}
    }

    public static String prettyPrint(IRCompUnit program) {
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw);
                SExpPrinter sp = new CodeWriterSExpPrinter(pw)) {
            program.printSExp(sp);
        }
        return sw.toString();
    }

    private static IRCompUnit parse(String prog) {
        try (StringReader r = new StringReader(prog)) {
            IRParser parser = new IRParser(new IRLexer(r), new IRNodeFactory_c());
            try {
                return parser.parse().<IRCompUnit>value();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e) {
                // Used by CUP to indicate an unrecoverable error.
                String msg = e.getMessage();
                if (msg != null) System.err.println("Syntax error: " + msg);
                return null;
            }
        }
    }
}

package edu.cornell.cs.cs4120.xic.ir;

import edu.cornell.cs.cs4120.util.SExpPrinter;

/** An intermediate representation for a temporary register TEMP(name) */
public class IRTemp extends IRExpr_c {
    private String name;

    /** @param name name of this temporary register */
    public IRTemp(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public String label() {
        return "TEMP(" + name + ")";
    }

    @Override
    public void printSExp(SExpPrinter p) {
        p.startList();
        p.printAtom("TEMP");
        p.printAtom(name);
        p.endList();
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override
    public boolean equals(IRExpr e) {
        return e instanceof IRTemp && ((IRTemp)e).name().equals(name);
    }

    @Override
    public IRExpr replaceSubexprs(IRExpr sub, IRTemp t) {
        return this;
    }

    @Override
    public int size() {
        return 1;
    }
}

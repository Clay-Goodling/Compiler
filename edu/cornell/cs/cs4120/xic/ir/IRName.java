package edu.cornell.cs.cs4120.xic.ir;

import edu.cornell.cs.cs4120.util.SExpPrinter;

/** An intermediate representation for named memory address NAME(n) */
public class IRName extends IRExpr_c {
    private String name;

    /** @param name name of this memory address */
    public IRName(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public String label() {
        return "NAME(" + name + ")";
    }

    @Override
    public void printSExp(SExpPrinter p) {
        p.startList();
        p.printAtom("NAME");
        p.printAtom(name);
        p.endList();
    }

    @Override
    public boolean equals(IRExpr e) {
        if(e instanceof IRName && ((IRName)e).name().equals(name)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
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

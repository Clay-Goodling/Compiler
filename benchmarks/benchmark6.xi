// Copy Propagation / Dead Code Elimination Benchmark 0

foo(x : int) {}

main(args : int[][]) {
  i : int = 0;
  while (i < 150000000) {
    a : int = 1;
    b : int = a;
    c : int = b;
    d : int = c;
    e : int = d;
    foo(e);
    f : int = e;
    g : int = f;
    h : int = g;
    i = i + 1;
  }
}
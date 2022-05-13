// Copy Propagation / Dead Code Elimination Benchmark 2
foo(x : int, y : int, z : int) {
  x1 : int = x;
  x2 : int = x1;
  x3 : int = x2;
  y1 : int = y;
  y2 : int = y1;
  y3 : int = y2;
  z1 : int = z;
  z2 : int = z1;
  z3 : int = z2;
  result : int = x3 * x3 + y3 - z3;
}
main(args : int[][]) {
  i : int = 0;
  while (i < 90000000) {
    foo(1, 2, 3);
    i = i + 1;
  }
}
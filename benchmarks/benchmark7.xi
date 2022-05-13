// Copy Propagation / Dead Code Elimination Benchmark 1

foo(w : int, x : int, y : int, z : int) {
  x = w;
  y = x;
  z = y;
}

main(args : int[][]) {
  i : int = 0;
  a : int = 1;
  b : int = 2;
  c : int = 3;
  d : int = 4;
  while (i < 120000000) {
    foo(a, b, c, d);
    i = i + 1;
  }
}
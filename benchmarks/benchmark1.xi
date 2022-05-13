// Register Allocation Benchmark 1
foo (a : int, b : int) {
  x : int = a + b
  y : int = x *>> b
  z : int = y * 2
  z = x - b
}
main(args:int[][]){
  a : int = 0 
  b : int = 2
  c : int = 3
  d : int = 4
  e : int = 5
  f : int = 6
  while(a < 100000000) {
    foo(a, b)
    a = a + 1
  }
  d = a + b - c * e / f
}
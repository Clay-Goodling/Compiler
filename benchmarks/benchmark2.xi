// Register Allocation Benchmark 2
foo (a : int, b : int) {
  c : int = 1; d : int = 2;
  bar(a, b)
  b = c + d;
}
bar (a : int, b : int) {
  a = 1
}
main(args:int[][]){
  a : int = 0
  while(a < 60000000) {
    b : int = 2
    foo(a, b)
    b = b + 1
    c : int = 1
    bar(2, 3)
    a = a + c
  }
}
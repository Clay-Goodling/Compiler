// Common Subexpression Elimination Benchmark 2

main(args:int[][]){
  a : int = 7
  b : int = 8
  c : int = 9
  d : int = 10
  f : int = c + d + b + a
  counter : int = 0
  while (counter < 350000000) {
    e : int = a + b
    counter = counter + 1
  }
}
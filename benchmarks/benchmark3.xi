// Common Subexpression Elimination Benchmark 0

main(args:int[][]){
  a : int = 2
  b : int = 5
  c : int = 7
  d : int = 8
  f : int = a + b - c * d
  counter : int = 0
  while (counter < 250000000) {
    e : int = a + b - c * d
    counter = counter + 1
  }
}
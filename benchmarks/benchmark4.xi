// Common Subexpression Elimination Benchmark 1

main(args:int[][]){
  a : int = 4
  b : int = 5
  c : int = 6
  //d : int = a + b
  f : int = a + b - c
  counter : int = 0
  while (counter < 150000000) {
    e : int = a + b
    counter = counter + 1
  }
  counter = 0
  while (counter < 150000000) {
    e : int = a + b - c
    counter = counter + 1
  }
}
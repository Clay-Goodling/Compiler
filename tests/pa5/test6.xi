// test 2 return values
use io
use conv

foo() : int, int {
  return 4, 5
}

main(args:int[][]) {
  x:int, y:int = foo()
  println(unparseInt(x))
  println(unparseInt(y))
}
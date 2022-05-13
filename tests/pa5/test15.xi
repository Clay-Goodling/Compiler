//Test method calls which return multiple values
use io
use conv

foo() : int, int {
  return 41, 20
}

main(args:int[][]) {
  x : int, y : int = foo()
  println("CS " + unparseInt(x) + unparseInt(y))
}
//more than 2 returns
use io
use conv

foo() : int, int, int{
  return 7,8,9
}

main(args:int[][]) {
  x : int, y : int, z : int = foo()
  println(unparseInt(x))
  println(unparseInt(y))
  println(unparseInt(z))
}
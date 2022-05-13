//return more than 2 values
use io
use conv

foo(a:int, b:int, c:int, d:int, e:int, f:int, g:int, h:int) : int, int, int{
  return a, e, h
}

main(args:int[][]) {
  x : int, y : int, z : int = foo(1,2,3,4,5,6,7,8)
  println(unparseInt(x))
  println(unparseInt(y))
  println(unparseInt(z))
}
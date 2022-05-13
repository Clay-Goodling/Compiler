//Test more than 6 arguments
use io
use conv

foo(a:int, b:int, c:int, d:int, e:int, f:int, g:int, h:int) : int {
  return a + b + c + d + e + f + g + h
}

main(args:int[][]) {
  y : int = 8
  x : int = foo(1, 2, 3, 4, 5, 6, 7, y)
  println(unparseInt(x)) //36
}
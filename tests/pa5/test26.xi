//Use a memory access of the result of another memory access
//works with manual linking but xthScript can't run it
use io
use conv
use test26lib

main(args : int[][]) {
  x : int = foo(21)
  println(unparseInt(x))
}
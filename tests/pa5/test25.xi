//Use a memory access of the result of another memory access
use io
use conv

main(args : int[][]) {
  a : int[] = {0, 1}
  b : int[] = {1, 2}
  println(unparseInt(b[a[1]])) // 2
}
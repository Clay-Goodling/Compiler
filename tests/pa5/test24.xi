//2 memory access in a compare
use io
use conv

main(args : int[][]) {
  a : int[] = {0, 1}
  if a[0] < a[1] {
    println("good")
  } else {
    println("bad")
  }
} 
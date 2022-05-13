//testing negatives
use io
use conv

main(args: int[][]) {
  println(unparseInt(-52)) // -52
  println(unparseInt(20 - 57)) // -37
  println(unparseInt(-60 + (-34))) // -94
}
// non-commuting binops
use io
use conv

main(args: int[][]) {
  println(unparseInt((f(1) - f(2))))
}

f(i: int): int {
  return i
}
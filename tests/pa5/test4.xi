//pass 1 argument succesfully
use io
use conv

foo(x : int) {
  print(unparseInt(x))
}

main(args:int[][]) {
  foo(5)
}
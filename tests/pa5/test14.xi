//whlie loop test
use io
use conv

main(args:int[][]){
  i : int = 0
  while (i < 100){
    i = i + 1
  }
  println(unparseInt(i))
}
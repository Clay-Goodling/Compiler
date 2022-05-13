//array tests
use io
use conv

main(args:int[][]){
  x : int[] = {1,2,3,4}
  println(unparseInt(x[0]))
  println(unparseInt(x[1]))
  println(unparseInt(x[2]))
  println(unparseInt(x[3]))
  
  y : int[2][2]
  y = {{5, 6}, {7, 8}}
  println(unparseInt(y[1][1]))
}
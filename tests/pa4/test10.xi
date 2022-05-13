//more constant folding tests
use io
use conv

main(args : int[][]) {
  println(unparseInt(0 + 0 + 0 + 0 + 0 + 0 + 0 + 0 + 0 + 0 + 0 + 0
                       + 0 + 0 + 0 + 0 + 0 + 0 + 0 + 0 + 0 + 0 + 0 
                       + 0 + 0 + 0 + 0 + 1 + 0 + 0 + 0 + 0 + 0 + 0
                       + 0 + 0 + 0 + 0 + 0 + 0 + 0 + 0 + 0 + 0 + 0))//1
  println(unparseInt(7 * 7 / 7 * 7 / 7 * 7 / 7))//7
  println(unparseInt(1 % 1 % 1 % 1 % 1 % 1))//0
  println(unparseInt(100 - 1 - 1 - 1 - 1 - 1 - 1 - 1 - 1 - 1 - 1))//90
  if(true & true & true & true & true & true & true & true & true & true) {
    println("good")
  } else {
    println("bad")
  }
  if(false | false | false | false | true | false | false | false | false) {
    println("good")
  } else {
    println("bad")
  }
  if((9001 > 9000) & (1 >= 1) & (32 < 43) & (32 <= 32) | (1==0) | (1 != 1)) {
    println("good")
  } else {
    println("bad")
  }
}
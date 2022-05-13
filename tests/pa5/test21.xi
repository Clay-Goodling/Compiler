//short circuiting test
use io
use conv

main(args : int[][]) {
  if(true | 1/0 < 1) {
    println("good")
  } else {
    println("bad")
  }
  if (false & 1/0 < 1) {
    println("bad")
  } else {
    println("good")
  }
}
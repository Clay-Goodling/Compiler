//int binop tests
use io
use conv

main(args:int[][]){
  println(unparseInt(5 + 4)) // 9
  println("Hello" + " " + "World" + "!") // Hello World!
  println(unparseInt(6 - 2)) // 4
  println(unparseInt(32 / 8)) // 4
  println(unparseInt(23 * 7)) // 161
  println(unparseInt(49 % 7)) // 0
  println(unparseInt(49 % 5)) // 4
  println(unparseInt(1234 *>> 789)) // 0, probably
  i : int = 4398046511104 // 2^42
  println(unparseInt(i *>> i)) // 2^84 >> 64 = 2^20 = 1048576

  println(foo(true == false)) // false
  println(foo(false != false)) // false
  println(foo(true & true)) //true
  println(foo(false | false)) //false

  println(foo(!(32 < 23))) //true
  println(foo(32 > 23)) //true
  println(foo(12 <= 12)) //true
  println(foo(1 >= 11)) //false
  println(foo((-1 * 10) == -10)) //true

}

foo(b: bool) : int[] {
  if (b){
    return "true"
  } else {
    return "false"
  }
}
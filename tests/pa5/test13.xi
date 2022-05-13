//bool binops, if
use io
use conv

main(args:int[][]){
  if(false) {
    println("Not Here")
  } else if(!true) {
    println("Not Here Either")
  } else if(!(6 == 6)) {
    println("Nor Here")
  } else if(9 != 9) {
    println("Getting Warmer")
  } else if(8 == 7) {
    println("Not Quite")
  } else if(4 < 4) {
    println("Try Again")
  } else if(6 <= 3) {
    println("You can tell someone had a bit too much fun writing these test")
    println("cases")
  } else if(974 > 974) {
    println("Almost there!")
  } else if(73 >= 8435) {
    println("Just kidding, still got a long ways to go")
  } else if(true & false) {
    println("This could take a while. Want to play a game?")
  } else if(false | false) {
    println("keep coding")
  } else if(false != false) {
    println("The princess is in another castle")
  } else if(true == false) {
    println("still no")
  } else if(!("Hello" != "Hello")) {
    println("getting pretty close")
  } else if("abc" == "abc") {
    println("almost there, for real this time")
  } else if(true & (true | false)) {
    println("correct")
  } else {
    println("Too far, turn back")
  }
}
//constant folding tests
use io

main(args: int[][]) {
  plus : int = 1 + 2
  minus : int = 30 - 2
  times : int = 3 * 3
  divide : int = 5 / 5
  mod : int = 62 % 3
  big : int = (1 + 3 - 4 * 6 / 3) % 4
  vars : int = big + mod - times / 4
}
// Tile Tests (Add)

use io
use conv

main(args: int[][]) {
  e1 : int = 5
  e2 : int = 10

  println(unparseInt(e1 * 4 + (e2 + 12))) // AMEPAEC
  println(unparseInt(4 * e1 + (e2 + 12))) // AMPEAEC
  println(unparseInt(e1 * 4 + (12 + e2))) // AMEPACE
  println(unparseInt(4 * e1 + (12 + e2))) // AMPEACE
  println("")

  println(unparseInt(e1 * 4 + (e2 - 12))) // AMEPSEC
  println(unparseInt(4 * e1 + (e2 - 12))) // AMPESEC
  println("")

  println(unparseInt((e2 + 12) + e1 * 4)) // AAECMEP
  println(unparseInt((e2 + 12) + 4 * e1)) // AAECMPE
  println(unparseInt((12 + e2) + e1 * 4)) // AACEMEP
  println(unparseInt((12 + e2) + 4 * e1)) // AACEMPE
  println("")

  println(unparseInt((e2 - 12) + e1 * 4)) // ASECMEP
  println(unparseInt((e2 - 12) + 4 * e1)) // ASECMPE
  println("")

  println(unparseInt((e1 * 4 + e2) + 12)) // AAMEPEC
  println(unparseInt((4 * e1 + e2) + 12)) // AAMPEEC
  println(unparseInt((e2 + e1 * 4) + 12)) // AAMEPEC
  println(unparseInt((e2 + 4 * e1) + 12)) // AAMPEEC
  println("")

  println(unparseInt(12 + (e1 * 4 + e2))) // AACMEPE
  println(unparseInt(12 + (4 * e1 + e2))) // AACMPEE
  println(unparseInt(12 + (e2 + e1 * 4))) // AACMEPE
  println(unparseInt(12 + (e2 + 4 * e1))) // AACMPEE
  println("")

  println(unparseInt((e1 * 4 + 12) + e2)) // AAMEPCE
  println(unparseInt((4 * e1 + 12) + e2)) // AAMPECE
  println(unparseInt((12 + e1 * 4) + e2)) // AAMEPCE
  println(unparseInt((12 + 4 * e1) + e2)) // AAMPECE
  println("")
  
  println(unparseInt((e1 * 4 - 12) + e2)) // ASMEPCE
  println(unparseInt((4 * e1 - 12) + e2)) // ASMPECE
  println("")

  println(unparseInt(e2 + (e1 * 4 + 12))) // AEAMEPC
  println(unparseInt(e2 + (4 * e1 + 12))) // AEAMPEC
  println(unparseInt(e2 + (12 + e1 * 4))) // AEACMEP
  println(unparseInt(e2 + (12 + 4 * e1))) // AEACMPE
  println("")

  println(unparseInt(e2 + (e1 * 4 - 12))) // AESMEPC
  println(unparseInt(e2 + (4 * e1 - 12))) // AESMPEC
  println("")

  println(unparseInt((e1 * 4 + e2) - 12)) // SAMEPEC
  println(unparseInt((4 * e1 + e2) - 12)) // SAMPEEC
  println(unparseInt((e2 + e1 * 4) - 12)) // SAMEPEC
  println(unparseInt((e2 + 4 * e1) - 12)) // SAMPEEC
  println("")

  println(unparseInt((e1 + e2) + 12))
  println(unparseInt((e1 + 12) + e2))
} 
fibHelper(nth: int, nPlusOneth: int, n: int, goal: int): int : {
  if (n >= goal) { return nth }
  else { return fibHelper(nPlusOneth, nth + + nPlusOneth, n + 1, goal) }
}

nthFibonacci(goal: int): int {
  if (goal >= 0) { return fibHelper(0, 1, 0, goal) }
  else { return 0 }
}

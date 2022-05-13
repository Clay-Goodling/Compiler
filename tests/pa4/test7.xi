use io
use conv

main(args: int[][]) {
  strings : int[2][6]
  strings = {"Runny ", "Babbit"}
  swap(strings[0], strings[1], 0, 0)
  print(strings[0])
  print(strings[1])
}

swap(arr1 : int[], arr2 : int[], i1 : int, i2 : int){
  temp : int = arr1[i1]
  arr1[i1] = arr2[i2]
  arr2[i2] = temp
}
use io

main((arg : int[][])) {
  num_rows : int = 5;
  space : int = num_rows - 1;
  row : int = 1;

  while (row <= num_rows) {
    column : int = 1;
    while (column <= space) {
      print(" ");
      column = column + 1;
    }

    space = space - 1;

    column = 1;
    while (column <= 2 * row - 1) {
      print("*");
      column = column + 1;
    }

    print("\n");
    row = row + 1;
  }
}

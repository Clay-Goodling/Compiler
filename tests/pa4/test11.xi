//commutative translation tests
use io
use conv

f() : int {
    a: int[] = {0};
    b: int[] = {0, 1};
    b[a[0]] = g(a);
    return b[0]
}

g(a: int[]): int {
    a[0] = 1;
    return 7;
}

main(args : int[][]) {
  println(unparseInt(f()))
}
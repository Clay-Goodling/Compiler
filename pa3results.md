# Summary
Test script: xthScript
  xic-build: OK
  Test collection: xic (Test --help)
    []: OK
  xic (Test --help): 1 out of 1 tests succeeded.
  Test collection: xic (Test --typecheck)
    ex01.xi: OK
    ex02.xi: OK
    ex03.xi: OK
    ex04.xi: OK
    ex05.xi: OK
    ex06.xi: OK
    ex07.xi: OK
    ex08.xi: OK
    ex09.xi: OK
    ex10.xi: OK
    ex11.xi: OK
    ex12.xi: OK
    spec1-full.xi: OK
    spec1.xi: OK
    spec2.xi: OK
    spec3.xi: OK
    gcd.xi: OK
    ratadd-full.xi: OK
    ratadd.xi: OK
    ratadduse-full.xi: OK
    ratadduse.xi: OK
    insertionsort.xi: OK
    arrayinit.xi: OK
    arrayinit2-full.xi: OK
    arrayinit2.xi: OK
    mdarrays.xi: OK
  xic (Test --typecheck): 26 out of 26 tests succeeded.
  Test collection: xic-ref (--typecheck [basic test])
    arracc01.xi: OK
    arracc02.xi: OK
    arracc03.xi: OK
    arracc04.xi: OK
    arracc05.xi: OK
    arracc06.xi: OK
    assign01.xi: OK
    assign02.xi: OK
    assign03.xi: OK
    assign04.xi: OK
    block01.xi: OK
    block02.xi: OK
    block03.xi: OK
    call01.xi: OK
    call02.xi: OK
    call03.xi: OK
    call04.xi: OK
    if01.xi: OK
    if02.xi: OK
    if03.xi: OK
    if04.xi: OK
    length01.xi: OK
    length02.xi: OK
    lit01.xi: OK
    lit02.xi: OK
    lit03.xi: OK
    lit04.xi: OK
    lit05.xi: OK
    lit06.xi: OK
    op01.xi: OK
    op02.xi: OK
    op03.xi: OK
    op04.xi: OK
    op05.xi: OK
    op06.xi: OK
    op07.xi: OK
    op08.xi: OK
    op09.xi: OK
    op10.xi: OK
    op11.xi: OK
    op12.xi: OK
    return01.xi: OK
    return02.xi: OK
    var01.xi: OK
    var02.xi: OK
    var03.xi: OK
    var04.xi: OK
    var05.xi: OK
    var06.xi: OK
    while01.xi: OK
  xic-ref (--typecheck [basic test]): 50 out of 50 tests succeeded.
  Test collection: xic-ref (--typecheck [use test])
    use01.xi: OK
    use02.xi: OK
    use03.xi: OK
    use04.xi: OK
    use05.xi: OK
  xic-ref (--typecheck [use test]): 5 out of 5 tests succeeded.
  Test collection: xic-ref (--typecheck [basic-syntax-error test])
    assign01.xi: File assign01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): assign01.xi
File assign01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f(x:int) {
  (x) = 0
}

```

## Compiler's standard output:
Syntactic error beginning at assign01.xi:2:3: 2:3 error: Unexpected token: (

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:3 error:Syntax error: unexpected (.

```

---
    assign02.xi: File assign02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): assign02.xi
File assign02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f(x:int) {
  (x)[0] = 0
}

```

## Compiler's standard output:
Syntactic error beginning at assign02.xi:2:3: 2:3 error: Unexpected token: (

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:3 error:Syntax error: unexpected (.

```

---
    assign03.xi: File assign03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): assign03.xi
File assign03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  {1,2,3}[0] = 0
}

```

## Compiler's standard output:
Syntactic error beginning at assign03.xi:2:4: 2:4 error: Unexpected token: integer 1

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:4 error:Syntax error: unexpected integer 1.

```

---
    assign04.xi: File assign04.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): assign04.xi
File assign04.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  a:int, y = f(x);
}

```

## Compiler's standard output:
Syntactic error beginning at assign04.xi:2:12: 2:12 error: Unexpected token: =

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:12 error:Syntax error: unexpected =.

```

---
    block01.xi: File block01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): block01.xi
File block01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  x:int;
  x;=;2
}

```

## Compiler's standard output:
Syntactic error beginning at block01.xi:3:4: 3:4 error: Unexpected token: ;

## Generated result for --typecheck:

## Expected result for --typecheck:

```
3:4 error:Syntax error: unexpected ;.

```

---
    block02.xi: File block02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): block02.xi
File block02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  return
  x:int
}

```

## Compiler's standard output:
Syntactic error beginning at block02.xi:3:4: 3:4 error: Unexpected token: :

## Generated result for --typecheck:

## Expected result for --typecheck:

```
3:4 error:Syntax error: unexpected :.

```

---
    call01.xi: File call01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): call01.xi
File call01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  f(,)
}

```

## Compiler's standard output:
Syntactic error beginning at call01.xi:2:5: 2:5 error: Unexpected token: ,

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:5 error:Syntax error: unexpected ,.

```

---
    call02.xi: File call02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): call02.xi
File call02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  f(,,,)
}

```

## Compiler's standard output:
Syntactic error beginning at call02.xi:2:5: 2:5 error: Unexpected token: ,

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:5 error:Syntax error: unexpected ,.

```

---
    call03.xi: File call03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): call03.xi
File call03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  f(1,)
}

```

## Compiler's standard output:
Syntactic error beginning at call03.xi:2:7: 2:7 error: Unexpected token: )

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:7 error:Syntax error: unexpected ).

```

---
    codedecl01.xi: File codedecl01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): codedecl01.xi
File codedecl01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f()

```

## Compiler's standard output:
Syntactic error beginning at codedecl01.xi:2:1: 2:1 error: Unexpected token: EOF

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:1 error:Syntax error: unexpected end of file.

```

---
    codedecl02.xi: File codedecl02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): codedecl02.xi
File codedecl02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f(): int

```

## Compiler's standard output:
Syntactic error beginning at codedecl02.xi:2:1: 2:1 error: Unexpected token: EOF

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:1 error:Syntax error: unexpected end of file.

```

---
    codedecl03.xi: File codedecl03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): codedecl03.xi
File codedecl03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f1(): int
f2()

```

## Compiler's standard output:
Syntactic error beginning at codedecl03.xi:2:1: 2:1 error: Unexpected token: id f2

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:1 error:Syntax error: unexpected id f2.

```

---
    codedecl04.xi: File codedecl04.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): codedecl04.xi
File codedecl04.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f(x1:int x2:bool) {}

```

## Compiler's standard output:
Syntactic error beginning at codedecl04.xi:1:10: 1:10 error: Unexpected token: id x2

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:10 error:Syntax error: unexpected id x2.

```

---
    codedecl05.xi: File codedecl05.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): codedecl05.xi
File codedecl05.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f(,) {}

```

## Compiler's standard output:
Syntactic error beginning at codedecl05.xi:1:3: 1:3 error: Unexpected token: ,

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:3 error:Syntax error: unexpected ,.

```

---
    codedecl06.xi: File codedecl06.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): codedecl06.xi
File codedecl06.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f(,,,) {}

```

## Compiler's standard output:
Syntactic error beginning at codedecl06.xi:1:3: 1:3 error: Unexpected token: ,

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:3 error:Syntax error: unexpected ,.

```

---
    codedecl07.xi: File codedecl07.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): codedecl07.xi
File codedecl07.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f {}

```

## Compiler's standard output:
Syntactic error beginning at codedecl07.xi:1:3: 1:3 error: Unexpected token: {

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:3 error:Syntax error: unexpected {.

```

---
    codedecl08.xi: File codedecl08.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): codedecl08.xi
File codedecl08.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f:int {
  return 0
}

```

## Compiler's standard output:
Syntactic error beginning at codedecl08.xi:1:2: 1:2 error: Unexpected token: :

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:2 error:Syntax error: unexpected :.

```

---
    codedecl09.xi: File codedecl09.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): codedecl09.xi
File codedecl09.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f: {}

```

## Compiler's standard output:
Syntactic error beginning at codedecl09.xi:1:2: 1:2 error: Unexpected token: :

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:2 error:Syntax error: unexpected :.

```

---
    codedecl10.xi: File codedecl10.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): codedecl10.xi
File codedecl10.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main(x:int,) {}

```

## Compiler's standard output:
Syntactic error beginning at codedecl10.xi:1:12: 1:12 error: Unexpected token: )

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:12 error:Syntax error: unexpected ).

```

---
    codedecl11.xi: File codedecl11.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): codedecl11.xi
File codedecl11.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main {}

```

## Compiler's standard output:
Syntactic error beginning at codedecl11.xi:1:6: 1:6 error: Unexpected token: {

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:6 error:Syntax error: unexpected {.

```

---
    codedecl12.xi: File codedecl12.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): codedecl12.xi
File codedecl12.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main : int {}

```

## Compiler's standard output:
Syntactic error beginning at codedecl12.xi:1:6: 1:6 error: Unexpected token: :

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:6 error:Syntax error: unexpected :.

```

---
    codedecl13.xi: File codedecl13.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): codedecl13.xi
File codedecl13.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main(a){}

```

## Compiler's standard output:
Syntactic error beginning at codedecl13.xi:1:7: 1:7 error: Unexpected token: )

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:7 error:Syntax error: unexpected ).

```

---
    codedecl14.xi: File codedecl14.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): codedecl14.xi
File codedecl14.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() : () {}

```

## Compiler's standard output:
Syntactic error beginning at codedecl14.xi:1:10: 1:10 error: Unexpected token: (

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:10 error:Syntax error: unexpected (.

```

---
    codedecl15.xi: File codedecl15.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): codedecl15.xi
File codedecl15.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() : (int) {}

```

## Compiler's standard output:
Syntactic error beginning at codedecl15.xi:1:10: 1:10 error: Unexpected token: (

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:10 error:Syntax error: unexpected (.

```

---
    codedecl16.xi: File codedecl16.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): codedecl16.xi
File codedecl16.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main(int) {}

```

## Compiler's standard output:
Syntactic error beginning at codedecl16.xi:1:6: 1:6 error: Unexpected token: int

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:6 error:Syntax error: unexpected int.

```

---
    codedecl17.xi: File codedecl17.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): codedecl17.xi
File codedecl17.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() : {}

```

## Compiler's standard output:
Syntactic error beginning at codedecl17.xi:1:10: 1:10 error: Unexpected token: {

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:10 error:Syntax error: unexpected {.

```

---
    empty.xi: File empty.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): empty.xi
File empty.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```

```

## Compiler's standard output:
Syntactic error beginning at empty.xi:1:1: 1:1 error: Unexpected token: EOF

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:1 error:Syntax error: unexpected end of file.

```

---
    expr01.xi: File expr01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): expr01.xi
File expr01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f(x:int) {
  x = f(,)
}

```

## Compiler's standard output:
Syntactic error beginning at expr01.xi:2:9: 2:9 error: Unexpected token: ,

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:9 error:Syntax error: unexpected ,.

```

---
    expr02.xi: File expr02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): expr02.xi
File expr02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f(x:int) {
  x = f(,,,)
}

```

## Compiler's standard output:
Syntactic error beginning at expr02.xi:2:9: 2:9 error: Unexpected token: ,

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:9 error:Syntax error: unexpected ,.

```

---
    if01.xi: File if01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): if01.xi
File if01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  if (true) return
}

```

## Compiler's standard output:
Syntactic error beginning at if01.xi:2:13: 2:13 error: Unexpected token: return

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:13 error:Syntax error: unexpected return.

```

---
    if02.xi: File if02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): if02.xi
File if02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  if (true) f() else return
}

```

## Compiler's standard output:
Syntactic error beginning at if02.xi:2:22: 2:22 error: Unexpected token: return

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:22 error:Syntax error: unexpected return.

```

---
    if03.xi: File if03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): if03.xi
File if03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  if (true);
}

```

## Compiler's standard output:
Syntactic error beginning at if03.xi:2:12: 2:12 error: Unexpected token: ;

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:12 error:Syntax error: unexpected ;.

```

---
    length01.xi: File length01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): length01.xi
File length01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  a = length(asd, ads)
}

```

## Compiler's standard output:
Syntactic error beginning at length01.xi:2:17: 2:17 error: Unexpected token: ,

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:17 error:Syntax error: unexpected ,.

```

---
    length02.xi: File length02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): length02.xi
File length02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  a = length()
}

```

## Compiler's standard output:
Syntactic error beginning at length02.xi:2:14: 2:14 error: Unexpected token: )

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:14 error:Syntax error: unexpected ).

```

---
    length03.xi: File length03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): length03.xi
File length03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  length(a)
}

```

## Compiler's standard output:
Syntactic error beginning at length03.xi:3:1: 3:1 error: Unexpected token: }

## Generated result for --typecheck:

## Expected result for --typecheck:

```
3:1 error:Syntax error: unexpected }.

```

---
    paramdecl01.xi: File paramdecl01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): paramdecl01.xi
File paramdecl01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f(x:int[1]) {}

```

## Compiler's standard output:
Syntactic error beginning at paramdecl01.xi:1:9: 1:9 error: Unexpected token: integer 1

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:9 error:Syntax error: unexpected integer 1.

```

---
    paramdecl02.xi: File paramdecl02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): paramdecl02.xi
File paramdecl02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f(x:bool[][2]) {}

```

## Compiler's standard output:
Syntactic error beginning at paramdecl02.xi:1:12: 1:12 error: Unexpected token: integer 2

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:12 error:Syntax error: unexpected integer 2.

```

---
    paramdecl03.xi: File paramdecl03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): paramdecl03.xi
File paramdecl03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f(x:int[][3][]) {}

```

## Compiler's standard output:
Syntactic error beginning at paramdecl03.xi:1:11: 1:11 error: Unexpected token: integer 3

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:11 error:Syntax error: unexpected integer 3.

```

---
    paramdecl04.xi: File paramdecl04.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): paramdecl04.xi
File paramdecl04.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f(2:int) {}

```

## Compiler's standard output:
Syntactic error beginning at paramdecl04.xi:1:3: 1:3 error: Unexpected token: integer 2

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:3 error:Syntax error: unexpected integer 2.

```

---
    use01.xi: File use01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): use01.xi
File use01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
use A

```

## Compiler's standard output:
Syntactic error beginning at use01.xi:2:1: 2:1 error: Unexpected token: EOF

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:1 error:Syntax error: unexpected end of file.

```

---
    use02.xi: File use02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): use02.xi
File use02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
use A;

```

## Compiler's standard output:
Syntactic error beginning at use02.xi:2:1: 2:1 error: Unexpected token: EOF

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:1 error:Syntax error: unexpected end of file.

```

---
    vardecl01.xi: File vardecl01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): vardecl01.xi
File vardecl01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  x:bool[][1]
}

```

## Compiler's standard output:
Syntactic error beginning at vardecl01.xi:2:12: 2:12 error: Unexpected token: integer 1

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:12 error:Syntax error: unexpected integer 1.

```

---
    vardecl02.xi: File vardecl02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): vardecl02.xi
File vardecl02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  x:bool[][1][]
}

```

## Compiler's standard output:
Syntactic error beginning at vardecl02.xi:2:12: 2:12 error: Unexpected token: integer 1

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:12 error:Syntax error: unexpected integer 1.

```

---
    vardecl03.xi: File vardecl03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): vardecl03.xi
File vardecl03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  __ = g()
}

g():int {
  return 0
}

```

## Compiler's standard output:
Syntactic error beginning at vardecl03.xi:2:4: 2:4 error: Unexpected token: _

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:4 error:Syntax error: unexpected _.

```

---
    vardecl04.xi: File vardecl04.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): vardecl04.xi
File vardecl04.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  _, x:int
}

```

## Compiler's standard output:
Syntactic error beginning at vardecl04.xi:3:1: 3:1 error: Unexpected token: }

## Generated result for --typecheck:

## Expected result for --typecheck:

```
3:1 error:Syntax error: unexpected }.

```

---
    vardecl05.xi: File vardecl05.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): vardecl05.xi
File vardecl05.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  x:int, _
}

```

## Compiler's standard output:
Syntactic error beginning at vardecl05.xi:3:1: 3:1 error: Unexpected token: }

## Generated result for --typecheck:

## Expected result for --typecheck:

```
3:1 error:Syntax error: unexpected }.

```

---
    vardecl06.xi: File vardecl06.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): vardecl06.xi
File vardecl06.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  x:int[1], _
}

```

## Compiler's standard output:
Syntactic error beginning at vardecl06.xi:2:11: 2:11 error: Unexpected token: ,

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:11 error:Syntax error: unexpected ,.

```

---
    vardecl07.xi: File vardecl07.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): vardecl07.xi
File vardecl07.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  x:int[1], y:bool[2]
}

```

## Compiler's standard output:
Syntactic error beginning at vardecl07.xi:2:11: 2:11 error: Unexpected token: ,

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:11 error:Syntax error: unexpected ,.

```

---
    vardecl08.xi: File vardecl08.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-syntax-error test]): vardecl08.xi
File vardecl08.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  x:int[1] = {1}
}

```

## Compiler's standard output:
Syntactic error beginning at vardecl08.xi:2:12: 2:12 error: Unexpected token: =

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:12 error:Syntax error: unexpected =.

```

---
  xic-ref (--typecheck [basic-syntax-error test]): 0 out of 49 tests succeeded.
  Test collection: xic-ref (--typecheck [combo-syntax-error test])
    group_of_anonymous01_01.xi: File group_of_anonymous01_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous01_01.xi
File group_of_anonymous01_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() {
 a =1 + + 2
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_01.xi:2:9: 2:9 error: Unexpected token: +

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:9 error:Syntax error: unexpected +.

```

---
    group_of_anonymous01_02.xi: File group_of_anonymous01_02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous01_02.xi
File group_of_anonymous01_02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
use a;;

main () {}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_02.xi:1:7: 1:7 error: Unexpected token: ;

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:7 error:Syntax error: unexpected ;.

```

---
    group_of_anonymous01_03.xi: File group_of_anonymous01_03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous01_03.xi
File group_of_anonymous01_03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() {
 "asd"
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_03.xi:2:2: 2:2 error: Unexpected token: string asd

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:2 error:Syntax error: unexpected string asd.

```

---
    group_of_anonymous01_04.xi: File group_of_anonymous01_04.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous01_04.xi
File group_of_anonymous01_04.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() {
  a = "asd" "asd";
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_04.xi:2:13: 2:13 error: Unexpected token: string asd

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:13 error:Syntax error: unexpected string asd.

```

---
    group_of_anonymous01_05.xi: File group_of_anonymous01_05.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous01_05.xi
File group_of_anonymous01_05.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() {
 a = 1 + 2 3
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_05.xi:2:12: 2:12 error: Unexpected token: integer 3

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:12 error:Syntax error: unexpected integer 3.

```

---
    group_of_anonymous01_06.xi: File group_of_anonymous01_06.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous01_06.xi
File group_of_anonymous01_06.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() {
  a : fin[];
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_06.xi:2:7: 2:7 error: Unexpected token: id fin

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:7 error:Syntax error: unexpected id fin.

```

---
    group_of_anonymous01_07.xi: File group_of_anonymous01_07.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous01_07.xi
File group_of_anonymous01_07.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() {
  a : fint;
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_07.xi:2:7: 2:7 error: Unexpected token: id fint

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:7 error:Syntax error: unexpected id fint.

```

---
    group_of_anonymous01_08.xi: File group_of_anonymous01_08.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous01_08.xi
File group_of_anonymous01_08.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() {
 f();;
 }

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_08.xi:2:6: 2:6 error: Unexpected token: ;

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:6 error:Syntax error: unexpected ;.

```

---
    group_of_anonymous01_09.xi: File group_of_anonymous01_09.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous01_09.xi
File group_of_anonymous01_09.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main () {
while(a)
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_09.xi:3:1: 3:1 error: Unexpected token: }

## Generated result for --typecheck:

## Expected result for --typecheck:

```
3:1 error:Syntax error: unexpected }.

```

---
    group_of_anonymous01_10.xi: File group_of_anonymous01_10.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous01_10.xi
File group_of_anonymous01_10.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() {
 while()
 f()
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_10.xi:2:8: 2:8 error: Unexpected token: )

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:8 error:Syntax error: unexpected ).

```

---
    group_of_anonymous01_11.xi: File group_of_anonymous01_11.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous01_11.xi
File group_of_anonymous01_11.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() {
 if (asd)
 else
 f()
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_11.xi:3:2: 3:2 error: Unexpected token: else

## Generated result for --typecheck:

## Expected result for --typecheck:

```
3:2 error:Syntax error: unexpected else.

```

---
    group_of_anonymous01_12.xi: File group_of_anonymous01_12.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous01_12.xi
File group_of_anonymous01_12.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() {
if () {}
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_12.xi:2:5: 2:5 error: Unexpected token: )

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:5 error:Syntax error: unexpected ).

```

---
    group_of_anonymous01_13.xi: File group_of_anonymous01_13.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous01_13.xi
File group_of_anonymous01_13.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() {}; main2() {}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_13.xi:1:10: 1:10 error: Unexpected token: ;

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:10 error:Syntax error: unexpected ;.

```

---
    group_of_anonymous01_14.xi: File group_of_anonymous01_14.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous01_14.xi
File group_of_anonymous01_14.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() : (int, int) {}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_14.xi:1:10: 1:10 error: Unexpected token: (

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:10 error:Syntax error: unexpected (.

```

---
    group_of_anonymous01_15.xi: File group_of_anonymous01_15.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous01_15.xi
File group_of_anonymous01_15.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main(a: notype) {}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_15.xi:1:9: 1:9 error: Unexpected token: id notype

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:9 error:Syntax error: unexpected id notype.

```

---
    group_of_anonymous01_16.xi: File group_of_anonymous01_16.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous01_16.xi
File group_of_anonymous01_16.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() : notype {}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_16.xi:1:10: 1:10 error: Unexpected token: id notype

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:10 error:Syntax error: unexpected id notype.

```

---
    group_of_anonymous01_17.xi: File group_of_anonymous01_17.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous01_17.xi
File group_of_anonymous01_17.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() : int a {}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_17.xi:1:14: 1:14 error: Unexpected token: id a

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:14 error:Syntax error: unexpected id a.

```

---
    group_of_anonymous01_18.xi: File group_of_anonymous01_18.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous01_18.xi
File group_of_anonymous01_18.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() : int, {}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_18.xi:1:15: 1:15 error: Unexpected token: {

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:15 error:Syntax error: unexpected {.

```

---
    group_of_anonymous01_19.xi: File group_of_anonymous01_19.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous01_19.xi
File group_of_anonymous01_19.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main()
  return(a);

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_19.xi:2:3: 2:3 error: Unexpected token: return

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:3 error:Syntax error: unexpected return.

```

---
    group_of_anonymous02_01.xi: File group_of_anonymous02_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous02_01.xi
File group_of_anonymous02_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
use io

validFunction(arg: bool[][][]) {
    print("This is a valid function");
    return;
}
main(args: int[][]) {
    printab("Hello, World\n";
}


```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous02_01.xi:8:29: 8:29 error: Unexpected token: ;

## Generated result for --typecheck:

## Expected result for --typecheck:

```
8:29 error:Syntax error: unexpected ;.

```

---
    group_of_anonymous03_01.xi: File group_of_anonymous03_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous03_01.xi
File group_of_anonymous03_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
use test

asdf(){
    x= x&&x;
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous03_01.xi:4:10: 4:10 error: Unexpected token: &

## Generated result for --typecheck:

## Expected result for --typecheck:

```
4:10 error:Syntax error: unexpected &.

```

---
    group_of_anonymous03_02.xi: File group_of_anonymous03_02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous03_02.xi
File group_of_anonymous03_02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
foo() {
a = - 123;
_ = 4
_a = 5;
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous03_02.xi:4:2: 4:2 error: Unexpected token: id a

## Generated result for --typecheck:

## Expected result for --typecheck:

```
4:2 error:Syntax error: unexpected id a.

```

---
    group_of_anonymous04_01.xi: File group_of_anonymous04_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous04_01.xi
File group_of_anonymous04_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
foo() {
    foo();;;;;;;;;;
    ;;;;;;;;bar();;;;;;;
    return;;;;;;;;;;;;;;;;;;;;;;;;;;
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous04_01.xi:2:11: 2:11 error: Unexpected token: ;

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:11 error:Syntax error: unexpected ;.

```

---
    group_of_anonymous05_01.xi: File group_of_anonymous05_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous05_01.xi
File group_of_anonymous05_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
use x;
use y;

foo() {}

bar() {}

main() {}

use bogus; //error

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous05_01.xi:10:1: 10:1 error: Unexpected token: use

## Generated result for --typecheck:

## Expected result for --typecheck:

```
10:1 error:Syntax error: unexpected use.

```

---
    group_of_anonymous06_01.xi: File group_of_anonymous06_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous06_01.xi
File group_of_anonymous06_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
use use

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous06_01.xi:1:5: 1:5 error: Unexpected token: use

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:5 error:Syntax error: unexpected use.

```

---
    group_of_anonymous06_02.xi: File group_of_anonymous06_02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous06_02.xi
File group_of_anonymous06_02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
use gary
main(a:length) {}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous06_02.xi:2:8: 2:8 error: Unexpected token: length

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:8 error:Syntax error: unexpected length.

```

---
    group_of_anonymous06_03.xi: File group_of_anonymous06_03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous06_03.xi
File group_of_anonymous06_03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
use gary
main(false:int) {}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous06_03.xi:2:6: 2:6 error: Unexpected token: false

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:6 error:Syntax error: unexpected false.

```

---
    group_of_anonymous06_04.xi: File group_of_anonymous06_04.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous06_04.xi
File group_of_anonymous06_04.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
use nothing;

main() {
    x: int[] = "You can't have semi colons after methods can you?";
};

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous06_04.xi:5:2: 5:2 error: Unexpected token: ;

## Generated result for --typecheck:

## Expected result for --typecheck:

```
5:2 error:Syntax error: unexpected ;.

```

---
    group_of_anonymous06_05.xi: File group_of_anonymous06_05.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous06_05.xi
File group_of_anonymous06_05.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
only_else(){
    if(a<b)
        a=a+1
    else
        b = --b
    else //incorrect
        b = b*b
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous06_05.xi:6:5: 6:5 error: Unexpected token: else

## Generated result for --typecheck:

## Expected result for --typecheck:

```
6:5 error:Syntax error: unexpected else.

```

---
    group_of_anonymous06_06.xi: File group_of_anonymous06_06.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous06_06.xi
File group_of_anonymous06_06.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() {
    a = a[92233720368547758089][0]
}

```

## Compiler's standard output:
Lexical error beginning at group_of_anonymous06_06.xi:2:11: 2:11 error: error: Int literal too big 92233720368547758089

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:11 error:Integer literal "92233720368547758089" out of range.

```

---
    group_of_anonymous06_07.xi: File group_of_anonymous06_07.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous06_07.xi
File group_of_anonymous06_07.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
use anu use 1;

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous06_07.xi:1:13: 1:13 error: Unexpected token: integer 1

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:13 error:Syntax error: unexpected integer 1.

```

---
    group_of_anonymous07_01.xi: File group_of_anonymous07_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous07_01.xi
File group_of_anonymous07_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
fail_on_bad_decl() {
    x:int[3] = {1, 2, 3} // Will fail because can't initialize indexed array
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous07_01.xi:2:14: 2:14 error: Unexpected token: =

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:14 error:Syntax error: unexpected =.

```

---
    group_of_anonymous08_01.xi: File group_of_anonymous08_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous08_01.xi
File group_of_anonymous08_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
fibHelper(nth: int, nPlusOneth: int, n: int, goal: int): int : {
  if (n >= goal) { return nth }
  else { return fibHelper(nPlusOneth, nth + + nPlusOneth, n + 1, goal) }
}

nthFibonacci(goal: int): int {
  if (goal >= 0) { return fibHelper(0, 1, 0, goal) }
  else { return 0 }
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous08_01.xi:1:62: 1:62 error: Unexpected token: :

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:62 error:Syntax error: unexpected :.

```

---
    group_of_anonymous08_02.xi: File group_of_anonymous08_02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous08_02.xi
File group_of_anonymous08_02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
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

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous08_02.xi:3:6: 3:6 error: Unexpected token: (

## Generated result for --typecheck:

## Expected result for --typecheck:

```
3:6 error:Syntax error: unexpected (.

```

---
    group_of_anonymous09_01.xi: File group_of_anonymous09_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous09_01.xi
File group_of_anonymous09_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
// Sometimes I like to dig a hole in my backyard and pretend I'm a carrot

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous09_01.xi:2:1: 2:1 error: Unexpected token: EOF

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:1 error:Syntax error: unexpected end of file.

```

---
    group_of_anonymous10_01.xi: File group_of_anonymous10_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous10_01.xi
File group_of_anonymous10_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main(args: int[][]) {
  (
}


```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous10_01.xi:2:3: 2:3 error: Unexpected token: (

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:3 error:Syntax error: unexpected (.

```

---
    group_of_anonymous10_02.xi: File group_of_anonymous10_02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous10_02.xi
File group_of_anonymous10_02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main(args: int[][]) {
  10 = 11
}


```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous10_02.xi:2:3: 2:3 error: Unexpected token: integer 10

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:3 error:Syntax error: unexpected integer 10.

```

---
    group_of_anonymous10_03.xi: File group_of_anonymous10_03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous10_03.xi
File group_of_anonymous10_03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main(args: int[][]) {
  return
  return
}


```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous10_03.xi:3:3: 3:3 error: Unexpected token: return

## Generated result for --typecheck:

## Expected result for --typecheck:

```
3:3 error:Syntax error: unexpected return.

```

---
    group_of_anonymous11_01.xi: File group_of_anonymous11_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous11_01.xi
File group_of_anonymous11_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  x:int[[]
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous11_01.xi:2:9: 2:9 error: Unexpected token: [

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:9 error:Syntax error: unexpected [.

```

---
    group_of_anonymous11_02.xi: File group_of_anonymous11_02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous11_02.xi
File group_of_anonymous11_02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  x:int[][
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous11_02.xi:3:1: 3:1 error: Unexpected token: }

## Generated result for --typecheck:

## Expected result for --typecheck:

```
3:1 error:Syntax error: unexpected }.

```

---
    group_of_anonymous11_03.xi: File group_of_anonymous11_03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous11_03.xi
File group_of_anonymous11_03.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  {
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous11_03.xi:3:2: 3:2 error: Unexpected token: EOF

## Generated result for --typecheck:

## Expected result for --typecheck:

```
3:2 error:Syntax error: unexpected end of file.

```

---
    group_of_anonymous11_04.xi: File group_of_anonymous11_04.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [combo-syntax-error test]): group_of_anonymous11_04.xi
File group_of_anonymous11_04.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  a: int;
  b:
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous11_04.xi:4:1: 4:1 error: Unexpected token: }

## Generated result for --typecheck:

## Expected result for --typecheck:

```
4:1 error:Syntax error: unexpected }.

```

---
  xic-ref (--typecheck [combo-syntax-error test]): 0 out of 42 tests succeeded.
  Test collection: xic-ref (--typecheck [extension-syntax-error test (might succeed)])
    group_of_anonymous01_01.xi: File group_of_anonymous01_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [extension-syntax-error test (might succeed)]): group_of_anonymous01_01.xi
File group_of_anonymous01_01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
main() {
  x = y = 2
}

```

## Compiler's standard output:
Syntactic error beginning at group_of_anonymous01_01.xi:2:9: 2:9 error: Unexpected token: =

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:9 error:Syntax error: unexpected =.

```

---
    vardecl01.xi: File vardecl01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [extension-syntax-error test (might succeed)]): vardecl01.xi
File vardecl01.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f() {
  _:int = g()
}

g():int {
  return 0
}

```

## Compiler's standard output:
Syntactic error beginning at vardecl01.xi:2:4: 2:4 error: Unexpected token: :

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:4 error:Syntax error: unexpected :.

```

---
  xic-ref (--typecheck [extension-syntax-error test (might succeed)]): 0 out of 2 tests succeeded.
  Test collection: xic-ref (--typecheck [basic-expr-error test])
    arracc01.xi: OK
    arracc02.xi: OK
    arracc03.xi: OK
    arracc04.xi: OK
    arracc05.xi: OK
    arracc06.xi: OK
    arracc07.xi: OK
    call01.xi: OK
    call02.xi: OK
    call03.xi: OK
    call04.xi: OK
    call05.xi: OK
    call06.xi: OK
    call07.xi: OK
    call08.xi: OK
    call09.xi: OK
    call10.xi: OK
    call11.xi: OK
    call12.xi: OK
    length01.xi: OK
    length02.xi: OK
    length03.xi: OK
    length04.xi: OK
    length05.xi: OK
    length06.xi: OK
    length07.xi: OK
    length08.xi: OK
    length09.xi: OK
    length10.xi: OK
    lit01.xi: OK
    lit02.xi: OK
    lit03.xi: OK
    lit04.xi: OK
    lit05.xi: OK
    lit06.xi: OK
    lit07.xi: OK
    lit08.xi: OK
    lit09.xi: OK
    lit10.xi: OK
    lit11.xi: OK
    lit12.xi: OK
    op01.xi: OK
    op02.xi: OK
    op03.xi: OK
    op04.xi: OK
    op05.xi: OK
    op06.xi: OK
    op07.xi: OK
    op08.xi: OK
    op09.xi: OK
    op10.xi: OK
    op11.xi: OK
    op12.xi: OK
    op13.xi: OK
    op14.xi: OK
    op15.xi: OK
    op16.xi: OK
    op17.xi: OK
    op18.xi: OK
    op19.xi: OK
    op20.xi: OK
    op21.xi: OK
    op22.xi: OK
    op23.xi: OK
    op24.xi: OK
    op25.xi: OK
    op26.xi: OK
    op27.xi: OK
    op28.xi: OK
    op29.xi: OK
    op30.xi: OK
    op31.xi: OK
    op32.xi: OK
    op33.xi: OK
    op34.xi: OK
    op35.xi: OK
    op36.xi: OK
    op37.xi: OK
    op38.xi: OK
    op39.xi: OK
    op40.xi: OK
    op41.xi: OK
    op42.xi: OK
    op43.xi: OK
    op44.xi: OK
    op45.xi: OK
    op46.xi: OK
    op47.xi: OK
    op48.xi: OK
    op49.xi: OK
    op50.xi: OK
    op51.xi: OK
    op52.xi: OK
    op53.xi: OK
    op54.xi: OK
    op55.xi: OK
    op56.xi: OK
    op57.xi: OK
    op58.xi: OK
    op59.xi: OK
    op60.xi: OK
    var01.xi: OK
    var02.xi: OK
    var03.xi: OK
    var04.xi: OK
    var05.xi: OK
    var06.xi: OK
    var07.xi: OK
    var08.xi: OK
    var09.xi: OK
    var10.xi: OK
  xic-ref (--typecheck [basic-expr-error test]): 111 out of 111 tests succeeded.
  Test collection: xic-ref (--typecheck [basic-stmt-error test])
    assign01.xi: OK
    assign02.xi: OK
    assign03.xi: OK
    assign04.xi: OK
    assign05.xi: OK
    assign06.xi: OK
    assign07.xi: OK
    assign08.xi: OK
    assign09.xi: OK
    assign10.xi: OK
    assign11.xi: OK
    assign12.xi: OK
    assign13.xi: OK
    assign14.xi: OK
    assign15.xi: OK
    assign16.xi: OK
    assign17.xi: OK
    assign18.xi: OK
    assign19.xi: OK
    assign20.xi: OK
    assign21.xi: OK
    assign22.xi: OK
    assign23.xi: OK
    assign24.xi: OK
    assign25.xi: OK
    assign26.xi: OK
    assign27.xi: OK
    assign28.xi: OK
    assign29.xi: OK
    assign30.xi: OK
    assign31.xi: OK
    assign32.xi: OK
    assign33.xi: OK
    assign34.xi: OK
    assign35.xi: OK
    assign36.xi: OK
    assign37.xi: OK
    assign38.xi: OK
    assign39.xi: OK
    assign40.xi: OK
    assign41.xi: OK
    assign42.xi: OK
    assign43.xi: OK
    assign44.xi: OK
    assign45.xi: OK
    assign46.xi: OK
    assign47.xi: OK
    assign48.xi: OK
    assign49.xi: OK
    assign50.xi: OK
    assign51.xi: OK
    assign52.xi: OK
    assign53.xi: OK
    assign54.xi: OK
    assign55.xi: OK
    assign56.xi: OK
    assign57.xi: OK
    assign58.xi: OK
    assign59.xi: OK
    assign60.xi: OK
    assign61.xi: OK
    assign62.xi: OK
    assign63.xi: OK
    assign64.xi: OK
    assign65.xi: OK
    assign66.xi: OK
    assign67.xi: OK
    assign68.xi: OK
    assign69.xi: OK
    assign70.xi: OK
    assign71.xi: OK
    assign72.xi: OK
    assign73.xi: OK
    assign74.xi: OK
    assign75.xi: OK
    block01.xi: OK
    block02.xi: File block02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-stmt-error test]): block02.xi
File block02.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
foo() {
  return
  foo()
  foo()
  foo()
}

```

## Compiler's standard output:
Syntactic error beginning at block02.xi:4:3: 4:3 error: Unexpected token: id foo

## Generated result for --typecheck:

## Expected result for --typecheck:

```
4:3 error:Syntax error: unexpected id foo.

```

---
    block03.xi: OK
    call01.xi: OK
    call02.xi: OK
    call03.xi: Mismatch detected at line 1 of file call03.typed.nml
expected: : error:
found   : Valid Xi Program

---
# xic-ref (--typecheck [basic-stmt-error test]): call03.xi
Mismatch detected at line 1 of file call03.typed.nml
expected: : error:
found   : Valid Xi Program
## Command line without filenames:
xic --typecheck
## Content of test case:

```
foo() {
  f()
}

f(): int {
  return 0
}

```

## Generated result for --typecheck:

```
Valid Xi Program

```

## Expected result for --typecheck:

```
2:3 error:f is not a procedure

```

---
    call04.xi: OK
    call05.xi: OK
    call06.xi: Mismatch detected at line 1 of file call06.typed.nml
expected: : error:
found   : Valid Xi Program

---
# xic-ref (--typecheck [basic-stmt-error test]): call06.xi
Mismatch detected at line 1 of file call06.typed.nml
expected: : error:
found   : Valid Xi Program
## Command line without filenames:
xic --typecheck
## Content of test case:

```
foo() {
  f(0)
}

f(x: int): int {
  return 0
}

```

## Generated result for --typecheck:

```
Valid Xi Program

```

## Expected result for --typecheck:

```
2:3 error:f is not a procedure

```

---
    call07.xi: OK
    call08.xi: OK
    call09.xi: OK
    call10.xi: OK
    call11.xi: OK
    if01.xi: OK
    if02.xi: OK
    if03.xi: OK
    if04.xi: OK
    if05.xi: OK
    return01.xi: OK
    return02.xi: OK
    return03.xi: OK
    return04.xi: File return04.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-stmt-error test]): return04.xi
File return04.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f(): int {
  return
}

```

## Compiler's standard error:
java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
	at java.base/java.util.Objects.checkIndex(Objects.java:372)
	at java.base/java.util.ArrayList.get(ArrayList.java:459)
	at src_jcg284_shg64_hos7_wc523.visitor.TypeChecker.exitReturn(TypeChecker.java:554)
	at src_jcg284_shg64_hos7_wc523.ast.Return.accept(Return.java:42)
	at src_jcg284_shg64_hos7_wc523.ast.Block.accept(Block.java:50)
	at src_jcg284_shg64_hos7_wc523.ast.Method.accept(Method.java:64)
	at src_jcg284_shg64_hos7_wc523.ast.Program.accept(Program.java:54)
	at src_jcg284_shg64_hos7_wc523.main.XIC.main(XIC.java:184)

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:3 error:Mismatched number of values: expected 1, but found 0

```

---
    return05.xi: OK
    return06.xi: OK
    return07.xi: File return07.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-stmt-error test]): return07.xi
File return07.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f(): bool {
  return
}

```

## Compiler's standard error:
java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
	at java.base/java.util.Objects.checkIndex(Objects.java:372)
	at java.base/java.util.ArrayList.get(ArrayList.java:459)
	at src_jcg284_shg64_hos7_wc523.visitor.TypeChecker.exitReturn(TypeChecker.java:554)
	at src_jcg284_shg64_hos7_wc523.ast.Return.accept(Return.java:42)
	at src_jcg284_shg64_hos7_wc523.ast.Block.accept(Block.java:50)
	at src_jcg284_shg64_hos7_wc523.ast.Method.accept(Method.java:64)
	at src_jcg284_shg64_hos7_wc523.ast.Program.accept(Program.java:54)
	at src_jcg284_shg64_hos7_wc523.main.XIC.main(XIC.java:184)

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:3 error:Mismatched number of values: expected 1, but found 0

```

---
    return08.xi: OK
    return09.xi: OK
    return10.xi: File return10.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-stmt-error test]): return10.xi
File return10.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f(): int[] {
  return
}

```

## Compiler's standard error:
java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
	at java.base/java.util.Objects.checkIndex(Objects.java:372)
	at java.base/java.util.ArrayList.get(ArrayList.java:459)
	at src_jcg284_shg64_hos7_wc523.visitor.TypeChecker.exitReturn(TypeChecker.java:554)
	at src_jcg284_shg64_hos7_wc523.ast.Return.accept(Return.java:42)
	at src_jcg284_shg64_hos7_wc523.ast.Block.accept(Block.java:50)
	at src_jcg284_shg64_hos7_wc523.ast.Method.accept(Method.java:64)
	at src_jcg284_shg64_hos7_wc523.ast.Program.accept(Program.java:54)
	at src_jcg284_shg64_hos7_wc523.main.XIC.main(XIC.java:184)

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:3 error:Mismatched number of values: expected 1, but found 0

```

---
    return11.xi: OK
    return12.xi: OK
    return13.xi: OK
    return14.xi: OK
    return15.xi: OK
    return16.xi: OK
    return17.xi: File return17.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [basic-stmt-error test]): return17.xi
File return17.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic --typecheck
## Content of test case:

```
f(): int, bool {
  return
}

```

## Compiler's standard error:
java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
	at java.base/java.util.Objects.checkIndex(Objects.java:372)
	at java.base/java.util.ArrayList.get(ArrayList.java:459)
	at src_jcg284_shg64_hos7_wc523.visitor.TypeChecker.exitReturn(TypeChecker.java:554)
	at src_jcg284_shg64_hos7_wc523.ast.Return.accept(Return.java:42)
	at src_jcg284_shg64_hos7_wc523.ast.Block.accept(Block.java:50)
	at src_jcg284_shg64_hos7_wc523.ast.Method.accept(Method.java:64)
	at src_jcg284_shg64_hos7_wc523.ast.Program.accept(Program.java:54)
	at src_jcg284_shg64_hos7_wc523.main.XIC.main(XIC.java:184)

## Generated result for --typecheck:

## Expected result for --typecheck:

```
2:3 error:Mismatched number of values: expected 2, but found 0

```

---
    return18.xi: OK
    var01.xi: OK
    var02.xi: OK
    var03.xi: Mismatch detected at line 1 of file var03.typed.nml
expected: : error:
found   : Valid Xi Program

---
# xic-ref (--typecheck [basic-stmt-error test]): var03.xi
Mismatch detected at line 1 of file var03.typed.nml
expected: : error:
found   : Valid Xi Program
## Command line without filenames:
xic --typecheck
## Content of test case:

```
foo() {
  foo: int
}

```

## Generated result for --typecheck:

```
Valid Xi Program

```

## Expected result for --typecheck:

```
2:3 error:foo already defined

```

---
    var04.xi: OK
    var05.xi: OK
    var06.xi: Mismatch detected at line 1 of file var06.typed.nml
expected: : error:
found   : Valid Xi Program

---
# xic-ref (--typecheck [basic-stmt-error test]): var06.xi
Mismatch detected at line 1 of file var06.typed.nml
expected: : error:
found   : Valid Xi Program
## Command line without filenames:
xic --typecheck
## Content of test case:

```
foo() {
  foo: int = 0
}

```

## Generated result for --typecheck:

```
Valid Xi Program

```

## Expected result for --typecheck:

```
2:3 error:foo already defined

```

---
    var07.xi: OK
    var08.xi: Mismatch detected at line 1 of file var08.typed.nml
expected: : error:
found   : Valid Xi Program

---
# xic-ref (--typecheck [basic-stmt-error test]): var08.xi
Mismatch detected at line 1 of file var08.typed.nml
expected: : error:
found   : Valid Xi Program
## Command line without filenames:
xic --typecheck
## Content of test case:

```
foo() {
  x: int[true]
}

```

## Generated result for --typecheck:

```
Valid Xi Program

```

## Expected result for --typecheck:

```
2:10 error:Expected int, but found bool

```

---
    var09.xi: Mismatch detected at line 1 of file var09.typed.nml
expected: : error:
found   : Valid Xi Program

---
# xic-ref (--typecheck [basic-stmt-error test]): var09.xi
Mismatch detected at line 1 of file var09.typed.nml
expected: : error:
found   : Valid Xi Program
## Command line without filenames:
xic --typecheck
## Content of test case:

```
foo() {
  foo: int[0]
}

```

## Generated result for --typecheck:

```
Valid Xi Program

```

## Expected result for --typecheck:

```
2:3 error:foo already defined

```

---
    var10.xi: OK
    var11.xi: OK
    var12.xi: OK
    var13.xi: OK
    var14.xi: Mismatch detected at line 1 of file var14.typed.nml
expected: : error:
found   : Valid Xi Program

---
# xic-ref (--typecheck [basic-stmt-error test]): var14.xi
Mismatch detected at line 1 of file var14.typed.nml
expected: : error:
found   : Valid Xi Program
## Command line without filenames:
xic --typecheck
## Content of test case:

```
foo() {
  _ = f2();
}

f2(): int, bool {
  return 0, true
}

```

## Generated result for --typecheck:

```
Valid Xi Program

```

## Expected result for --typecheck:

```
2:3 error:Mismatched number of values: expected 1, but found 2

```

---
    var15.xi: OK
    var16.xi: Mismatch detected at line 1 of file var16.typed.nml
expected: : error:
found   : Valid Xi Program

---
# xic-ref (--typecheck [basic-stmt-error test]): var16.xi
Mismatch detected at line 1 of file var16.typed.nml
expected: : error:
found   : Valid Xi Program
## Command line without filenames:
xic --typecheck
## Content of test case:

```
foo() {
  x: int, foo: bool = f2();
}

f2(): int, bool {
  return 0, true
}

```

## Generated result for --typecheck:

```
Valid Xi Program

```

## Expected result for --typecheck:

```
2:11 error:foo already defined

```

---
    var17.xi: OK
    var18.xi: Mismatch detected at line 1 of file var18.typed.nml
expected: : error:
found   : Valid Xi Program

---
# xic-ref (--typecheck [basic-stmt-error test]): var18.xi
Mismatch detected at line 1 of file var18.typed.nml
expected: : error:
found   : Valid Xi Program
## Command line without filenames:
xic --typecheck
## Content of test case:

```
foo() {
  x: int = x
}

```

## Generated result for --typecheck:

```
Valid Xi Program

```

## Expected result for --typecheck:

```
2:12 error:Name x not found

```

---
    while01.xi: OK
    while02.xi: OK
  xic-ref (--typecheck [basic-stmt-error test]): 118 out of 132 tests succeeded.
  Test collection: xic-ref (--typecheck [use-error test])
    decl01.xi: OK
    decl02.xi: OK
    decl03.xi: OK
    decl04.xi: File decl04.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (--typecheck [use-error test]): decl04.xi
File decl04.typed does not exist in directory shared/xthtest/pa3/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic -libpath ../../../../pa/pa3/grading/tests/use-error --typecheck
## Content of test case:

```
f(f: int): int {
  return 0
}

```

## Compiler's standard error:
java.lang.ClassCastException: class src_jcg284_shg64_hos7_wc523.ast.IntType cannot be cast to class src_jcg284_shg64_hos7_wc523.ast.FunctionType (src_jcg284_shg64_hos7_wc523.ast.IntType and src_jcg284_shg64_hos7_wc523.ast.FunctionType are in unnamed module of loader 'app')
	at src_jcg284_shg64_hos7_wc523.visitor.TypeChecker.exitMethod(TypeChecker.java:436)
	at src_jcg284_shg64_hos7_wc523.ast.Method.accept(Method.java:65)
	at src_jcg284_shg64_hos7_wc523.ast.Program.accept(Program.java:54)
	at src_jcg284_shg64_hos7_wc523.main.XIC.main(XIC.java:184)

## Generated result for --typecheck:

## Expected result for --typecheck:

```
1:3 error:f already defined

```

---
    decl05.xi: OK
    use01.xi: OK
    use02.xi: OK
    use03.xi: OK
    use04.xi: OK
    use05.xi: OK
    use06.xi: OK
    use07.xi: OK
  xic-ref (--typecheck [use-error test]): 11 out of 12 tests succeeded.
xthScript: 323 out of 431 tests succeeded.

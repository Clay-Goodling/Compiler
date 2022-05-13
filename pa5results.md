# Summary
Test script: xthScript
  xic-build: OK
  Test collection: xic (Test --help)
    []: OK
  xic (Test --help): 1 out of 1 tests succeeded.
  Test collection: xic (Test -target linux)
    ex01.xi: OK
    ack.xi: OK
    primes.xi: OK
  xic (Test -target linux): 3 out of 3 tests succeeded.
Has addressing mode: false
  Test collection: xic (Test -target linux -O)
    ex01.xi: OK
    ack.xi: OK
    primes.xi: OK
  xic (Test -target linux -O): 3 out of 3 tests succeeded.
Has addressing mode: false
  Test collection: xic-ref (-target linux [pretest])
    test_conv.xi: OK
    test_io.xi: OK
  xic-ref (-target linux [pretest]): 2 out of 2 tests succeeded.
Has addressing mode: false
  Test collection: xic-ref (-target linux -O [pretest])
    test_conv.xi: OK
    test_io.xi: OK
  xic-ref (-target linux -O [pretest]): 2 out of 2 tests succeeded.
Has addressing mode: false
  Test collection: xic-ref (-target linux [basic test])
    arracc01.xi: OK
    arracc02.xi: OK
    arracc03.xi: OK
    arracc04.xi: OK
    arracc05.xi: OK
    arracc06.xi: OK
    arracc07.xi: OK
    arracc08.xi: OK
    arrinit01.xi: OK
    arrinit02.xi: OK
    arrinit03.xi: OK
    arrinit04.xi: OK
    arrinit05.xi: OK
    arrinit06.xi: OK
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
    binary01.xi: OK
    binary02.xi: OK
    binary03.xi: OK
    binary04.xi: OK
    binary05.xi: OK
    binary06.xi: OK
    binary07.xi: OK
    binary08.xi: OK
    binary09.xi: OK
    binary10.xi: OK
    binary11.xi: OK
    binary12.xi: OK
    block01.xi: OK
    block02.xi: OK
    charlit01.xi: OK
    charlit02.xi: OK
    functioncall01.xi: OK
    functioncall02.xi: OK
    functioncall03.xi: OK
    functioncall04.xi: OK
    if01.xi: OK
    if02.xi: OK
    if03.xi: OK
    if04.xi: OK
    if05.xi: OK
    if06.xi: OK
    if07.xi: OK
    if08.xi: OK
    if09.xi: OK
    if10.xi: OK
    intlit01.xi: OK
    intlit02.xi: OK
    length01.xi: OK
    length02.xi: OK
    localdecl01.xi: OK
    localdecl02.xi: OK
    localdecl03.xi: OK
    localdecl04.xi: OK
    localdecl05.xi: OK
    localdecl06.xi: OK
    localdecl07.xi: OK
    localdecl08.xi: OK
    localdecl09.xi: OK
    localdecl10.xi: OK
    localdecl11.xi: OK
    localdecl12.xi: OK
    localdecl13.xi: Mismatch detected at line 4 of file localdecl13.s.nml
expected: 2
found   : Index: 0

---
# xic-ref (-target linux [basic test]): localdecl13.xi
Mismatch detected at line 4 of file localdecl13.s.nml
expected: 2
found   : Index: 0
## Command line without filenames:
xic -libpath ../../../../pa/pa4/grading/lib -target linux
## Content of test case:

```
use io
use conv

main(args: int[][]) {
  a: int[] = {1, 2, 3}
  x: int[f(a, 0)][f(a, 0)][f(a, 0)][][]
  println(unparseInt(length(x)))
  println(unparseInt(length(x[0])))
  println(unparseInt(length(x[0][0])))
  println(unparseInt(a[0]))
  println(unparseInt(a[1]))
  println(unparseInt(a[2]))
}

f(a: int[], i: int): int {
  print("Index: ")
  println(unparseInt(i))
  a[i] = a[i] + 1
  return a[i]
}

```

## Generated result:

```
Index: 0
Index: 0
Index: 0
Index: 0
Index: 0
Index: 0
Index: 0
Index: 0
Index: 0
Index: 0
Index: 0
Index: 0
Index: 0
2
3
4
14
2
3

```

## Expected result:

```
Index: 0
Index: 0
Index: 0
2
3
4
4
2
3

```

---
    localdecl14.xi: Mismatch detected at line 7 of file localdecl14.s.nml
expected: 1
found   : Index: 1

---
# xic-ref (-target linux [basic test]): localdecl14.xi
Mismatch detected at line 7 of file localdecl14.s.nml
expected: 1
found   : Index: 1
## Command line without filenames:
xic -libpath ../../../../pa/pa4/grading/lib -target linux
## Content of test case:

```
use io
use conv

main(args: int[][]) {
  a: int[] = {1, 2, 3, 4}
  x: int[f(a,3)-f(a,2)][f(a,2)-f(a,1)][f(a,1)-f(a,0)][][]
  println(unparseInt(length(x)))
  println(unparseInt(length(x[0])))
  println(unparseInt(length(x[0][0])))
  println(unparseInt(a[0]))
  println(unparseInt(a[1]))
  println(unparseInt(a[2]))
  println(unparseInt(a[3]))
}

f(a: int[], i: int): int {
  print("Index: ")
  println(unparseInt(i))
  a[i] = a[i] + 1
  return a[i]
}

```

## Generated result:

```
Index: 3
Index: 2
Index: 2
Index: 1
Index: 1
Index: 0
Index: 1
Index: 0
1
2
2
3
5
5
5

```

## Expected result:

```
Index: 3
Index: 2
Index: 2
Index: 1
Index: 1
Index: 0
1
2
2
2
4
5
5

```

---
    procedurecall01.xi: OK
    procedurecall02.xi: OK
    procedurecall03.xi: OK
    procedurecall04.xi: OK
    procedurecall05.xi: OK
    procedurecall06.xi: OK
    stringlit01.xi: OK
    stringlit02.xi: OK
    unary01.xi: OK
    unary02.xi: OK
    unary03.xi: OK
    unary04.xi: OK
    while01.xi: OK
    while02.xi: OK
    while03.xi: OK
    while04.xi: OK
  xic-ref (-target linux [basic test]): 86 out of 88 tests succeeded.
Has addressing mode: false
  Test collection: xic-ref (-target linux -O [basic test])
    arracc01.xi: OK
    arracc02.xi: OK
    arracc03.xi: OK
    arracc04.xi: OK
    arracc05.xi: OK
    arracc06.xi: OK
    arracc07.xi: OK
    arracc08.xi: OK
    arrinit01.xi: OK
    arrinit02.xi: OK
    arrinit03.xi: OK
    arrinit04.xi: OK
    arrinit05.xi: OK
    arrinit06.xi: OK
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
    binary01.xi: OK
    binary02.xi: OK
    binary03.xi: OK
    binary04.xi: OK
    binary05.xi: OK
    binary06.xi: OK
    binary07.xi: OK
    binary08.xi: OK
    binary09.xi: OK
    binary10.xi: OK
    binary11.xi: OK
    binary12.xi: OK
    block01.xi: OK
    block02.xi: OK
    charlit01.xi: OK
    charlit02.xi: OK
    functioncall01.xi: OK
    functioncall02.xi: OK
    functioncall03.xi: OK
    functioncall04.xi: OK
    if01.xi: OK
    if02.xi: OK
    if03.xi: OK
    if04.xi: OK
    if05.xi: OK
    if06.xi: OK
    if07.xi: OK
    if08.xi: OK
    if09.xi: OK
    if10.xi: OK
    intlit01.xi: OK
    intlit02.xi: OK
    length01.xi: OK
    length02.xi: OK
    localdecl01.xi: OK
    localdecl02.xi: OK
    localdecl03.xi: OK
    localdecl04.xi: OK
    localdecl05.xi: OK
    localdecl06.xi: OK
    localdecl07.xi: OK
    localdecl08.xi: OK
    localdecl09.xi: OK
    localdecl10.xi: OK
    localdecl11.xi: OK
    localdecl12.xi: OK
    localdecl13.xi: Mismatch detected at line 4 of file localdecl13.s.nml
expected: 2
found   : Index: 0

---
# xic-ref (-target linux -O [basic test]): localdecl13.xi
Mismatch detected at line 4 of file localdecl13.s.nml
expected: 2
found   : Index: 0
## Command line without filenames:
xic -libpath ../../../../pa/pa4/grading/lib -target linux -O
## Content of test case:

```
use io
use conv

main(args: int[][]) {
  a: int[] = {1, 2, 3}
  x: int[f(a, 0)][f(a, 0)][f(a, 0)][][]
  println(unparseInt(length(x)))
  println(unparseInt(length(x[0])))
  println(unparseInt(length(x[0][0])))
  println(unparseInt(a[0]))
  println(unparseInt(a[1]))
  println(unparseInt(a[2]))
}

f(a: int[], i: int): int {
  print("Index: ")
  println(unparseInt(i))
  a[i] = a[i] + 1
  return a[i]
}

```

## Generated result:

```
Index: 0
Index: 0
Index: 0
Index: 0
Index: 0
Index: 0
Index: 0
Index: 0
Index: 0
Index: 0
Index: 0
Index: 0
Index: 0
2
3
4
14
2
3

```

## Expected result:

```
Index: 0
Index: 0
Index: 0
2
3
4
4
2
3

```

---
    localdecl14.xi: Mismatch detected at line 7 of file localdecl14.s.nml
expected: 1
found   : Index: 1

---
# xic-ref (-target linux -O [basic test]): localdecl14.xi
Mismatch detected at line 7 of file localdecl14.s.nml
expected: 1
found   : Index: 1
## Command line without filenames:
xic -libpath ../../../../pa/pa4/grading/lib -target linux -O
## Content of test case:

```
use io
use conv

main(args: int[][]) {
  a: int[] = {1, 2, 3, 4}
  x: int[f(a,3)-f(a,2)][f(a,2)-f(a,1)][f(a,1)-f(a,0)][][]
  println(unparseInt(length(x)))
  println(unparseInt(length(x[0])))
  println(unparseInt(length(x[0][0])))
  println(unparseInt(a[0]))
  println(unparseInt(a[1]))
  println(unparseInt(a[2]))
  println(unparseInt(a[3]))
}

f(a: int[], i: int): int {
  print("Index: ")
  println(unparseInt(i))
  a[i] = a[i] + 1
  return a[i]
}

```

## Generated result:

```
Index: 3
Index: 2
Index: 2
Index: 1
Index: 1
Index: 0
Index: 1
Index: 0
1
2
2
3
5
5
5

```

## Expected result:

```
Index: 3
Index: 2
Index: 2
Index: 1
Index: 1
Index: 0
1
2
2
2
4
5
5

```

---
    procedurecall01.xi: OK
    procedurecall02.xi: OK
    procedurecall03.xi: OK
    procedurecall04.xi: OK
    procedurecall05.xi: OK
    procedurecall06.xi: OK
    stringlit01.xi: OK
    stringlit02.xi: OK
    unary01.xi: OK
    unary02.xi: OK
    unary03.xi: OK
    unary04.xi: OK
    while01.xi: OK
    while02.xi: OK
    while03.xi: OK
    while04.xi: OK
  xic-ref (-target linux -O [basic test]): 86 out of 88 tests succeeded.
Has addressing mode: false
  Test collection: xic-ref (-target linux [contest])
    group_of_anonymous01__div.xi: OK
    group_of_anonymous01__ret_overwrite.xi: Missing line in file group_of_anonymous01__ret_overwrite.s.nml: _xi_out_of_bounds called

---
# xic-ref (-target linux [contest]): group_of_anonymous01__ret_overwrite.xi
Missing line in file group_of_anonymous01__ret_overwrite.s.nml: _xi_out_of_bounds called
## Command line without filenames:
xic -libpath ../../../../pa/pa5/grading/lib -target linux
## Content of test case:

```
use io
use conv

fn(a:int, b:int, c:int, d:int, e:int, f:int, g:int, h:int) : int, int[] {
    // checks if call to alloc messes with the first return value
    return a + b + c + d + e + f + g + h, {0}
}

main(args:int[][]) {
    a:int, b:int[] = fn(1, 2, 3, 4, 5, 6, 7, 8)
    b[a - 36] = a
}

```

## Generated result:

```

```

## Expected result:

```
_xi_out_of_bounds called

```

---
    group_of_anonymous01__side_effect.xi: Mismatch detected at line 1 of file group_of_anonymous01__side_effect.s.nml
expected: Pass: binop
found   : _xi_out_of_bounds called

---
# xic-ref (-target linux [contest]): group_of_anonymous01__side_effect.xi
Mismatch detected at line 1 of file group_of_anonymous01__side_effect.s.nml
expected: Pass: binop
found   : _xi_out_of_bounds called
## Command line without filenames:
xic -libpath ../../../../pa/pa5/grading/lib -target linux
## Content of test case:

```
use io
assert(b:bool, message:int[]) {
    if (b) println("Pass: " + message)
    else { println("Fail: " + message) a:int[0] a[-1] = 42 }
}
inc(a:int[]): int { a[0] = a[0] + 1 return a[0] }
checkSequential(a:int, b:int, c:int): bool { return a == 1 & b == 2 & c == 3 }
main(args:int[][]) {
    a:int[2] b:int[2][2]
    a[0] = 0 assert(a[0] != inc(a), "binop")
    a[0] = 1 assert(checkSequential(a[0], inc(a), inc(a)), "call args")
    a = {0, 2} a[a[0]] = inc(a) assert(a[0] == 1 & a[1] == 2, "assign")
    a = {0, 3, 6} a[inc(a)] = inc(a)
    assert(
        a[0] == 2 & a[1] == 2 & a[2] == 6,
        "assign2"
    )
}

```

## Generated result:

```
_xi_out_of_bounds called

```

## Expected result:

```
Pass: binop
Pass: call args
Pass: assign
Pass: assign2

```

---
    group_of_anonymous02__dimensions.xi: [[Executable's standard error:
GC Warning: Failed to expand heap by 8388608 bytes
GC Warning: Failed to expand heap by 8388608 bytes
GC Warning: Failed to expand heap by 8388608 bytes
GC Warning: Failed to expand heap by 8388608 bytes
GC Warning: Failed to expand heap by 8388608 bytes
GC Warning: Failed to expand heap by 303104 bytes
GC Warning: Out of Memory! Heap size: 2763 MiB. Returning NULL!

]] Failed to execute: group_of_anonymous02__dimensions exit code 139

---
# xic-ref (-target linux [contest]): group_of_anonymous02__dimensions.xi
[Executable's standard error:
GC Warning: Failed to expand heap by 8388608 bytes
GC Warning: Failed to expand heap by 8388608 bytes
GC Warning: Failed to expand heap by 8388608 bytes
GC Warning: Failed to expand heap by 8388608 bytes
GC Warning: Failed to expand heap by 8388608 bytes
GC Warning: Failed to expand heap by 303104 bytes
GC Warning: Out of Memory! Heap size: 2763 MiB. Returning NULL!

]Failed to execute: group_of_anonymous02__dimensions exit code 139
## Command line without filenames:
xic -libpath ../../../../pa/pa5/grading/lib -target linux
## Content of test case:

```
asser(c:bool) { if (!c) { x:int = 1/0; } }
f(x:int, y:int, d1:int, d2:int, d3:int, d4:int, d5:int, a:int[][]):int {
  a[0][0] = a[0][0] + x + d5
  return a[0][0] + x + d5 + x*d5 + x*x*d5 + x*d5*d5 + x*x*x + d5*d5*d5
}
main(args:int[][]) {
  b:int[][] = {{1}, {2}}
  a:int[f(2, 9, 9, 9, 9, 9, 3, b)]
       [f(3, 9, 9, 9, 9, 9, 1, b)]
       [f(1, 9, 9, 9, 9, 9, 1, b)]
  i:int = 0
  while (i < length(a)) { j:int = 0 while (j < length(a[i])) { k:int = 0
    while (k < length(a[i][j])) {
      a[i][j][k] = 2 * i + 13 * j + 7 * k
      k = k + 1 } j = j + 1 } i = i + 1 }
  count:int = 0 i = 0
  while (i < length(a)) { j:int = 0 while (j < length(a[i])) { k:int = 0
    while (k < length(a[i][j])) { count = count + a[i][j][k] k = k + 1 }
      j = j + 1 } i = i + 1 }
  asser(count == 45113448) }

```

## Generated result:

```

```

## Expected result:

```

```

---
    group_of_anonymous02__euler.xi: OK
    group_of_anonymous02__sieve.xi: OK
    group_of_anonymous03__arr.xi: OK
    group_of_anonymous03__concat.xi: OK
    group_of_anonymous03__mult_call.xi: OK
    group_of_anonymous03__wildcard.xi: OK
    group_of_anonymous04__multarrayinbounds.xi: OK
    group_of_anonymous04__multipleReturns.xi: OK
    group_of_anonymous04__nestedindex.xi: OK
    group_of_anonymous04__partialarrayinitialization.xi: OK
    group_of_anonymous04__recursiveCalls.xi: OK
    group_of_anonymous05__ir_big_function.xi: OK
    group_of_anonymous05__ir_hi_mult.xi: OK
    group_of_anonymous06__func_inside_array_inside_func.xi: OK
    group_of_anonymous06__hard.xi: OK
    group_of_anonymous06__matrix.xi: OK
    group_of_anonymous06__multiassign4.xi: OK
    group_of_anonymous06__short_circuit_test.xi: OK
    group_of_anonymous07__attack_loops.xi: OK
    group_of_anonymous07__attack_sum.xi: OK
    group_of_anonymous08__easytest.xi: [[Linker's standard output:
/home/vagrant/shared/xthtest/pa5/group_of_hos7_jcg284_shg64_wc523/group_of_anonymous08__easytest.s: Assembler messages:
/home/vagrant/shared/xthtest/pa5/group_of_hos7_jcg284_shg64_wc523/group_of_anonymous08__easytest.s:937: Error: too many memory references for `movq'
/home/vagrant/shared/xthtest/pa5/group_of_hos7_jcg284_shg64_wc523/group_of_anonymous08__easytest.s:968: Error: too many memory references for `movq'

]] File group_of_anonymous08__easytest does not exist in directory shared/xthtest/pa5/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (-target linux [contest]): group_of_anonymous08__easytest.xi
[Linker's standard output:
/home/vagrant/shared/xthtest/pa5/group_of_hos7_jcg284_shg64_wc523/group_of_anonymous08__easytest.s: Assembler messages:
/home/vagrant/shared/xthtest/pa5/group_of_hos7_jcg284_shg64_wc523/group_of_anonymous08__easytest.s:937: Error: too many memory references for `movq'
/home/vagrant/shared/xthtest/pa5/group_of_hos7_jcg284_shg64_wc523/group_of_anonymous08__easytest.s:968: Error: too many memory references for `movq'

]File group_of_anonymous08__easytest does not exist in directory shared/xthtest/pa5/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic -libpath ../../../../pa/pa5/grading/lib -target linux
## Content of test case:

```
use io
main(args:int[][]){
  a:int, b:int[], c:int, d:int[][], e:int, f:int, g:int[], h:int[][] =
  foo(500,101,-1,-2,-3,-4,"andrew"+"myers",{{1,2,3},"my\x65rs"})
  error:int[] = "a"
  if(a != 500){x:int = error[10]}
  if(b[0]!=500|b[1]!=101|b[2]!=-1){x:int = error[10]}
  if(!(c== 19)){x:int = error[10]}
  if(!(d[0][0]==500)&!(d[1][1]==-2)){x:int = error[10]}
  if(e!='m'){x:int = error[10]}
  if(f!='e'){x:int = error[10]}
  if(g[10]!='s'){x:int = error[10]}
  if(h[0][1]!=2){x:int = error[10]}
  if(length(h[1])!=5){x:int = error[10]}
  println("success");
}
foo(a:int, b:int, c:int, d:int, e:int, f:int, g:int[], h:int[][]):
  int, int[], int, int[][], int, int, int[], int[][]{
  return a, {a,b,c}, ((a/b)*a)/b, {{a,b},{c,d}}, g[6], h[1][2], g, h
}

```

## Generated result:

## Expected result:

---
    group_of_anonymous08__trivialtest.xi: OK
    group_of_anonymous09__divideext.xi: OK
    group_of_anonymous09__factorial.xi: OK
    group_of_anonymous09__fastSquareRoot.xi: OK
    group_of_anonymous09__hanoi.xi: OK
    group_of_anonymous09__poison.xi: OK
  xic-ref (-target linux [contest]): 27 out of 31 tests succeeded.
Has addressing mode: false
  Test collection: xic-ref (-target linux -O [contest])
    group_of_anonymous01__div.xi: OK
    group_of_anonymous01__ret_overwrite.xi: Missing line in file group_of_anonymous01__ret_overwrite.s.nml: _xi_out_of_bounds called

---
# xic-ref (-target linux -O [contest]): group_of_anonymous01__ret_overwrite.xi
Missing line in file group_of_anonymous01__ret_overwrite.s.nml: _xi_out_of_bounds called
## Command line without filenames:
xic -libpath ../../../../pa/pa5/grading/lib -target linux -O
## Content of test case:

```
use io
use conv

fn(a:int, b:int, c:int, d:int, e:int, f:int, g:int, h:int) : int, int[] {
    // checks if call to alloc messes with the first return value
    return a + b + c + d + e + f + g + h, {0}
}

main(args:int[][]) {
    a:int, b:int[] = fn(1, 2, 3, 4, 5, 6, 7, 8)
    b[a - 36] = a
}

```

## Generated result:

```

```

## Expected result:

```
_xi_out_of_bounds called

```

---
    group_of_anonymous01__side_effect.xi: Mismatch detected at line 1 of file group_of_anonymous01__side_effect.s.nml
expected: Pass: binop
found   : _xi_out_of_bounds called

---
# xic-ref (-target linux -O [contest]): group_of_anonymous01__side_effect.xi
Mismatch detected at line 1 of file group_of_anonymous01__side_effect.s.nml
expected: Pass: binop
found   : _xi_out_of_bounds called
## Command line without filenames:
xic -libpath ../../../../pa/pa5/grading/lib -target linux -O
## Content of test case:

```
use io
assert(b:bool, message:int[]) {
    if (b) println("Pass: " + message)
    else { println("Fail: " + message) a:int[0] a[-1] = 42 }
}
inc(a:int[]): int { a[0] = a[0] + 1 return a[0] }
checkSequential(a:int, b:int, c:int): bool { return a == 1 & b == 2 & c == 3 }
main(args:int[][]) {
    a:int[2] b:int[2][2]
    a[0] = 0 assert(a[0] != inc(a), "binop")
    a[0] = 1 assert(checkSequential(a[0], inc(a), inc(a)), "call args")
    a = {0, 2} a[a[0]] = inc(a) assert(a[0] == 1 & a[1] == 2, "assign")
    a = {0, 3, 6} a[inc(a)] = inc(a)
    assert(
        a[0] == 2 & a[1] == 2 & a[2] == 6,
        "assign2"
    )
}

```

## Generated result:

```
_xi_out_of_bounds called

```

## Expected result:

```
Pass: binop
Pass: call args
Pass: assign
Pass: assign2

```

---
    group_of_anonymous02__dimensions.xi: [[Executable's standard error:
GC Warning: Failed to expand heap by 8388608 bytes
GC Warning: Failed to expand heap by 8388608 bytes
GC Warning: Failed to expand heap by 8388608 bytes
GC Warning: Failed to expand heap by 303104 bytes
GC Warning: Out of Memory! Heap size: 2763 MiB. Returning NULL!

]] Failed to execute: group_of_anonymous02__dimensions exit code 139

---
# xic-ref (-target linux -O [contest]): group_of_anonymous02__dimensions.xi
[Executable's standard error:
GC Warning: Failed to expand heap by 8388608 bytes
GC Warning: Failed to expand heap by 8388608 bytes
GC Warning: Failed to expand heap by 8388608 bytes
GC Warning: Failed to expand heap by 303104 bytes
GC Warning: Out of Memory! Heap size: 2763 MiB. Returning NULL!

]Failed to execute: group_of_anonymous02__dimensions exit code 139
## Command line without filenames:
xic -libpath ../../../../pa/pa5/grading/lib -target linux -O
## Content of test case:

```
asser(c:bool) { if (!c) { x:int = 1/0; } }
f(x:int, y:int, d1:int, d2:int, d3:int, d4:int, d5:int, a:int[][]):int {
  a[0][0] = a[0][0] + x + d5
  return a[0][0] + x + d5 + x*d5 + x*x*d5 + x*d5*d5 + x*x*x + d5*d5*d5
}
main(args:int[][]) {
  b:int[][] = {{1}, {2}}
  a:int[f(2, 9, 9, 9, 9, 9, 3, b)]
       [f(3, 9, 9, 9, 9, 9, 1, b)]
       [f(1, 9, 9, 9, 9, 9, 1, b)]
  i:int = 0
  while (i < length(a)) { j:int = 0 while (j < length(a[i])) { k:int = 0
    while (k < length(a[i][j])) {
      a[i][j][k] = 2 * i + 13 * j + 7 * k
      k = k + 1 } j = j + 1 } i = i + 1 }
  count:int = 0 i = 0
  while (i < length(a)) { j:int = 0 while (j < length(a[i])) { k:int = 0
    while (k < length(a[i][j])) { count = count + a[i][j][k] k = k + 1 }
      j = j + 1 } i = i + 1 }
  asser(count == 45113448) }

```

## Generated result:

```

```

## Expected result:

```

```

---
    group_of_anonymous02__euler.xi: OK
    group_of_anonymous02__sieve.xi: OK
    group_of_anonymous03__arr.xi: OK
    group_of_anonymous03__concat.xi: OK
    group_of_anonymous03__mult_call.xi: OK
    group_of_anonymous03__wildcard.xi: OK
    group_of_anonymous04__multarrayinbounds.xi: OK
    group_of_anonymous04__multipleReturns.xi: OK
    group_of_anonymous04__nestedindex.xi: OK
    group_of_anonymous04__partialarrayinitialization.xi: OK
    group_of_anonymous04__recursiveCalls.xi: OK
    group_of_anonymous05__ir_big_function.xi: OK
    group_of_anonymous05__ir_hi_mult.xi: OK
    group_of_anonymous06__func_inside_array_inside_func.xi: OK
    group_of_anonymous06__hard.xi: OK
    group_of_anonymous06__matrix.xi: OK
    group_of_anonymous06__multiassign4.xi: OK
    group_of_anonymous06__short_circuit_test.xi: OK
    group_of_anonymous07__attack_loops.xi: OK
    group_of_anonymous07__attack_sum.xi: OK
    group_of_anonymous08__easytest.xi: [[Linker's standard output:
/home/vagrant/shared/xthtest/pa5/group_of_hos7_jcg284_shg64_wc523/group_of_anonymous08__easytest.s: Assembler messages:
/home/vagrant/shared/xthtest/pa5/group_of_hos7_jcg284_shg64_wc523/group_of_anonymous08__easytest.s:973: Error: too many memory references for `movq'
/home/vagrant/shared/xthtest/pa5/group_of_hos7_jcg284_shg64_wc523/group_of_anonymous08__easytest.s:1004: Error: too many memory references for `movq'

]] File group_of_anonymous08__easytest does not exist in directory shared/xthtest/pa5/group_of_hos7_jcg284_shg64_wc523

---
# xic-ref (-target linux -O [contest]): group_of_anonymous08__easytest.xi
[Linker's standard output:
/home/vagrant/shared/xthtest/pa5/group_of_hos7_jcg284_shg64_wc523/group_of_anonymous08__easytest.s: Assembler messages:
/home/vagrant/shared/xthtest/pa5/group_of_hos7_jcg284_shg64_wc523/group_of_anonymous08__easytest.s:973: Error: too many memory references for `movq'
/home/vagrant/shared/xthtest/pa5/group_of_hos7_jcg284_shg64_wc523/group_of_anonymous08__easytest.s:1004: Error: too many memory references for `movq'

]File group_of_anonymous08__easytest does not exist in directory shared/xthtest/pa5/group_of_hos7_jcg284_shg64_wc523
## Command line without filenames:
xic -libpath ../../../../pa/pa5/grading/lib -target linux -O
## Content of test case:

```
use io
main(args:int[][]){
  a:int, b:int[], c:int, d:int[][], e:int, f:int, g:int[], h:int[][] =
  foo(500,101,-1,-2,-3,-4,"andrew"+"myers",{{1,2,3},"my\x65rs"})
  error:int[] = "a"
  if(a != 500){x:int = error[10]}
  if(b[0]!=500|b[1]!=101|b[2]!=-1){x:int = error[10]}
  if(!(c== 19)){x:int = error[10]}
  if(!(d[0][0]==500)&!(d[1][1]==-2)){x:int = error[10]}
  if(e!='m'){x:int = error[10]}
  if(f!='e'){x:int = error[10]}
  if(g[10]!='s'){x:int = error[10]}
  if(h[0][1]!=2){x:int = error[10]}
  if(length(h[1])!=5){x:int = error[10]}
  println("success");
}
foo(a:int, b:int, c:int, d:int, e:int, f:int, g:int[], h:int[][]):
  int, int[], int, int[][], int, int, int[], int[][]{
  return a, {a,b,c}, ((a/b)*a)/b, {{a,b},{c,d}}, g[6], h[1][2], g, h
}

```

## Generated result:

## Expected result:

---
    group_of_anonymous08__trivialtest.xi: OK
    group_of_anonymous09__divideext.xi: OK
    group_of_anonymous09__factorial.xi: OK
    group_of_anonymous09__fastSquareRoot.xi: OK
    group_of_anonymous09__hanoi.xi: OK
    group_of_anonymous09__poison.xi: OK
  xic-ref (-target linux -O [contest]): 27 out of 31 tests succeeded.
Has addressing mode: false
xthScript: 238 out of 250 tests succeeded.

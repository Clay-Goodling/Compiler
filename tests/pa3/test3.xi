use io;

// Type-Checking Statements

// Sequences (?)
// Procedure Call/Unit Procedure Call/Multi Procedure Call (?)
// Declarations (all types)

// Assignments and Array Assignments
foo(){
    i : int = 1 + 2
    b : bool = true | false
    s : int[] = "Hello" + " " + "World"
    s[5] = (2 * 5) / (6 + 4)
    print({25})
}

// Empty Statements
empty(){}

// If, If-Else, and While Statements
if_else_while(){
    a : int = 100
    c : int = 5
    i : int  = 0
    b : bool = true
    //if 1 < 2 {
    //    b = false
    //}
    if (b) {
        a = -a
    }
    else {
        b = !b
    }
    while (i < 10) {
        a = (a + c) / 2
        i = i + 1
    }
}

// Return Statements
r_0(){
    return
}

r_1():int {
    return 1 + 1
}

r_mult():int, bool {
    return 0, true
}

r_arr(): int[][] {
    return {{2, 5}, {3, 6}} 
}

// Procedure Calls
main(){ 
  foo()
}

// Declarations
main2(){
  x : int
  b : int[][][]
  d : int[5]
  c : int[3][4]
  a : int[3][2][1][][]

}

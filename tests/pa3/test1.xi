// Type-Checking Expressions, Part 1

foo() {
    i_0 : int = 0
    i_1 : int = 1

    b_0 : bool = false
    b_1 : bool = true

    s_0 : int[] = " "
    s_1 : int[] = "Hello World"
    s_2 : int[] = "Testing"

    c_0 : int = 'A'

    a_0 : int[] = {0, 1, 2}
    a_1 : int[] = {72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100,}
    a_2 : bool[] = {true, false}

    // Variable Assignments
    v_i : int = i_0
    v_f : bool = b_0
    v_t : bool = b_1
    v_s : int[] = s_0
    v_c : int = c_0

    // Unary Expressions
    neg_0 : int 
    neg_0 = -(i_0)
    neg_1 : int
    neg_1 = -(i_1)
    neg_t : bool
    neg_t = !(b_1)
    neg_f : bool 
    neg_f = !(b_0)
    len_0 : int
    len_0 = length(s_1)

    // Binary Expressions (int, int -> int)
    be_0 : int = i_0 + i_1
    be_1 : int = i_0 - i_1
    be_2 : int = i_0 * i_1
    be_3 : int = i_0 *>> i_1
    be_4 : int = i_0 / i_1
    be_5 : int = i_0 % i_1

    // Binary Expressions 1 (int, int -> bool)
    be_6 : bool = i_0 == i_1
    be_7 : bool = i_0 != i_1
    be_8 : bool = i_0 < i_1
    be_9 : bool = i_0 <= i_1
    be_10 : bool = i_0 > i_1
    be_11 : bool = i_0 >= i_1

    // Binary Expressions 2 (bool, bool -> bool)
    be_12 : bool = b_0 == b_1
    be_13 : bool = b_0 != b_1
    be_14 : bool = b_0 & b_1
    be_15 : bool = b_0 | b_1

    // Binary Expressions 3 (t[], t[] -> bool)
    be_16 : bool = s_1 == a_1
    be_17 : bool = s_1 != a_1

    // Array Expressions
    ae_0 : int = a_1[i_0]
    ae_1 : bool = a_2[i_1]
    ae_3 : int[] = s_2 + s_0 + s_1
    ae_4 : int[] = a_0 + a_1
    ae_5 : bool[] = a_2 + a_2
}
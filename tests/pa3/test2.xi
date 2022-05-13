// Type-Checking Expressions, Part 2

f_0_0():int {
    return 0
}

f_0_1():bool {
    return true
}

f_1_0(i:int):int {
    return i
}
f_1_1(b:bool):bool {
    return b
}

f_m_0(a:int, b:int):int {
    return (a + b) / 2
}

f_m_1(b1:bool, b2:bool, b3: bool):bool {
    return b1 & b2 | !b3
}

// Function Calls
foo() {
    call_0 : int = f_0_0()
    call_1 : bool = f_0_1()
    call_2 : int = f_1_0(0)
    call_3 : bool = f_1_1(true)
    call_4 : int = f_m_0(0, 1)
    call_5 : bool = f_m_1(true, false, true)
}
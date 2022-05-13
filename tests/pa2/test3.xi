// A bunch of precedence/assoc tests
test3() {
    i = 1 + 2 * 3
    i = (1 + 2) * 3
    i = 1 * 2 + 3
    i = 1 * (2 + 3)
    i = 1 + 2 - 3;
    i = 2 * 9 / 3 % 5
    i = 2 * (9 / (3 % 5));

    i = 1 * 2 *>> 2 + 3
    i = (1 * 2) *>> 2 + 3
    i = 1 * 2 *>> (2 + 3)
    i = (1 * 2) *>> (2 + 3)
    i = 1 * (2 *>> 2) + 3
    
    b = true & !false
    b = !true | false
    b = !(true | true)
    b = !(false & false)

    b = true & true | false
    b = (true & true) | false
    b = true & (true | false)
    b = true & !true | false

    b = true & true & false
    b = true & (true & false)
    b = true | false | false
    b = true | (false | false)

    b = 1 < 2 == 3 < 4
    b = 1 < (2 != 3) < 4
    b = 1 < 2 < 3
    b = 1 >= (2 >= 3)

    b = 1 == 2 == 3
    b = 7 == (7 == 7)
    b = 1 != 3 != 5
    b = 2 != (9 != 9)
}
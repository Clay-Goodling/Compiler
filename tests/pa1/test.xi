x : int = 10 // assign 10 to x

//Keyword test
use if while else return length int bool true false//all keywords
true // keyword
truefalse // id
true9 // id
true 9 // keyword, int
true"helloworld!" // keyword, string
true't' // keyword, char
tru'e' // id
tru 'e' // id, char
tru e // id, id
truelse // id

//Comment test
//Nothing should be printed
//
// this is a comment
//Hello world
//!@#$%^&*()_+1234567890-=
//qwertyuiop[]\{}|QWERTYUIOP
//asdfghjkl;':"ASDFGHJKL
//zxcvbnm,./ZXCVBNM<>>
//H//e//l//l/o W\o\\r\l\\d \n
//`~
//    \n    \t    \f     \r      
//use
//if
//while 
//else
//return
//length
//int
//bool
//true
//false
//<=>===!=*>>
//123456789
//'\x0064'

//Whitespace test
											//bunch of tabs
                                 //spaces 
                                 // Very thorough testing here

//Integer testing
0 1 2 3 4 5 6 7 8 9 // ints
-1 // symbol, int
- 1 // symbol int
-0 // symbol, int
123456789 // int
"123" // string
'1' // char
a123 // id
-1 // symbol, int
1+1 // int, symbol, int

//String test
"hello" "'h'" "bool" "+" "64" "\" \n \\" "\x0063" "// not a comment" "	"

//Character test
'a' 'b' 'c''d''n' //chars
'\x0064' '\x064' '\x64' '\xA' '\n' '\'' '\\' // chars, hex and special chars

//Symbol test
+ - / * = | & ! % < > [ ] { } ( ) : ; _ <= >= == != *>> // all symbols
=== // == =
>== // >= =
<== // <= =
!== // != = 

//Identifier test
abc h3ll0 wor_ld cod'e' //  Ids

//Misc. Tests
//identifier beginnning with non-letter
073 // int, int (0, 73)
1hello //int, id
_hello //symbol, id
'\x0022'
"\x0009"
'\"'
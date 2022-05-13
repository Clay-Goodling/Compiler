// Keyword Tests
// use, if/else, nested if/else, while, nested while, return, length 
use io

foo(a:int, b:bool[]) : int {
	if (true) {								//If-else
		return a
	}
	else {
		if (false) {						//Nested if
		return b;
		}
		else {
			return
		}
	}
	while (true) {								//While
		while (true) {							//Nested while
		}
	}
	if (false) { 									//If statement without else statement
		return length(b); 			//Use length keyword
	}
	return;
} 
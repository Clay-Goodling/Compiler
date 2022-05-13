src = src_jcg284_shg64_hos7_wc523

build:
	./xic-build

giventest:
	xth --testpath xth/tests/pa5 xth/tests/pa5/xthScript

test: test1 test2 test3 test3auto test4 test4auto test5

test1:
	xth --testpath tests/pa1 tests/pa1/xthScript

test2:
	xth --testpath tests/pa2 tests/pa2/xthScript

test3:	
	xth --testpath tests/pa3 tests/pa3/xthScript

test3auto:	
	xth --testpath tests/pa3auto tests/pa3auto/xthScript

test4:	
	xth --testpath tests/pa4 tests/pa4/xthScript

test4auto:	
	xth --testpath tests/pa4auto tests/pa4auto/xthScript

test5:	
	xth --testpath tests/pa5 tests/pa5/xthScript

test5auto:	
	xth --testpath tests/pa5auto tests/pa5auto/xthScript

zip:
	zip -r src.zip xic-build tests edu polyglot lib src_jcg284_shg64_hos7_wc523 runtime benchmarks

log:
	git log > logs/pa5-log.txt

clean:
	rm -rf bin
	rm -f $(src)/lexer/MyLexer.java*
	rm -f $(src)/parser/*.java
	rm -f tests/*/*.lexed
	rm -f tests/*/*.parsed
	rm -f tests/*/*.typed
	rm -f tests/*/*.results
	rm -f tests/*/*.ir
	rm -f tests/*/*.s
	rm -f tests/*/*.dot
	rm -f *.s 
	rm -f *.dot

loc:
	find . -type f -exec cat {} + | wc -l
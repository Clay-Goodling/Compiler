import re


pattern = """
---
#[^#]*
## Command line[^#]*
## Content of test case:

```
([^#]*)
```

(?:## Compiler's standard output:[^#]*)?(?:## Compiler's standard error:[^#]*)?## Generated result[^#]*
## Expected result:

```
([^#]*)
```

---
"""

xthScriptTemplate = """
build

xic ("Test failed autograder tests") "-target linux -libpath $(testpath)" {
    # Failed Autograder Tests
    %s
}
"""

path = 'tests/pa5auto/'

print('enter autograder results filename\n> ', end='')
with open(input(), 'r') as f:
  s = f.read()

prog = re.compile(pattern)
matches = prog.finditer(s)

cases = ''

for i, match in enumerate(matches):
  with open(path + 'testauto' + str(i) + '.xi', 'w') as f:
    f.write(match.group(1))
  with open(path + 'testauto' + str(i) + '.ssol.nml', 'w') as f:
    f.write(match.group(2))

  cases += 'testauto' + str(i) + '.xi;\n'

with open(path + 'xthScript', 'w') as f:
  f.write(xthScriptTemplate % cases)

# Lecture 1
### Module Info
**Lecturer:** Ian Wakeman\
**Office:** Chich 2R313\
**Email:** ianw@sussex.ac.uk\
**Office hour:** Firday, 14:00-15:30

### Assesment
- Problem solution + peer assesment, week 4 and 5; 12.5%
- Functional textual game, week 8; 12.5%
- GUI driven game, week 12; 25%
- Exam for concepts and problem solving; 50%

### Contents
- **Programming** a lot
- Java
- Java GUIs and various libraries
- General programming skills
- Design
- More advanced Object Oriented Techniques
- Design patterns
- Algorithms
- Test Driven Programming (TDD)
---
### Test Driven Development
- Write tests first
- (they) Specify what you want
- Tests determine when requirements are met
- Tests help document intentions

**TDD Cycle:**
- Write a test
- Watch it fail
- Make a little change
- Watch it succeed
- Refactor code to remove duplication
  - OR improve test
  - OR move on
- Keep notes of other stuff (focussed)

**TDD Automation:**
For:
- repeatable
- quick
- low mental load

Manual:
- first time testing (no TDD code)
- abstract tests (look, feel etc.)
- debugging what didn't pass test
- learning code behaviour

**Test Terminology:**
- Unit test - testing at the smallest units of code
- Integration/System/Acceptance test - testing combinations of code, code + middleware and user interaction with code
- Pre/Post test fixtures (@Before, @After) - common setup code to save writing
- Assertion - test for the responses we expect (equals, true, null...)
- Anticipated exception - test for errors (invalid input)

**Structure of a Test**
- Arrange
- Act
- Assert


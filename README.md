# Word Counter program

This program counts the number of words in a text file.

## Project structure

`src\main\java` - source code for `App` and `WordCounter` classes in `com.yedya` package
`src\test\java` - test cases for the program
`test_files` - text files used in tests

## How to run

Download source folder. Import with Eclipse. Alternatively one can use [maven](https://maven.apache.org/) to run code.

To run tests with maven:

```mvn test```

To build demo wrapper with maven:

```mvn package```

Then run with

```java -jar target/WordCounter-1.0.jar test_files/simple.txt```

or

```java -jar target/WordCounter-1.0.jar yourText.txt```


- Count words of any language 

### What needs more testing?

- Large text wasn't tested.
- Complex unicode strings.
- System testing to ensure the application runs efficently on a system level tests such as stress,performance, security and recovery tests must pass.
- `WordCounter` is not thread safe.


### Testing Approach

To test the `WordCounter` class , all of its methods must be tested to ensure all the all the code works as intended. With my approach, I wrote the Junit tests as I wrote the program, as opposed to writing the tests after developing the program. This helped me define the acceptance criteria and allowed me to validate my code as I wrote it.This is my first time using JUnit in a professional context so I would apprciate feedback on my approach, I'm not afraid of making mistakes because thats how you learn.


As I wrote the `WordCounter`class I would write the tests in parrallel .Looking for any point in the code where I could use `assertions` to validate an expected output.So I'd write the test then focus soley on that test until it passed, breaking the program into smaller junks rather than one whole application.I could then incrementally build on passing tests instead of constantly refactoring code, which could introduce new bugs.Once my tests were passing it was safer to refactor. When testing the word counting functionality I tried to vary the testing scenarios.I would include words with varying punctuation,contraction and language.I also tried to include double UTF-8 characters in some of the text files like so `??` and `!!` ,to ensure the counter skipped such characters.


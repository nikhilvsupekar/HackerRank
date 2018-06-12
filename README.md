# HackerRank
Solutions to HackerRank problems

Solutions are written in Java 8. <br/>
The solutions have been built around a test infrastructure developed in Java. <br/>
This allows a smooth migration of solutions to-and-fro online competitive environments such as HackerRank. <br/>
The test infrastructure is further appended by JUnit for user-friendly error reporting.<br/>

Testcases and and the expected outputs are stored in text files and used for comparison against the results.


## Project Structure

0. Solutions are implemented as classes
1. Solution source code goes under `src/com`
2. All Solution sources must implement the `com.utils.Solution` interface
3. JUnit tests go under `test/`
4. All data files (testcases, outputs) go under `data/`
5. `data/inputs/<TestClass>` -> testcases
6. `data/output/<TestClass>` -> expected outputs
7. `data/results/<TestClass>` -> results generated after running your tests
8. Test case files have to be numbered starting from 1 to n
9. Output files have to be numbered starting from 1 to n and must correspond to the test case files
10. Failed test cases are denoted by a list of integer ids identifying the failed test cases


## Problems Solved

* [HackerRank/Algorithms/Implementation/Grading Students](https://www.hackerrank.com/challenges/grading/problem)

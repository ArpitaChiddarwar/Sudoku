# Sudoku

Implemented a class Sudoku that maintains a Sudoku grid and can e.g. check if it is legal.

Member function check(): checks if the current values in the Sudoku grid are legal. Returns true (is legal) or false (is not legal).

A Sudoku grid is legal if no row, column or 3x3 sub-block contains the same digit character twice (spaces may naturally occur multiple times).

Check first the rows, then the columns, and finally the sub-blocks (inspect the sub-blocks in a row-wise manner, starting with the upper left corner sub-block).

If the check finds two same digit characters from the same row, column or sub-block, record the smallest such duplicate digit character. This ensures that the messages described below will be unique even if there were several different duplicate digits. When a duplicate digit has been found, print one of the messages desribed below and stop the check, returning false.

Row: “Row i has multiple c's!”, where i is the row index.

Column: “Column j has multiple c's!”, where j is the column index.

Sub-block: “Block at (x, y) has multiple c's!”, where x and y are the row and column index of the upper left corner cell of the sub-block.


You may test your class by using the test program given in the file SudokuTest.java, the test data given in the file input.txt, and the example output given in the file output.txt. Place these files and your own class implementation into the same directory, compilte the program e.g. as javac *.java, and run the test as java SudokuTest input.txt. The program should produce exactly the same output as shown in the file output.txt.

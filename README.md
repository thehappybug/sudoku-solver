# Sudoku Solver

Implements the *Sudoku solver* using recursive backtracking. Implementation is provided as `SudokuSolver` class contained in the package `io.gitbub.thehappybug.Algorithms`.

## Compiling

The project can be compiled using `make` tool:

```
$ make
javac io/github/thehappybug/Algorithms/SudokuSolver.java
```

## Running

Run the class `SudokuSolver`'s `main` method using:

```
$ java io.github.thehappybug.Algorithms.SudokuSolver input.txt
1 2 3 4 5 7 6 8 9
5 6 8 1 2 9 3 4 7
4 7 9 3 6 8 1 2 5
3 1 2 5 4 6 7 9 8
6 4 7 8 9 1 5 3 2
8 9 5 2 7 3 4 1 6
2 3 1 6 8 5 9 7 4
7 8 6 9 1 4 2 5 3
9 5 4 7 3 2 8 6 1
1 2 3 4 5 7 6 8 9
5 6 8 1 2 9 3 4 7
4 7 9 3 6 8 1 2 5
3 1 2 5 4 6 7 9 8
6 4 7 8 9 1 5 3 2
8 9 5 2 7 3 4 1 6
2 3 1 6 8 5 9 7 4
7 8 6 9 1 4 2 5 3
9 5 4 7 3 2 8 6 1
```

The program requires filename of the input file containing the sudoku problems as the argument.


## Documentation of `SudokuSolver` (Public)

**`public class SudokuSolver`**

Algorithm to solve a Sudoku puzzle by backtracking.

**`public static void main(String[] args)`**

Main program to to generate all to solve Sudoku puzzle.

 * **Parameters:** `args` — filename of file containing problem needed

**`public SudokuSolver(int[][] grid)`**

Create a Sudoku algorithm bound to this grid.

 * **Parameters:** `grid` — The Sudoku Grid

**`public int[][] run()`**

Run the Sudoku solver.

 * **Returns:** The solution grid.

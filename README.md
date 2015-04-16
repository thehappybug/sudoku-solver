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
$ java io.github.thehappybug.Algorithms.SudokuSolver
[-7, -3, -2, -1, 5, 8]
[-7, -3, 10]
[-7, -2, -1, 10]
[-7, -2, 9]
[-7, -1, 8]
[-3, -2, 5]
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

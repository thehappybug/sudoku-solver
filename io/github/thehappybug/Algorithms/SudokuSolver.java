package io.github.thehappybug.Algorithms;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Algorithm for solving a sudoku by backtracking
 */
public class SudokuSolver
{
    // Grid structure
    private int[][] grid;

    // Pair for specifying row, col
    private class Pair
    {
        private int _x;
        private int _y;

        public Pair(int x, int y) { this._x = x; this._y = y; }
        public int x() { return _x; }
        public int y() { return _y; }
    }

    // Ctor
    public SudokuSolver(int[][] grid)
    {
        this.grid = grid;
    }

    // Runt the algo
    public int[][] run()
    {
        solveSudoku();
        return grid;
    }

    // Algo implementation
    private boolean solveSudoku()
    {
        Pair current = findEmptyLocation();

        if(current == null)
            return true;

        for (int i=1; i<=9; i++) {
            if(isGood(i, current)) {
                grid[current.x()][current.y()] = i;
                if(solveSudoku())
                    return true;
                grid[current.x()][current.y()] = 0;
            }
        }
        return false;
    }

    // Check for empty box in grid
    private Pair findEmptyLocation()
    {
        for (int i = 0; i <9; i++) {
            for (int j = 0; j <9; j++) {
                if(grid[i][j] == 0)
                    return new Pair(i, j);
            }
        }
        return null;
    }

    // Is putting number in the given position good?
    private boolean isGood(int number, Pair position)
    {
        for (int i = 0; i <9; i++) {
            if(grid[position.x()][i] == number)
                return false;
            if(grid[i][position.y()] == number)
                return false;
        }
        int boxX = (position.x()/3) * 3;
        int boxY = (position.y()/3) * 3;
        for (int i = 0; i <3; i++) {
            for (int j = 0; j <3; j++) {
                if(grid[i+boxX][j+boxY] == number)
                    return false;
            }
        }
        return true;
    }

    // Main program
    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Input file's filename needed as argument...");
            return;
        }

        Path path = Paths.get(args[0]);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            String line = null;
            line = reader.readLine();
            int puzzleCount = Integer.parseInt(line, 10);

            for (int k = 0; k<puzzleCount; k++) {
                int[][] input = new int[9][9];
                int i = 0;
                int j = 0;

                while (i < 9) {
                    line = reader.readLine();
                    String[] tokens = line.split("\\s+");
                    for(j = 0; j < 9; j++) {
                        input[i][j] = Integer.parseInt(tokens[j], 10);
                    }
                    i++;
                }      

                SudokuSolver solver = new SudokuSolver(input);
                input = solver.run();

                for (int row = 0; row < 9; row++)
                {
                    for (int col = 0; col < 9; col++)
                        System.out.print(input[row][col] + " ");
                    System.out.print("\n");
                }

            }
        } catch(IOException e) {
            System.out.println("Error reading from file");
        }
    }
}
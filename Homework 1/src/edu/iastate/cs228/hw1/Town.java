 package edu.iastate.cs228.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author <<Write your name here>>
 *
 */

public class Town {
	private int length, width; // Row and col (first and second indices)
	public TownCell[][] grid;

	/**
	 * Constructor to be used when user wants to generate grid randomly, with the
	 * given seed. This constructor does not populate each cell of the grid (but
	 * should assign a 2D array to it).
	 * 
	 * @param length
	 * @param width
	 */
	public Town(int length, int width) {
		this.length = length;
		this.width = width;
		grid = new TownCell[length][width];
	}

	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simple throws FileNotFoundException exception instead of
	 * catching it. Ensure that you close any resources (like file or scanner) which
	 * is opened in this function.
	 * 
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException {
		//System.out.println(inputFileName);
		Scanner s = new Scanner(new File(inputFileName));
		length = s.nextInt();
		width = s.nextInt();

		grid = new TownCell[length][width];

		// System.out.println(length + " " + width);
		int x = 0;
		int a = 0;
		while (s.hasNext()) {
			while (x < length) {
				String value = s.next();
				
				switch (value) {
				case "R":
					grid[a][x] = new Reseller(this, a, x);
					break;
				case "E":
					grid[a][x] = new Empty(this, a, x);
					break;
				case "C":
					grid[a][x] = new Casual(this, a, x);
					break;
				case "O":
					grid[a][x] = new Outage(this, a, x);
					break;
				case "S":
					grid[a][x] = new Streamer(this, a, x);
					break;
				}
				x++;
			}
			x = 0;
			a++;
		}
	}

	/**
	 * Returns width of the grid.
	 * 
	 * @return width
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Returns length of the grid.
	 * 
	 * @return length
	 */
	public int getLength() {
		return this.length;
	}

	// TODO: write documentation
	public TownCell[][] getTown() {
		return grid;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following
	 * class object: Casual, Empty, Outage, Reseller OR Streamer
	 */
	public void randomInit(int seed) {
		Random rand = new Random(seed);
		int r = rand.nextInt(5);

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				switch (r) {
				case 0:
					grid[i][j] = new Reseller(this, i, j);
					break;
				case 1:
					grid[i][j] = new Empty(this, i, j);
					break;
				case 2:
					grid[i][j] = new Casual(this, i, j);
					break;
				case 3:
					grid[i][j] = new Outage(this, i, j);
					break;
				case 4:
					grid[i][j] = new Streamer(this, i, j);
					break;
				}

				r = rand.nextInt(5);
			}
		}
	}

	/**
	 * Output the town grid. For each square, output the first letter of the cell
	 * type. Each letter should be separated either by a single space or a tab. And
	 * each row should be in a new line. There should not be any extra line between
	 * the rows.
	 */
	@Override
	public String toString() {
		String s = "";

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				s = s + checkValue(grid[i][j]) + " ";
			}
			s = s + "\n";
		}
		return s;
	}

	// TODO: Write Documentation
	private String checkValue(TownCell c) {
		State state = c.who();

		switch (state) {
		case EMPTY:
			return "E";
		case CASUAL:
			return "C";
		case OUTAGE:
			return "O";
		case STREAMER:
			return "S";
		case RESELLER:
			return "R";
		}

		return "B";
	}

	// TODO: Write Documentation
	public void addCell(TownCell c, int row, int col) {
		grid[row][col] = c;
	}
}

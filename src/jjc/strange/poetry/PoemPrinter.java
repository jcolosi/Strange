package jjc.strange.poetry;

import java.util.Random;

public class PoemPrinter {
	static public int LINES = 65;
	static public int LOCK = 6;

	// This ensures that the center gets written.
	static public double FudgeFactor = .5;
	static public double FudgeCoef = .35;

	// The poem lines
	static public String[] POEM = {
			//
			"     inside my heart is an ocean     ",
			"at the bottom of the ocean is a shell",
			"     inside the shell is a pearl     ",
			"       inside the pearl is me        ",
			"        inside me is my heart        ", };

	private static final Random rand = new Random();

	static void show() {
		double theta, ratio;
		char[] toWrite;

		for (int line = 0; line < LINES; line++) {
			toWrite = POEM[line % POEM.length].toCharArray();
			theta = ((double) line / LINES) * Math.PI;
			ratio = (Math.sin(theta) * FudgeFactor) + FudgeCoef;

			System.out.format("%d: ", line / POEM.length);
			if (line / POEM.length == LOCK) ratio = 1;

			for (char c : toWrite) {
				if (rand.nextDouble() < ratio) System.out.print(c);
				else System.out.print(' ');
			}

			System.out.println();
		}

	}

	static public void main(String[] args) {
		PoemPrinter.show();
	}
}

package spiral2D;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class LowerLeftCorner {

	private static int[][] spiral;
	private static int sum;
	private static int cordinateY;
	private static int cordinateX;
	private static int leftCounter = 0;
	private static int upCounter = -1;

	public static void direction(int rows, int collums) {

		var goingDirection = JOptionPane.showConfirmDialog(null, "Želite da spirala ide u smjeru kazaljki na satu?",
				null, JOptionPane.YES_NO_OPTION);

		spiral = new int[rows][collums];
		sum = rows * collums;
		cordinateY = rows - 1;
		cordinateX = collums - 1;

		switch (goingDirection) {
		case JOptionPane.YES_OPTION -> clockwise();
		default -> counterClockwise();
		}

	}

	private static void clockwise() {
		while (true) {
			upClockwise();
			if (yes())
				break;
			rightClockwise();
			if (yes())
				break;
			downClockwise();
			if (yes())
				break;
			leftClockwise();
			if (yes())
				break;

		}

		Output.printingSpiral(spiral);
	}

	private static void counterClockwise() {

		while (true) {
			rightCounterClockwise();
			if (yes())
				break;
			upCounterClockwise();
			if (yes())
				break;
			leftCounterClockwise();
			if (yes())
				break;
			downCounterClockwise();
			if (yes())
				break;
		}

		Output.printingSpiral(spiral);

	}

	private static void upClockwise() {
		int count = countNumber();
		for (int i = cordinateY; i > upCounter; i--) {
			spiral[i][upCounter + 1] = ++count;
		}
	}

	private static void rightClockwise() {
		int count = countNumber();
		leftCounter++;
		for (int i = leftCounter; i < cordinateX + 1; i++) {
			spiral[leftCounter - 1][i] = ++count;
		}
	}

	private static void downClockwise() {
		int count = countNumber();
		for (int i = leftCounter; i < (cordinateY + 1); i++) {
			spiral[i][cordinateX] = ++count;
		}
		cordinateX--;
	}

	private static void leftClockwise() {
		int count = countNumber();
		upCounter++;
		for (int i = cordinateX; i > upCounter; i--) {
			spiral[cordinateY][i] = ++count;
		}
		cordinateY--;
	
	}

	private static void rightCounterClockwise() {
		int count = countNumber();
		for (int i = leftCounter; i < (cordinateX + 1); i++) {
			spiral[cordinateY][i] = ++count;
		}
		cordinateY--;

	}

	private static void upCounterClockwise() {
		int count = countNumber();
		for (int i = cordinateY; i > upCounter; i--) {
			spiral[i][cordinateX] = ++count;
		}
		upCounter++;
		cordinateX--;

	}

	private static void leftCounterClockwise() {
		int count = countNumber();
		for (int i = cordinateX; i > upCounter; i--) {
			spiral[upCounter][i] = ++count;
		}

	}

	private static void downCounterClockwise() {
		int count = countNumber();
		for (int i = leftCounter; i < (cordinateY + 1); i++) {
			spiral[i][leftCounter] = ++count;
		}
		leftCounter++;

	}

	private static int countNumber() {
		int number = 0;
		for (int i = 0; i < spiral.length; i++) {
			for (int j = 0; j < spiral[i].length; j++) {
				if (spiral[i][j] > number) {
					number = spiral[i][j];
				}
			}
		}
		return number;
	}

	private static boolean yes() {
		if (countNumber() == sum) {
			return true;
		} else {
			return false;
		}
	}
}

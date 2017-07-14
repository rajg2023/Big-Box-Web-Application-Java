package util.bigbox.web;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Validator.
 */
public class Validator {
	
	/**
	 * Gets the line.
	 *
	 * @param sc the sc
	 * @param prompt the prompt
	 * @return the line
	 */
	public static String getLine(Scanner sc, String prompt) {
		System.out.print(prompt);
		String s = sc.nextLine(); // read the whole line
		return s;
	}

	/**
	 * Gets the string.
	 *
	 * @param sc the sc
	 * @param prompt the prompt
	 * @return the string
	 */
	public static String getString(Scanner sc, String prompt) {
		System.out.print(prompt);
		String s = sc.nextLine(); // read the first string on the line
		// sc.nextLine(); // discard the rest of the line
		return s;
	}

	/**
	 * Gets the string with length.
	 *
	 * @param sc the sc
	 * @param prompt the prompt
	 * @param length the length
	 * @return the string with length
	 */
	public static String getStringWithLength(Scanner sc, String prompt, int length) {
		String s = "";
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			s = sc.next(); // read the first string on the line
			if (s.length() == length) {
				isValid = true;
			} else {
				System.out.println("Error! length. Should be " + length + " characters.  Try again.");
				sc.nextLine(); // discard the rest of the line
			}

		}
		return s;
	}

	/**
	 * Gets the string numeric.
	 *
	 * @param sc the sc
	 * @param prompt the prompt
	 * @param length the length
	 * @return the string numeric
	 */
	public static String getStringNumeric(Scanner sc, String prompt, int length) {
		String s = "";
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextInt()) { // even though this is a String, the values
									// should be numeric
				s = sc.next(); // read the first string on the line
				if (s.length() == length) {
					if (isPositive(s))
						isValid = true;
					else {
						System.out.println(
								"Error you have entered negative values!! Value shoule be positive and greater than 0");
					}
				} else
					System.out.println("Error! length. Should be " + length + " characters.  Try again.");
			} else
				System.out.println("Error! Should be a numeric value.  Try again.");
			sc.nextLine(); // discard the rest of the line
		}
		return s;
	}

	/**
	 * Gets the int.
	 *
	 * @param sc the sc
	 * @param prompt the prompt
	 * @return the int
	 */
	public static int getInt(Scanner sc, String prompt) {
		boolean isValid = false;
		int i = 0;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

	/**
	 * Gets the int with range.
	 *
	 * @param sc the sc
	 * @param prompt the prompt
	 * @param min the min
	 * @param max the max
	 * @return the int with range
	 */
	public static int getIntWithRange(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(sc, prompt);
			if (i <= min)
				System.out.println("Error! Number must be greater than " + min);
			else if (i >= max)
				System.out.println("Error! Number must be less than " + max);
			else
				isValid = true;
		}
		return i;
	}

	/**
	 * Gets the double.
	 *
	 * @param sc the sc
	 * @param prompt the prompt
	 * @return the double
	 */
	public static double getDouble(Scanner sc, String prompt) {
		boolean isValid = false;
		double d = 0;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			} else {
				System.out.println("Error! Invalid decimal value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return d;
	}

	/**
	 * Gets the double.
	 *
	 * @param sc the sc
	 * @param prompt the prompt
	 * @param min the min
	 * @param max the max
	 * @return the double
	 */
	public static double getDouble(Scanner sc, String prompt, double min, double max) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			d = getDouble(sc, prompt);
			if (d <= min)
				System.out.println("Error! Number must be greater than " + min);
			else if (d >= max)
				System.out.println("Error! Number must be less than " + max);
			else
				isValid = true;
		}
		return d;
	}

	/**
	 * Gets the choice.
	 *
	 * @return the choice
	 */
	// method for choice
	public static String getChoice() {
		// See if user wants to play again
		String choice = "";
		while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
			System.out.println("Continue? (y/n): ");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			choice = sc.next();
			if (choice.equals("  ")) {
				System.out.println("Error! This Entry is required . Try again.");
			}
			if (choice.equalsIgnoreCase("y")) {

			}

			if (choice.equalsIgnoreCase("n")) {
				System.out.println("Thank You for using BigBoxApp. Bye!");
				System.exit(0);
			}

			if (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
				System.out.println("Error! Entry must be 'y' or 'n'!");
			} // End if Loop.
				// sc.close();
		} // End While Choice Loop.
		return choice;

	}

	/**
	 * Checks if is positive.
	 *
	 * @param s the s
	 * @return true, if is positive
	 */
	/*
	 * Note this method expects the string to be numeric
	 */
	private static boolean isPositive(String s) {
		int i = Integer.parseInt(s);
		return isPositive(i);
	}

	/**
	 * Checks if is positive.
	 *
	 * @param i the i
	 * @return true, if is positive
	 */
	private static boolean isPositive(int i) {
		boolean positive = false;
		if (i >= 0) {
			positive = true;
		}
		return positive;
	}
}
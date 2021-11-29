package javaswing;

import javax.swing.*;

/*
 * Game to guess correct number using javaswing JOptionPane
 */
public class NumGuesser {

	/*
	 * Output of user input
	 */
	public static String check(int userIn, int numGen) {
		String ans = "";

		if (userIn == numGen)
			ans = "Correct!";

		else if (userIn < numGen)
			ans = "Too Low!";

		else if (userIn > numGen)
			ans = "Too High!";

		else
			ans = "Incorrect!";

		return ans;
	}

	/*
	 * Retry the game
	 */
	public static boolean retry(String ans) {

		if (ans.equals("y"))
			return true;

		else
			return false;

	}

	public static void main(String[] args) {
		boolean retry = true;
		while (retry) {
			String num = JOptionPane.showInputDialog(null, "Pick max number value to guess");
			int genNum = Integer.parseInt(num);
			int numGen = (int) (Math.random() * genNum + 1);
			int userIn = 0;
			int count = 1;

			while (userIn != numGen) {
				String response = JOptionPane.showInputDialog(null, "Enter a guess between 1 and" + genNum,
						"Guessing Game", 3);

				userIn = Integer.parseInt(response);
				JOptionPane.showMessageDialog(null, "" + check(userIn, numGen));
				count++;

			}
			System.out.println(count + " guesses!");
			System.out.println("Correct answer: ");

			String redo = JOptionPane.showInputDialog(null, "Play again? (y/n)");
			retry = retry(redo);
		}

	}
}

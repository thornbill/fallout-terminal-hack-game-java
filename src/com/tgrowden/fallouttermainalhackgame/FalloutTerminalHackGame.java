package com.tgrowden.fallouttermainalhackgame;

import java.util.Scanner;

class FalloutTerminalHackGame {
	public static void main(String[] args) {
		System.out.println("Starting...");
		Scanner scan = new Scanner(System.in);
		Game game;
		String userGuess;
		for (int i = 0; i <= 7; i++) {
			int[] params = FalloutTerminalHackGame.getParamsForAttempt(i);
			game = new Game(params[0], params[1]);
			while (!game.solved) {
				if (game.remainingGuesses == 0) { // Whoops, we're out of guesses. Repeat on the same difficulty
					System.out.printf("\nfailure... The solution was %s\n", game.solution);
					game = new Game(params[0], params[1]);
				} else if (game.isLucky) { // Handling of a "lucky" guess; let's do this one again...
					System.out.println("\nLucky guess! Let's try this difficulty again...\n");
					game = new Game(params[0], params[1]);
				}
				game.displayOptions();
				if (game.remainingGuesses > 1) {
					System.out.printf("%s tries remaining: ", game.remainingGuesses);
				} else {
					System.out.print("Last try: ");
				}
				userGuess = scan.next();
				game.attempt(userGuess);
			}
			System.out.printf("\nsuccess! The answer was %s", game.solution);
		}
	}

	/**
	 * Retrieves the proper params for a given Game instance iteration
	 * @param attempt The attempt number
	 * @return
	 */
	public static int[] getParamsForAttempt(int attempt) {
		int wordLength, wordListLength;
		switch (attempt) {
			case 0:
				wordLength = 4;
				wordListLength = 12;
				break;
			case 1:
				wordLength = 5;
				wordListLength = 13;
				break;
			case 2:
				wordLength = 6;
				wordListLength = 14;
				break;
			case 3:
				wordLength = 7;
				wordListLength = 15;
				break;
			case 4:
				wordLength = 8;
				wordListLength = 15;
				break;
			case 5:
				wordLength = 9;
				wordListLength = 15;
				break;
			case 6:
				wordLength = 10;
				wordListLength = 15;
				break;
			case 7:
				wordLength = 10;
				wordListLength = 19;
				break;
			default:
				wordLength = 0;
				wordListLength = 0;
		}

		int res[] = { wordLength, wordListLength };

		return res;
	}
}

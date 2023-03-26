package com.jspiders.musicplayerhibernate.main;

import java.util.Scanner;

import com.jspiders.musicplayerhibernate.songoperation.SongDriver;

public class MusicPlayer extends SongDriver {
	private static Scanner sc;
	private static SongDriver songDriver;
	private static MusicPlayer musicPlayer;
	private static boolean loop;

	public static void home() {
		try {

			sc = new Scanner(System.in);
			songDriver = new MusicPlayer();
			musicPlayer = (MusicPlayer) songDriver;

			System.out.println(
					"************** WELCOME ***************** \n 1. Play All \n 2. Play Single \n 3. Library  \n 4. Exit ");
			int input = sc.nextInt();
			switch (input) {
			// display all song present in database
			case 1: {
				musicPlayer.getSong();
				break;
			}
			// select and display single song from database
			case 2: {
//				musicPlayer.chooseSong();
				break;
			}
			case 3: {
				boolean loop1 = true;
				while (loop1) {
					System.out.println(
							" ***************** LIBRARY ****************** \n 1. Add Song \n 2. Delete all song \n 3. Go Back");
					int input1 = sc.nextInt();
					switch (input1) {
					// insert song values into song table inside database
					case 1:
						musicPlayer.addSong();
						break;
						// truncate data from database
					case 2: {
						System.out.println("Are you sure! y/n");
						String input2 = sc.next();
						if (input2.equals("y")) {
//							musicPlayer.deleteAll();
						}
					}
						break;
					case 3: {
						System.out.println("Thank You ##### Exiting Music Player... ");
						loop1 = false;
					}
						break;
					}
				}
				break;
			}
			case 4: {
				loop = false; // Exit and stop Execution
				sc.close();
				break;
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		loop = true;
		while (loop) {
			home();
		}

	}
}

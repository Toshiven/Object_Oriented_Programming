/*
*Abler, Andrew Kevin M.
*BSIT 2D
*T233
*25/20/2022
*Student Information System
*/
package Main;

import java.util.Scanner;


public class MainMenu{
	
	Scanner scan = new Scanner(System.in);
	StudentMenu studentMenu;
	HelpMenu helpMenu;
	
	public MainMenu() {
		studentMenu = new StudentMenu(this,scan);
		helpMenu = new HelpMenu(this,scan);
		
	}
	
	/**
	 * Show menu shows the main menu of the program
	 * and handles the user choice with appropriate calls to methods that provide the functionalities for a given choice.
	 */
	
	public void ShowMenu() {
		System.out.println("\n\n==========Main Menu==========\n\n");
		System.out.println("1. Student");
		System.out.println("2. Help");
		System.out.println("\n\n==========Main Menu==========");
		int choice = scan.nextInt();
		
		switch(choice) {
		case 1:
			studentMenu.studentMenu();
			break;
		case 2:
			helpMenu.helpMenu();
			break;
		}
	}
	
}

/*
*Abler, Andrew Kevin M.
*BSIT 2D
*T233
*25/20/2022
*Student Information System
*/
package Main;

import java.util.Scanner;

import Controller.StudentController;

public class HelpMenu extends StudentController{
	MainMenu mainMenu;
	Scanner scan;
	
	public HelpMenu(MainMenu mainMenu, Scanner scan) {
		this.mainMenu = mainMenu;
		this.scan = scan;
	}
	/**
	 * Help method calls the displayHelpMenu() method to show help menu to the user
	 * and handles the user choice with appropriate calls to methods that provide the functionalities for a given choice.
	 */
	public void helpMenu() {
		boolean finished = false;
		do {
			String choice = displayHelpMenu();
			switch (choice) {
			case "Back":
			case "back":
				mainMenu.ShowMenu();
				return;
			case "Display commands":
			case "display commands":
				displayHelp();
				break;
			case "Exit":
			case "exit":
				this.studentList.saveStudentList(studentList);
				finished = true;
			}
		} while (! finished );
	}
}

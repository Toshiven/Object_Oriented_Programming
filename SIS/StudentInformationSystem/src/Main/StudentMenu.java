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

public class StudentMenu extends StudentController{
	MainMenu mainMenu;
	Scanner scan;
	
	public StudentMenu(MainMenu mainMenu, Scanner scan) {
		this.mainMenu = mainMenu;
		this.scan = scan;
	}
	
	/**
	* Student method calls the displayStudentListMenu() method to show a user menu to the user
	* and handles the user choice with appropriate calls to methods that provide the functionalities for a given choice.
	*/
		public void studentMenu() {
			boolean finished = false;
			do {
				String choice = displayStudentListMenu();
				switch (choice) {
				case "Back":
				case "back":
					mainMenu.ShowMenu();
					return;
				case "Display":
				case "display":
				case "Display list":
				case "display list":
					displayList();
					break;
				case "Display details":
				case "display details":
				case "Display list with student details":
				case "display list with student details":
					displayListWithFullDetails();
					break;
				case "Add":
				case "add":
				case "Add student":
				case "add student":
					addStudentToList();
					break;
				case "Add grades":
				case "add grades":
				case "Add student grades":
				case "add student grades":
					addStudentGrades();
					break;
				case "Search":
				case "search":
				case "Search student":
				case "search student":
					String searchBy = displaySearchMenu();
					switch (searchBy) {
					case "Search ID":
					case "search ID":
					case "ID":
					case "id":
						searchStudentFromList("ID");
						break;
					case "Search name":
					case "search name":
					case "Name":
					case "name":
						searchStudentFromList("Name");
						break;
					default:
						studentMenu();
						break;
					}
					break;

				case "Delete":
				case "delete":
				case "Delete student":
				case "delete student":
					String deleteBy = displayDeleteMenu();
					switch (deleteBy) {
					case "Delete ID":
					case "delete ID":
					case "ID":
					case "id":
						deleteStudentFromList("ID");
						break;
					case "Delete name":
					case "delete name":
					case "Name":
					case "name":
						deleteStudentFromList("Name");
						break;
					default:
						studentMenu();
						break;
					}
					break;

				case "Exit":
				case "exit":
					this.studentList.saveStudentList(studentList);
					finished = true;
				}
			} while (! finished );
		}
}

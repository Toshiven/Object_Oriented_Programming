/*
*Abler, Andrew Kevin M.
*
*StudentController creates and displays the menu to navigate the program.
*It runs the code from StudentList for Adding, Removing, Searching & Displaying of Students.
*/
package Controller;

import Input.InputHelper;
import List.StudentList;
import Model.Student;


public class StudentController {
	protected StudentList studentList;

/**
* Constructor starts by reading a student list object from a file.
* This object may contain user information from the previous session.
*/
	public StudentController() {
		this.studentList = new StudentList();
		this.studentList = (this.studentList.readStudentList() == null) ? new StudentList() : this.studentList.readStudentList();
		System.out.println("Your list was loaded");
	}



/**
* Displays a student menu list of options for navigating the application. 
* @return character input, choice representing the menu chosen by the user.
*/
	protected String displayStudentListMenu() {
		InputHelper inputHelper = new InputHelper();
		System.out.println("==========Student Menu==========");
		System.out.printf("\n%s\t%s\t%s\t%s\t%s\t%s\t%s","\tBack\n" ,"Display List\n", "Display List with Student Details\n", "Add student\n", "Search Student\n", "Delete Student\n", "Exit\n\n");
		System.out.println("==========Student Menu==========");
		return inputHelper.readString("Enter choice");
	}
	
	
	/**
	* Displays a help menu list of options for navigating the application and checking the application commands. 
	* @return character input, choice representing the menu chosen by the user.
	*/
	protected String displayHelpMenu() {
		InputHelper inputHelper = new InputHelper();
		System.out.println("==========Help Menu==========");
		System.out.printf("\n%s\t%s", "\tBack\n", "Display commands\n\n");
		System.out.println("==========Help Menu==========");
		return inputHelper.readString("Enter choice");
	}
	
	/**
	 * Displays list of commands.
	 */
	protected void displayHelp() {
		System.out.println("==========COMMANDS==========");
		System.out.println("Back: back, Back");
		System.out.println("Display list: Display, display, Display list, display list");
		System.out.println("Display list with full details: Display details, display details, Display list with student details, display list with student details");
		System.out.println("Add student: Add, add, Add student, add student");
		System.out.println("Search student: Search, search, Search student, search student");
		System.out.println("Search ID/Search name: Search ID, search ID, ID, id, Search name, search name, Name, name");
		System.out.println("Delete Student: Delete, delete, Delete student, delete student");
		System.out.println("Delete ID/Delete name: Delete ID, delete ID, Delete Name, delete name");
		System.out.println("Add student grades: Add grades, add grades, Add student grades, add student grades");
		System.out.println("Exit and save: Exit, exit");
	}

/**
* Displays a sub-menu list that allows the user to navigate the search menu.
* @return character input, choice representing the sub-menu chosen by the user.
*/
	protected String displaySearchMenu() {
		InputHelper inputHelper = new InputHelper();
		System.out.printf("\n%s\t%s\t%s", "\tSearch by Student ID\n", "Search by Student Name\n", "Cancel\n");
		return inputHelper.readString("Enter choice");
	}

/**
* Displays a sub-menu list of options for removing a student from the list. 
* @return character input, choice representing the sub-menu chosen by the user.
*/
	protected String displayDeleteMenu() {
		InputHelper inputHelper = new InputHelper();
		System.out.printf("\n%s\t%s\t%s", "\tDelete by Student ID\n", "Delete by Student Name\n", "Cancel\n");
		return inputHelper.readString("Enter choice");
	}

/**
* Displays students within the double linked list without their details. 
* Call the method displayListWithFullDetails() for full student details.
*/
	protected void displayList() {
		if (this.studentList.length() == 0) {
			System.out.println("List is empty");
		} else {
			System.out.println(this.studentList.toString());
		}
	}

/**
* Displays students within the double linked list full their full details. 
* Call the method displayList() to hide the details.
*/
	protected void displayListWithFullDetails() {
		if (this.studentList.length() == 0) {
			System.out.println("List is empty");
		}
		this.studentList.display();
	}

/**
* Adds a Student to the Student list by prompting the user to input the following information:
* ID, name, number of subjects and enrolment date.
* 
* Note: This makes it possible to create a student without further information such as grades for each subject. 
* Call method addStudentGrades() to add grades for each subject the student has taken.
*/
	protected void addStudentToList() {
		InputHelper inputHelper = new InputHelper();
		int ID = inputHelper.readInt("Enter Valid Student ID. eg.: 1001");
		String name = inputHelper.readStringOnly("Enter Student Name");
		int age = inputHelper.readInt("Enter age");
		String address = inputHelper.readCategory("Enter Student Address");
		int numOfSubjects = inputHelper.readInt("Enter the number of subjects");
		String enrolmentDate = inputHelper.readDate("Enter the date of enrolment in the format DD/MM/YYYY");

		Student studentToAdd = new Student(ID, name, age, numOfSubjects, address, enrolmentDate);
		studentList.insertLast(studentToAdd);
		System.out.println("Student " + ID + " added. Please note that student has no grades. Choose 'G' to add student Grades");
	}
	
	
/**
* Condition: List of students is not empty.
* Given that your list of students is not empty, 
* this method allows for adding each subject the student has taken and their grades.
*/
	protected void addStudentGrades() {
		if (this.studentList.length() == 0) {
			System.out.println("List is empty");
		} else {
			InputHelper inputHelper = new InputHelper();
			String studentName = inputHelper.readString("Enter Student Name");
			this.studentList.addStudentGrades(studentName);
		}

	}

/**
* Condition: Student list is not empty and Student is in the list.
* This method can search a student object from the list given its ID or Name
* The student details of that specific student will be displayed by calling the display() method.
* @param type an ID or Name indicating how the user wants to search the student.
*/
	protected void searchStudentFromList(String type) {
		InputHelper inputHelper = new InputHelper();
		try {
			if (type.equals("ID")) {
				int ID = inputHelper.readInt("Enter Valid Student ID. eg.: 1001");
				this.studentList.searchNodebyID(ID).getStudent().display();

			} else {
				String name = inputHelper.readString("Enter Student Name");
				this.studentList.searchNodebyName(name).getStudent().display();
			}

		} catch(Exception e) {
			System.out.println("Invalid Search (Name or ID is invalid)");
		}

	}

/**
* Condition: Student list is not empty and Student is in the list.
* This method can delete a student object from the list given its ID or Name.
* @param type an ID or Name indicating how the user wants to delete the student.
*/
	protected void deleteStudentFromList(String type) {
		InputHelper inputHelper = new InputHelper();
		if (type.equals("ID")) {
			int ID = inputHelper.readInt("Enter Valid Student ID. eg.: 1001");
			this.studentList.deleteByID(ID);
		} else {
			String name = inputHelper.readString("Enter Valid Student Name. eg.: Andrew");
			this.studentList.deleteByName(name);
		}
	}
}
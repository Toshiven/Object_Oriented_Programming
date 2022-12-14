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
	private StudentList studentList;

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
* Run method calls the displayStudentListMenu() method to show a user menu to the user
* and handles the user choice with appropriate calls to methods that provide the functionalities for a given choice.
*/
	public void run() {
		boolean finished = false;
		do {
			char choice = displayStudentListMenu();
			switch (choice) {
			case 'A':
				displayList();
				break;
			case 'B':
				displayListWithFullDetails();
				break;
			case 'C':
				addStudentToList();
				break;
			case 'G':
				addStudentGrades();
				break;
			case 'S':
				char searchBy = displaySearchMenu();
				switch (searchBy) {
				case 'A':
				case 'a':
					searchStudentFromList("ID");
					break;
				case 'B':
				case 'b':
					searchStudentFromList("Name");
					break;
				default:
					run();
					break;
				}
				break;

			case 'D':
				char deleteBy = displayDeleteMenu();
				switch (deleteBy) {
				case 'A':
				case 'a':
					deleteStudentFromList("ID");
					break;
				case 'B':
				case 'b':
					deleteStudentFromList("Name");
					break;
				default:
					run();
					break;
				}
				break;

			case 'E':
				this.studentList.saveStudentList(studentList);
				finished = true;
			}
		} while (! finished );
	}

/**
* Displays a menu list of options for navigating the application. 
* @return character input, choice representing the menu chosen by the user.
*/
	private char displayStudentListMenu() {
		InputHelper inputHelper = new InputHelper();
		System.out.printf("\n%s\t%s\t%s\t%s\t%s\t%s\t%s", "\tA.Display List\n", "B.Display List with Student Details\n", "C.Add a new Student\n", "G.Add Student Grades\n", "S.Search Student\n", "D.Delete Student\n", "E.Exit\n\n");
		return inputHelper.readCharacter("Enter choice", "ABCGSDE");
	}

/**
* Displays a sub-menu list that allows the user to navigate the search menu.
* @return character input, choice representing the sub-menu chosen by the user.
*/
	private char displaySearchMenu() {
		InputHelper inputHelper = new InputHelper();
		System.out.printf("\n%s\t%s\t%s", "\tA.Search by Student ID\n", "B.Search by Student Name\n", "C.Cancel\n");
		return inputHelper.readCharacter("Enter choice", "ABC");
	}

/**
* Displays a sub-menu list of options for removing a student from the list. 
* @return character input, choice representing the sub-menu chosen by the user.
*/
	private char displayDeleteMenu() {
		InputHelper inputHelper = new InputHelper();
		System.out.printf("\n%s\t%s\t%s", "\tA.Delete by Student ID\n", "B.Delete by Student Name\n", "C.Cancel\n");
		return inputHelper.readCharacter("Enter choice", "ABC");
	}

/**
* Displays students within the double linked list without their details. 
* Call the method displayListWithFullDetails() for full student details.
*/
	private void displayList() {
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
	private void displayListWithFullDetails() {
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
	private void addStudentToList() {
		InputHelper inputHelper = new InputHelper();
		int ID = inputHelper.readInt("Enter Valid Student ID. eg.: 001");
		String name = inputHelper.readStringOnly("Enter Student Name");
		String address = inputHelper.readCategory("Enter Student Address");
		int numberOfSubjects = inputHelper.readInt("Enter the (int) number of subjects");
		String enrolmentDate = inputHelper.readDate("Enter the date of enrolment in the format DD/MM/YYYY");

		Student studentToAdd = new Student(ID, name, numberOfSubjects, enrolmentDate, address);
		studentList.insertLast(studentToAdd);
		System.out.println("Student " + ID + " added. Please note that student has no grades. Choose 'G' to add student Grades");
	}

/**
* Condition: List of students is not empty.
* Given that your list of students is not empty, 
* this method allows for adding each subject the student has taken and their marks.
*/
	private void addStudentGrades() {
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
	private void searchStudentFromList(String type) {
		InputHelper inputHelper = new InputHelper();
		try {
			if (type.equals("ID")) {
				int ID = inputHelper.readInt("Enter Valid Student ID. eg.: 001");
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
	private void deleteStudentFromList(String type) {
		InputHelper inputHelper = new InputHelper();
		if (type.equals("ID")) {
			int ID = inputHelper.readInt("Enter Valid Student ID. eg.: 001");
			this.studentList.deleteByID(ID);
		} else {
			String name = inputHelper.readString("Enter Valid Student Name. eg.: Andrew");
			this.studentList.deleteByName(name);
		}
	}
}
/*
*Abler, Andrew Kevin M.
*BSIT 2D
*T233
*
*StudentApp contains the main method and is where the program starts.
*/
package Main;

import Controller.StudentController;


public class StudentApp {

/**
*The method run() is called from the main method to run the StudentController,
*which is the class that contains the code to handle the menu.
*/
	public static void run() {
		System.out.println("This is the Student Information System!");

		StudentController studentController = new StudentController();

		studentController.run();

		System.out.println("Your data was saved.\nThank you for using the Student Information System. Good bye.\n");
	}

/**
* Runs the entire program.
*/
	public static void main(String[] args) {
		StudentApp studentApp = new StudentApp();
		StudentApp.run();
	}
}
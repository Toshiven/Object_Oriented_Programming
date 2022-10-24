/*
*Abler, Andrew Kevin M.
*BSIT 2D
*T233
*25/20/2022
*Student Information System
*
*StudentApp contains the main method and is where the program starts.
*/
package Main;

public class Main {
	/**
	*The method run() is called from the main method to run the MainMenu,
	*which is the class that contains the code to handle the menu.
	*/
		public static void run() {
			System.out.println("This is the Student Information System!");

			MainMenu mainMenu = new MainMenu();

			mainMenu.ShowMenu();

			System.out.println("Your data was saved.\nThank you for using the Student Information System. Good bye.\n");
		}

	/**
	* Runs the entire program.
	*/
		public static void main(String[] args) {
			Main main = new Main();
			Main.run();
		}
}

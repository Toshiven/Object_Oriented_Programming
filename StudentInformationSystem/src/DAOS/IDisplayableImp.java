/**
*Abler, Andrew Kevin M.
*
IDisplayableImp is the class which implements IDisplayable.
*/
package DAOS;

import Model.Student;


public class IDisplayableImp implements IDisplayable {

/**
*The method display() is overridden here to be implemented.
*/
	@Override
	public void display() {
		System.out.print("IDisplayable implemented.");
		System.out.println("\n***---***---***---***");

		Student student = new Student(1, "Andrew", 2, "Bangcud", "27/04/2002");
		student.setGrades();
		student.display();
	}
}
/**
*Abler, Andrew Kevin M.
* 
*ListNode handles node creation, and the moving forward and backwards in the list. 
*It contains the getters and setters for student. 
*/
package Node;

import DAOS.IDisplayable;
import java.io.Serializable;
import Model.Student;


public class ListNode implements IDisplayable, Serializable {
	    private Student student;
        public ListNode next;
        public ListNode previous;

/**
*
* @param value
*/
    public ListNode(Student value) {
		this.student = value;
	}

/**
*
* @return
*/
    public Student getStudent() {
		return student;
	}

/**
*
* @param student
*/
    public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return getStudent().getStudentName();
	}

/**
*
*/
    @Override
	public void display() {
		getStudent().display();
	}

}
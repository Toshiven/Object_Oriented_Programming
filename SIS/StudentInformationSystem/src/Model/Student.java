/**
*Abler, Andrew Kevin M.
*
*Student contains the data for a student, such as studentID, studentName, etc. 
*It contains the getters and setters for the private variables. 
*/
package Model;

import Input.InputHelper;
import DAOS.IDisplayable;
import java.io.Serializable;
import java.util.ArrayList;

/**
*
* @param <Address>
*/
public class Student < Address > implements IDisplayable,
Serializable {

	private int studentID;
	private String studentName;
	private int numOfSubjects;
	private ArrayList < Subject > gradesForEachSubject = new ArrayList < >();
	private String enrolmentDate;
	private Address studentAddress;
	private int age;



/**
*
* @param studentID
* @param studentName
* @param numOfSubjects
* @param enrolmentDate
* @param studentAddress
*/
	public Student(int studentID, String studentName, int age, int numOfSubjects, Address studentAddress, String enrolmentDate) {

		this.studentID = studentID;
		this.studentName = studentName;
		this.age = age;
		this.enrolmentDate = enrolmentDate;
		this.studentAddress = studentAddress;
		this.numOfSubjects = numOfSubjects;

	}

/**
*Student constructor.
*/
	public Student() {

}

/**
*
* @return
*/
	public int getStudentID() {
		return studentID;
	}

/**
*
* @param sID
*/
	public void setStudentID(int sID) {
		this.studentID = sID;
	}

/**
*
* @return
*/
	public String getStudentName() {
		return studentName;
	}

/**
*
* @param studentName
*/
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

/**
*
* @return
*/
	public int getNumOfSubjects() {
		return numOfSubjects;
	}

/**
*
* @param numOfSubjects
*/
	public void setNumOfSubjects(int numOfSubjects) {
		this.numOfSubjects = numOfSubjects;
	}

/**
*Sets the grades for a specific student.
*Uses a counter to keep track of number of subjects,
*then asks for the same amount of grades for each subjects.
*/
	public void setGrades() {
		InputHelper inputHelper = new InputHelper();
		int counter = 1;
		if (this.gradesForEachSubject.size() >= getNumOfSubjects()) { //check if grade has been assigned already
			System.out.println("Student already has grade");
		} else {
			for (int i = 0; i < getNumOfSubjects(); i++) {
				String subjectName = inputHelper.readStringOnly("Enter subject " + counter + " name");
				int subjectGrade = inputHelper.readInt("Enter subject grade");
				Subject subject = new Subject(subjectName, subjectGrade);
				this.gradesForEachSubject.add(subject);
				counter++;
			}
			System.out.print("Information added\n");
		}

	}

/**
*Gets the average grades for each student.
* @return
*/
	public double getAverage() {
		double average = 0f;
		for (Subject grades: gradesForEachSubject) {
			average += grades.getGrade();
		}
		return (average / getNumOfSubjects());
	}

/**

* @param subjectName
* @return
*/
	public int getGradesForASubject(String subjectName) {
		return gradesForEachSubject.indexOf(subjectName);
	}

/**
*
* @return
*/
	public String getGradesForEachSubject() {
		String gradesForEachSubject = "";
		for (Subject subject: this.gradesForEachSubject) {
			gradesForEachSubject += subject;
		}
		return gradesForEachSubject;
	}

/**
*
* @return
*/
	public String getStudentAddress() {
		return (String) studentAddress;
	}

/**
*
* @param studentCategory
*/
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

/**
*
* @return
*/
	public String getEnrolmentDate() {
		return enrolmentDate;
	}

/**
*
* @param enrolmentDate
*/
	public void setEnrolmentDate(String enrolmentDate) {
		this.enrolmentDate = enrolmentDate;
	}

	@Override
	public String toString() {
		return this.studentName;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
/**
*Displays the StudentList with all details.
*/
	@Override
	public void display() {
		
		System.out.printf("%s\n" + "%-30s %s\n" + "%-30s %s\n" + "%-30s %s\n" + "%-30s %s\n" + "%-30s %d\n" + "%-30s %s\n" + "%-30s %s\n",

		getStudentName() + " Details: " + "\n", "     ID:", getStudentID(), "     Name:", getStudentName(), "     Age:", getAge(),"     Address:", getStudentAddress(), "     Number of Subjects:", getNumOfSubjects(), "     Grades for each Subject:\n\n", getGradesForEachSubject(), "     Average Grades:", getAverage(), "     Date of Enrolment:", getEnrolmentDate());

		System.out.println("======================================================================");
	}

}
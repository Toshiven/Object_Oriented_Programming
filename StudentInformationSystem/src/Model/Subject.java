/**
*Abler, Andrew Kevin M.
*
*Subject handles the grades for each subject of a student. 
*/
package Model;

import java.io.Serializable;



public class Subject implements Serializable { //objects of type subject can be saved
	private final String studentName;
	private int grade;
	private int average;

/**
* Subject(String name, int grade)
* Constructor for creating objects of type Subject given a String name and int grade
* @param name name of the subject
* @param grade grade of the subject
*/
	public Subject(String name, int grade) {
		this.studentName = name;
		this.grade = grade;
	}

/**
* getName()
* Method returns the name of the current subject
* @return name
*/
	public String getName() {
		return this.studentName;
	}

/**
* setGrade(int grade)
* Given an int grade, the method sets the grade for the current student
* @param grade of the current subject
*/
	public void setGrade(int grade) {
		this.grade = grade;
	}

/**
* getGrade()
* Method returns the an int, value of the current grade
* @return name
*/
	public int getGrade() {
		return this.grade;
	}

/**
* toString()
* @return String representation of the subject
*/
	@Override
	public String toString() {
		return String.format("\t          %-30s%d\n", getName() + ":", getGrade());
	}

}
/**
 * 
 */
package com.tutorials.sid.spring.bean.reftype;

/**
 * @author Lenovo
 *
 */
public class Student {
	private int rollNo;
	private Scores scores;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public Scores getScores() {
		return scores;
	}

	public void setScores(Scores scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", scores=" + scores + "]";
	}

}

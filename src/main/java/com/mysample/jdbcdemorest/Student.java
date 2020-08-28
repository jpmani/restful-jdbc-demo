package com.mysample.jdbcdemorest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	
	private String name;
	private String dob;
	private int id;
	private String std;
	private String subject;
	private int mark;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", dob=" + dob + ", id=" + id + ", std=" + std + ", subject=" + subject
				+ ", mark=" + mark + "]";
	}
}
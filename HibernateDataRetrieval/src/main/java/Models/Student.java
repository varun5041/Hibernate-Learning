package Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="StudentsTable")
public class Student 
{
	@Id
	@Column(name = "SID")
	private Integer sid;
	@Column(name="SNAME")
	private String sName;
	@Column(name="SCITY")
	private String sCity;
	
	public Student() {
		System.out.println("ZERO PARAMETER CONSTRUCTOR IN HIBERNATE");
	}
	
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsCity() {
		return sCity;
	}
	public void setsCity(String sCity) {
		this.sCity = sCity;
	}
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sName=" + sName + ", sCity=" + sCity + "]";
	}
	
}

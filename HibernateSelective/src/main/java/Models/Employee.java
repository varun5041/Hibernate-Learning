package Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="EmployeeTable")
public class Employee {
	
	@Id
	@Column(name="EID")
	private Integer eid;
	@Column(name="ENAME")
	private String ename;
	@Column(name="ECITY")
	private String ecity;
	@Transient
	@Column(name="EAGE")
	private Integer eage;
	
	
	
	public Employee() {
		System.out.println("ZERO PARAM CONSTRUCTIOR");
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEcity() {
		return ecity;
	}
	public void setEcity(String ecity) {
		this.ecity = ecity;
	}
	public Integer getEage() {
		return eage;
	}
	public void setEage(Integer eage) {
		this.eage = eage;
	}
	
	
}

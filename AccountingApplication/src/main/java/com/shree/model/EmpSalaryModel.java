package com.shree.model;

public class EmpSalaryModel {
public String hra;
public String pf;
public String netsalary;
public EmpSalaryModel() {
	super();
}
public EmpSalaryModel(String hra, String pf, String netsalary) {
	super();
	this.hra = hra;
	this.pf = pf;
	this.netsalary = netsalary;
}
public String getHra() {
	return hra;
}
public void setHra(String hra) {
	this.hra = hra;
}
public String getPf() {
	return pf;
}
public void setPf(String pf) {
	this.pf = pf;
}
public String getNetsalary() {
	return netsalary;
}
public void setNetsalary(String netsalary) {
	this.netsalary = netsalary;
}

}

package com.shree.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Id;


/**
 * This represents an employee.
 */
@Document
public class Employee   {

  public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

public Employee(String employeeId, String name, String deptName, String address, Date joiningDate,
			Double baseSalary, List<Salary> salaryDetails, String href) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.deptName = deptName;
		this.address = address;
		this.joiningDate = joiningDate;
		this.baseSalary = baseSalary;
		this.salaryDetails = salaryDetails;
		this.href = href;
	}


  private String employeeId = null;

  @Id
  private String name = null;


  private String deptName = null;


  private String address = null;


  private Date joiningDate = null;


  private Double baseSalary = null;


  private List<Salary> salaryDetails = null;


  private String href = null;

  public Employee employeeId(String employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  /**
   * Unique identifier of this employee 
   * @return employeeId
  **/
  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public Employee name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the employee
   * @return name
  **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Employee deptName(String deptName) {
    this.deptName = deptName;
    return this;
  }

  /**
   * Name of the dept
   * @return deptName
  **/
  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  public Employee address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Employee Address
   * @return address
  **/
   public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Employee joiningDate(Date joiningDate) {
    this.joiningDate = joiningDate;
    return this;
  }

  /**
   * Joining date
   * @return joiningDate
  **/
  public Date getJoiningDate() {
    return joiningDate;
  }

  public void setJoiningDate(Date joiningDate) {
    this.joiningDate = joiningDate;
  }

  public Employee baseSalary(Double baseSalary) {
    this.baseSalary = baseSalary;
    return this;
  }

  /**
   * Base salary
   * @return baseSalary
  **/
  public Double getBaseSalary() {
    return baseSalary;
  }

  public void setBaseSalary(Double baseSalary) {
    this.baseSalary = baseSalary;
  }

  public Employee salaryDetails(List<Salary> salaryDetails) {
    this.salaryDetails = salaryDetails;
    return this;
  }

  public Employee addSalaryDetailsItem(Salary salaryDetailsItem) {
    if (this.salaryDetails == null) {
      this.salaryDetails = new ArrayList<Salary>();
    }
    this.salaryDetails.add(salaryDetailsItem);
    return this;
  }

  /**
   * Get salaryDetails
   * @return salaryDetails
  **/
  public List<Salary> getSalaryDetails() {
    return salaryDetails;
  }

  public void setSalaryDetails(List<Salary> salaryDetails) {
    this.salaryDetails = salaryDetails;
  }

  public Employee href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hypertext reference to this resource 
   * @return href
  **/
   public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(this.employeeId, employee.employeeId) &&
        Objects.equals(this.name, employee.name) &&
        Objects.equals(this.deptName, employee.deptName) &&
        Objects.equals(this.address, employee.address) &&
        Objects.equals(this.joiningDate, employee.joiningDate) &&
        Objects.equals(this.baseSalary, employee.baseSalary) &&
        Objects.equals(this.salaryDetails, employee.salaryDetails) &&
        Objects.equals(this.href, employee.href);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeeId, name, deptName, address, joiningDate, baseSalary, salaryDetails, href);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Employee {\n");
    
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    deptName: ").append(toIndentedString(deptName)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    joiningDate: ").append(toIndentedString(joiningDate)).append("\n");
    sb.append("    baseSalary: ").append(toIndentedString(baseSalary)).append("\n");
    sb.append("    salaryDetails: ").append(toIndentedString(salaryDetails)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


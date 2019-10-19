package com.shree.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This represents request for calculate salary.
 */

public class CalculateSalaryRequest   {
  @JsonProperty("employeeId")
  private String employeeId = null;

  @JsonProperty("yearmonth")
  private String yearmonth = null;

  public CalculateSalaryRequest employeeId(String employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  /**
   * Employee id 
   * @return employeeId
  **/
  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public CalculateSalaryRequest yearmonth(String yearmonth) {
    this.yearmonth = yearmonth;
    return this;
  }

  /**
   * yearmonth for which salary is to be calculated 
   * @return yearmonth
  **/
  public String getYearmonth() {
    return yearmonth;
  }

  public void setYearmonth(String yearmonth) {
    this.yearmonth = yearmonth;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalculateSalaryRequest calculateSalaryRequest = (CalculateSalaryRequest) o;
    return Objects.equals(this.employeeId, calculateSalaryRequest.employeeId) &&
        Objects.equals(this.yearmonth, calculateSalaryRequest.yearmonth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeeId, yearmonth);
  }


}


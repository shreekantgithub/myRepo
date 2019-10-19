package com.shree.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This represents an employee leave details resource.
 */
@Document
public class EmployeeLeave   {
  @JsonProperty("employeeId")
  @Id
  private String employeeId = null;

  @JsonProperty("leaveDetails")
  @Valid
  private List<Leave> leaveDetails = null;

  public EmployeeLeave employeeId(String employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  /**
   * Unique identifier of employee 
   * @return employeeId
  **/
  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public EmployeeLeave leaveDetails(List<Leave> leaveDetails) {
    this.leaveDetails = leaveDetails;
    return this;
  }

  public EmployeeLeave addLeaveDetailsItem(Leave leaveDetailsItem) {
    if (this.leaveDetails == null) {
      this.leaveDetails = new ArrayList<Leave>();
    }
    this.leaveDetails.add(leaveDetailsItem);
    return this;
  }

  /**
   * Get leaveDetails
   * @return leaveDetails
  **/
  public List<Leave> getLeaveDetails() {
    return leaveDetails;
  }

  public void setLeaveDetails(List<Leave> leaveDetails) {
    this.leaveDetails = leaveDetails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmployeeLeave employeeLeave = (EmployeeLeave) o;
    return Objects.equals(this.employeeId, employeeLeave.employeeId) &&
        Objects.equals(this.leaveDetails, employeeLeave.leaveDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeeId, leaveDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmployeeLeave {\n");
    
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    leaveDetails: ").append(toIndentedString(leaveDetails)).append("\n");
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


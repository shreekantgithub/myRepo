package com.shree.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This represents salary for specific year month.
 */
public class Salary   {
  @JsonProperty("yearmonth")
  private String yearmonth = null;

  @JsonProperty("amount")
  private Double amount = null;

  public Salary yearmonth(String yearmonth) {
    this.yearmonth = yearmonth;
    return this;
  }

  /**
   * Unique identifier of the year month e.g 201907 for July 2019 
   * @return yearmonth
  **/
  public String getYearmonth() {
    return yearmonth;
  }

  public void setYearmonth(String yearmonth) {
    this.yearmonth = yearmonth;
  }

  public Salary amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Salary amount for this month year 
   * @return amount
  **/
  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Salary salary = (Salary) o;
    return Objects.equals(this.yearmonth, salary.yearmonth) &&
        Objects.equals(this.amount, salary.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(yearmonth, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Salary {\n");
    
    sb.append("    yearmonth: ").append(toIndentedString(yearmonth)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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


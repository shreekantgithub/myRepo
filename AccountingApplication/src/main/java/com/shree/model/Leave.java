package com.shree.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This represents leave for specific year month.
 */
public class Leave   {
  @JsonProperty("yearmonth")
  private String yearmonth = null;

  @JsonProperty("count")
  private Integer count = null;

  public Leave yearmonth(String yearmonth) {
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

  public Leave count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * Leave count for this year month 
   * @return count
  **/
 
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Leave leave = (Leave) o;
    return Objects.equals(this.yearmonth, leave.yearmonth) &&
        Objects.equals(this.count, leave.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(yearmonth, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Leave {\n");
    
    sb.append("    yearmonth: ").append(toIndentedString(yearmonth)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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


package com.secret.santa.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * TeammateObject
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-18T15:08:32.031954Z[Europe/Dublin]")
public class TeammateObject   {
  @JsonProperty("status")
  private Integer status;

  @JsonProperty("response")
  private String response;

  public TeammateObject status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * Status.
   * @return status
  */
  @ApiModelProperty(value = "Status.")


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public TeammateObject response(String response) {
    this.response = response;
    return this;
  }

  /**
   * Teammate's name.
   * @return response
  */
  @ApiModelProperty(value = "Teammate's name.")


  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TeammateObject teammateObject = (TeammateObject) o;
    return Objects.equals(this.status, teammateObject.status) &&
        Objects.equals(this.response, teammateObject.response);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, response);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TeammateObject {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


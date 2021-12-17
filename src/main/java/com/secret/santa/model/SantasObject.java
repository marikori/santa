package com.secret.santa.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;

/**
 * SantasObject
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-17T17:58:40.017983Z[Europe/Dublin]")
public class SantasObject   {
  @JsonProperty("status")
  private Integer status;

  @JsonProperty("response")
  private SantasObjectAllOfResponse response;

  public SantasObject status(Integer status) {
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

  public SantasObject response(SantasObjectAllOfResponse response) {
    this.response = response;
    return this;
  }

  /**
   * Get response
   * @return response
  */
  @ApiModelProperty(value = "")

  @Valid

  public SantasObjectAllOfResponse getResponse() {
    return response;
  }

  public void setResponse(SantasObjectAllOfResponse response) {
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
    SantasObject santasObject = (SantasObject) o;
    return Objects.equals(this.status, santasObject.status) &&
        Objects.equals(this.response, santasObject.response);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, response);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SantasObject {\n");
    
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


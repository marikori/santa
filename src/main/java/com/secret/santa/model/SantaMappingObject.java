package com.secret.santa.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * SantaMappingObject
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-17T19:41:02.633466Z[Europe/Dublin]")
public class SantaMappingObject   {
  @JsonProperty("santa")
  private String santa;

  @JsonProperty("receiver")
  private String receiver;

  public SantaMappingObject santa(String santa) {
    this.santa = santa;
    return this;
  }

  /**
   * Santa's name.
   * @return santa
  */
  @ApiModelProperty(value = "Santa's name.")


  public String getSanta() {
    return santa;
  }

  public void setSanta(String santa) {
    this.santa = santa;
  }

  public SantaMappingObject receiver(String receiver) {
    this.receiver = receiver;
    return this;
  }

  /**
   * Name of person who gets the gift from Santa.
   * @return receiver
  */
  @ApiModelProperty(value = "Name of person who gets the gift from Santa.")


  public String getReceiver() {
    return receiver;
  }

  public void setReceiver(String receiver) {
    this.receiver = receiver;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SantaMappingObject santaMappingObject = (SantaMappingObject) o;
    return Objects.equals(this.santa, santaMappingObject.santa) &&
        Objects.equals(this.receiver, santaMappingObject.receiver);
  }

  @Override
  public int hashCode() {
    return Objects.hash(santa, receiver);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SantaMappingObject {\n");
    
    sb.append("    santa: ").append(toIndentedString(santa)).append("\n");
    sb.append("    receiver: ").append(toIndentedString(receiver)).append("\n");
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


package com.secret.santa.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * TeammateObjectAllOfResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-17T22:37:59.367673Z[Europe/Dublin]")
public class TeammateObjectAllOfResponse   {
  @JsonProperty("name")
  private String name;

  public TeammateObjectAllOfResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Teammate's name.
   * @return name
  */
  @ApiModelProperty(value = "Teammate's name.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
        TeammateObjectAllOfResponse teammateObjectAllOfResponse = (TeammateObjectAllOfResponse) o;
        return Objects.equals(this.name, teammateObjectAllOfResponse.name);
    } else if (o != null && o.getClass() == SantaMappingObject.class) {
        SantaMappingObject santaMappingObject = (SantaMappingObject) o;
        return Objects.equals(this.name, santaMappingObject.getReceiver());
    }
    
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TeammateObjectAllOfResponse {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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


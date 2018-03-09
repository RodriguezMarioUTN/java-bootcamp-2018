package com.shoppingcart.shoppingcartmario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClientDTO {

    private Integer clientId;
    private String firstName;
    private String lastName;
    private String description;
    private List<Integer> payments;

}

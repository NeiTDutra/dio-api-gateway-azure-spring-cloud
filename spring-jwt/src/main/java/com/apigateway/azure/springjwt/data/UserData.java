package com.apigateway.azure.springjwt.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class UserData implements Serializable {

    private String userName;
    private String userPassword;
}

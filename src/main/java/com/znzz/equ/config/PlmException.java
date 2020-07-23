package com.znzz.equ.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlmException extends RuntimeException {

    private Integer code ;
    private String message;
}

package com.springboot_project2.Exceptions;

import lombok.Data;

@Data
public class RessourceNotFoundException extends RuntimeException{
        String resorceName;
        String fieldName;
        long fieldvalue;
        public RessourceNotFoundException(String resorceName,String fieldName,long fieldvalue){
                super(String.format("%s not found whit %s :%l",resorceName,fieldName,fieldvalue));
                this.fieldName=fieldName;
                this.resorceName=resorceName;
                this.fieldvalue=fieldvalue;
        }

}

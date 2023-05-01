/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wanderley.apibook.resources.exceptions;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Wanderley
 */
public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();
    
    
    public ValidationError() {
        super();
    }

    public ValidationError(Long timesTamp, Integer status, String error) {
        super(timesTamp, status, error);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addErrors(String fieldName, String message)  {
        this.errors.add(new FieldMessage(fieldName, message));
    }
        
}
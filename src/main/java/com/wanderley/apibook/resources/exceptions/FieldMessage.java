/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wanderley.apibook.resources.exceptions;

import java.io.Serializable;

/**
 *
 * @author Wanderley
 */
public class FieldMessage implements Serializable{
    
    private String fildName;
    private String message;

    public FieldMessage() {
        super();
    }

    public FieldMessage(String fildName, String message) {
        this.fildName = fildName;
        this.message = message;
    }

    public String getFildName() {
        return fildName;
    }

    public void setFildName(String fildName) {
        this.fildName = fildName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
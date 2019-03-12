package com.SDM.Models;

import java.io.Serializable;

public class User implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}

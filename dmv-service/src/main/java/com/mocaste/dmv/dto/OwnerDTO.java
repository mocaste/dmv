package com.mocaste.dmv.dto;

public class OwnerDTO {

    private  Long id;

    private final String name;

    private final String age;

    private final String address;

    public OwnerDTO( String name, String age, String address) {

        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}

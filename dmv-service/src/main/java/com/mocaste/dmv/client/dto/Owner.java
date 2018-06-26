package com.mocaste.dmv.client.dto;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Owner {

    private Long id;

    private String name;

    private Integer age;

    private String address;

    public Owner(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

}

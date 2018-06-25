package com.mocaste.dmv.dto;


import com.mocaste.dmv.client.dto.Owner;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class OwnerDTO {

    private Long id;

    private String name;

    private Integer age;

    private String address;

    public OwnerDTO(Owner owner) {
        this.id = owner.getId();
        this.name = owner.getName();
        this.age = owner.getAge();
        this.address = owner.getAddress();
    }
}

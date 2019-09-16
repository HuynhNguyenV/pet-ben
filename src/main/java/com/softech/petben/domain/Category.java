package com.softech.petben.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "category")
public class Category extends AbstractDomain{

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private Set<Product> products = new HashSet<>();

}

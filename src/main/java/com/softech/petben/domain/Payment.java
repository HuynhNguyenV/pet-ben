package com.softech.petben.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "payment")
public class Payment extends AbstractDomain {

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "payment")
    private Set<Order> orders = new HashSet<>();

}

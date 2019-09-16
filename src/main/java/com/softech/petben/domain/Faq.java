package com.softech.petben.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "faq")
public class Faq extends AbstractDomain{

    private String title;
    private String description;

}

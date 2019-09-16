package com.softech.petben.domain;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class AbstractDomain implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    private Date dateCreated;
    private Date lastUpdated;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    @PreUpdate
    @PrePersist
    public void updateTimeStamps(){
        lastUpdated = new Date();
        if (dateCreated == null) {
            dateCreated = new Date();
        }
    }

}

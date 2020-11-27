package com.pjanuszek.page.authorpage.entity;

import javax.persistence.*;
import java.util.Date;

public abstract class AbstractDomainClass implements DomainObject{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Version
    private Integer version;
    private Date dateCreated;
    private Date lastUpdated;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }
    public Date getDateCreated() {
        return dateCreated;
    }
    public Date getLastUpdated() {
        return lastUpdated;
    }

    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        lastUpdated = new Date();
        if (dateCreated==null) {
            dateCreated = new Date();
        }
    }

}

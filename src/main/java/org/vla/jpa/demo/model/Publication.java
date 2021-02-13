package org.vla.jpa.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass
public abstract class Publication implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;
    
    @Version
    private Long version;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date publishingDate;
    
    @Column
    private String title;
    
    public void setId(final Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
    
    public Long getVersion() {
        return version;
    }
    
    public void setVersion(final Long version) {
        this.version = version;
    }
    
    public Date getPublishingDate() {
        return publishingDate;
    }
    
    public void setPublishingDate(final Date publishingDate) {
        this.publishingDate = publishingDate;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(final String title) {
        this.title = title;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Publication that = (Publication) o;
        return Objects.equals(publishingDate, that.publishingDate)
               && Objects.equals(title, that.title);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, version, publishingDate, title);
    }
    
}

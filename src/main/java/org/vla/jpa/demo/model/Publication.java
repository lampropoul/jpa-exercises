package org.vla.jpa.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Publication implements Serializable {
    
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
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "publication_authors",
               joinColumns = @JoinColumn(name = "fk_publication_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "fk_author_id", referencedColumnName = "id"))
    private Set<Author> authors = new HashSet<>();
    
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
    
    public Set<Author> getAuthors() {
        return authors;
    }
    
    public void setAuthors(final Set<Author> authors) {
        this.authors = authors;
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

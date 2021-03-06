package org.vla.jpa.demo.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Author implements Serializable {
    
    @Id
    private Long authorId;
    
    @Version
    private int version;
    
    @Column
    private String firstName;
    
    @Column
    private String lastName;
    
    public void setAuthorId(final Long authorId) {
        this.authorId = authorId;
    }
    
    public Long getAuthorId() {
        return authorId;
    }
    
    public int getVersion() {
        return version;
    }
    
    public void setVersion(final int version) {
        this.version = version;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Author author = (Author) o;
        return Objects.equals(firstName, author.firstName)
               && Objects.equals(lastName, author.lastName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
    
}

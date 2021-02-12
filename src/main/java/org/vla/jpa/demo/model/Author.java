package org.vla.jpa.demo.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Author implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Version
    private int version;
    
    @Column
    private String firstName;
    
    @Column
    private String lastName;
    
    public void setId(final Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
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

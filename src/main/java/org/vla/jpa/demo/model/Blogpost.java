package org.vla.jpa.demo.model;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "blogpost_id"))
public class Blogpost extends Publication {
    
    @Column
    private String url;
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(final String url) {
        this.url = url;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Blogpost blogpost = (Blogpost) o;
        return Objects.equals(url, blogpost.url);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), url);
    }
    
}

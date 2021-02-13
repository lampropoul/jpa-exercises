package org.vla.jpa.demo.model;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "book_id"))
@DiscriminatorValue(value = "BOOK")
public class Book extends Publication {
    
    @Column
    private Integer pages;
    
    public Integer getPages() {
        return pages;
    }
    
    public void setPages(final Integer pages) {
        this.pages = pages;
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
        Book book = (Book) o;
        return Objects.equals(pages, book.pages);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pages);
    }
    
}

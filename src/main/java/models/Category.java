package models;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;
@Getter

public class Category {
    private Long id;
    private String title;
    private String description;

    public Category(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(title, category.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    public String getTitle() {
        return title;
    }

}
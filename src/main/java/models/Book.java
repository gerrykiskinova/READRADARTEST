package models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
public class Book {
    private Long id;
    private String title;
    private String description;
    private String author;
    private int year;
    private Set<Category> categories;

    public Book(Long id, String title, String description, String author, int year, Set<Category> categories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.year = year;
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", categories=" + categories.stream().map(Category::getTitle).collect(Collectors.joining(", ")) +
                '}';
    }
}

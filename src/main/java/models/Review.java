package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Review {
    private Long id;
    private String comment;
    private Integer rating;
    private Book book;

    public Review(long l, String comment, Integer rating, Book book) {
    }
}

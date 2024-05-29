package repo;

import lombok.Getter;
import models.Book;
import models.Category;
import models.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
public class DBMainRepo {
    private static List<Book> bookList = new ArrayList<>();
    private static List<Category> categories = new ArrayList<>();
    private static List<Review> reviews = new ArrayList<>();

    static {
        Category category1 = new Category(1l, "Трилър", "убийства");
        Category category2 = new Category(2l, "Драма", "тъга");
        Category category3 = new Category(3l, "Фантастика", "измислени създания");
        Category category4 = new Category(4l, "Романтика", "Romance");

        bookList.add(new Book(1l, "Институтът", "", "Стивън Кинг", 2015, Set.of(category1)));
        bookList.add(new Book(2l, "Мъглата", "", "Стивън Кинг", 2000, Set.of(category1)));
        bookList.add(new Book(3l, "Санаториумът", "", "Сара Пиърс", 2010, Set.of(category1)));
        bookList.add(new Book(4l, "Ромео и Жулиета", "", "Шекспир", 1600, Set.of(category2)));
        bookList.add(new Book(5l, "Цялата небесна синева", "Мелиса да Коста", "", 2023, Set.of(category2)));
        bookList.add(new Book(6l, "Гордост и предразсъдъци", "Джейн Остин", "", 1813, Set.of(category2)));
        bookList.add(new Book(7l, "Дюн", "", "Франк Хърбърт", 2015, Set.of(category3)));
        bookList.add(new Book(8l, "Пътещестеникът във времето и неговата жена", "", "", 1990, Set.of(category3)));
        bookList.add(new Book(9l, "Ема", "", "Джейн Остин", 1815, Set.of(category3)));
        bookList.add(new Book(10l, "Ана Каренина", "", "Лев Тоулстой", 1873, Set.of(category3)));
        bookList.add(new Book(11l, "Ана Каренина", "", "Лев Тоулстой", 1873, Set.of(category4)));


        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        categories.add(category4);
    }

    public static List<Category> getCategories() {
        return categories;
    }

    public static List<Book> getBookList() {
        return bookList;
    }
    public static List<Review> getReviews(){return reviews;}
}

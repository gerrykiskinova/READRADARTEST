package services;

import models.Book;
import models.Category;
import models.Review;
import repo.DBMainRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookService {
    private static List<Book> bookList;

    public BookService(){
        bookList = DBMainRepo.getBookList();
    }

    public List<Book> load(String categoryName, String bookName, String bookAuthor, int bookYear) {
        Stream<Book> streamResult = bookList.stream();

        if(categoryName != null && !categoryName.trim().isEmpty()){
            streamResult = streamResult
                    .filter(book -> book.getCategories().stream()
                            .anyMatch(category -> category.getTitle().equals(categoryName)));
        }

        if(bookName != null && !bookName.trim().isEmpty()){
            streamResult = streamResult
                    .filter(book -> book.getTitle().equals(bookName));
        }

        if(bookAuthor != null && !bookAuthor.trim().isEmpty()){
            streamResult = streamResult
                    .filter(book -> book.getAuthor().equals(bookAuthor));
        }
        if(bookYear != 0 ){
            streamResult = streamResult
                    .filter(book -> bookYear == 0 || book.getYear() == bookYear);

        }
        return streamResult.toList();
    }



    private static String validate(Integer bookYear, String bookName)
    {
        if (null == bookYear)
        {
            return "Въведете година";
        }
        if (bookYear < 1 || bookYear >2024)
        {
            return "Годината трябва да е между 1 и 2024";
        }

        return null;
    }

}

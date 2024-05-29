package bookView;

import io.cucumber.java.en.Then;
import models.Book;
import services.BookService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CheckBookList {
    private final BookHelperModel helperModel;

    public CheckBookList(BookHelperModel helperModel) {
        this.helperModel = helperModel;
    }

    @Then("Визуализира списък с наличните {int} книги")
    public void checkBookList(int expectedBookCount) {
        BookService bookService = new BookService();
        helperModel.setBookList(bookService.load(helperModel.getCategory(), helperModel.getBookName(), helperModel.getBookAuthor(), helperModel.getBookYear()));
        assertNotNull(helperModel.getBookList());
        assertEquals(expectedBookCount, helperModel.getBookList().size());
    }



}

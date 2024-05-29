package bookView;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Book;
import models.Category;
import services.CategoryService;
import services.BookService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookViewSteps {

    private final BookHelperModel helperModel;

    public BookViewSteps(BookHelperModel helperModel) {
        this.helperModel = helperModel;
    }

    @When("Отваряне на приложението")
    public void openApp() {
        //missing real app
    }

    @When("натиска бутона за търсене")
    public void clickSearchButton() {
        BookService bookService = new BookService();
        helperModel.setBookList(bookService.load(helperModel.getCategory(),
                helperModel.getBookName(), helperModel.getBookAuthor(), helperModel.getBookYear()));
    }


    @Then("Визуализира се списък с категории")
    public void checkCategories() {
        CategoryService categoryService = new CategoryService();
        List<Category> categories = categoryService.load();
        assertTrue(categories.stream().anyMatch(c -> c.getTitle().equals("Трилър")));
        assertTrue(categories.stream().anyMatch(c -> c.getTitle().equals("Драма")));
        assertTrue(categories.stream().anyMatch(c -> c.getTitle().equals("Фантастика")));
        assertTrue(categories.stream().anyMatch(c -> c.getTitle().equals("Романтика")));
        assertEquals(4, categories.size());
    }

    @When("потребителя избере категория: {string}")
    public void chooseCategory(String category) {
        this.helperModel.setCategory(category);
    }


    @When("потребителя въвежда име на книгата {string} в полето за търсене")
    public void addBookInSearchField(String bookName) {
        this.helperModel.setBookName(bookName);
    }

    @When("потребителя въвежда име на автор {string} в полето за търсене")
    public void addBookAuthorInSearchField(String bookAuthor) {
        this.helperModel.setBookAuthor(bookAuthor);
    }

    @When("потребителя въвежда година на книга {int} в полето за търсене")
    public void addBookYearInSearchField(int year) {
        this.helperModel.setBookYear(year);
    }

}

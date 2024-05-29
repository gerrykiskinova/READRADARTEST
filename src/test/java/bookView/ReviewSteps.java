package bookView;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import services.ReviewService;
import static org.junit.Assert.assertEquals;

public class ReviewSteps {
    private String wineName;
    private String message;
    private Stars stars;
    private String comment;

    public ReviewSteps(Stars stars) {
        this.stars = stars;
    }

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String stringType(String cell) {
        return cell;
    }



    @Given("Потребителят отваря детайли на книга {string}")
    public void openWineDetails(String wineName) {
        this.wineName = wineName;
    }

    @When("Въвежда коментар {string}")
    public void addComment(String comment) {
        this.comment = comment;
    }

    @When("Натиска бутона оцени")
    public void submitRating() {
        final ReviewService rateService = new ReviewService();
        message = rateService.rateBook(wineName,  stars.getRating(), comment);
    }

    @Then("Вижда съобщение {string}")
    public void checkMessage(String expectedMessage) {
        assertEquals(expectedMessage, message);
    }

}

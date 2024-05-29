package bookView;

import io.cucumber.java.en.When;

public class SelectStarSteps {
    private final Stars stars;
    public SelectStarSteps(Stars stars){
        this.stars=stars;
    }


    @When("избира {int} звезди")
    public void selectStar(Integer rating) {
        stars.setRating(rating);
    }
}

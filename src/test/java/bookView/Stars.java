package bookView;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stars {
    private Integer rating;

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}

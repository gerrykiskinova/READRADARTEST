package services;

import models.Book;
import models.Review;
import repo.DBMainRepo;

public class ReviewService {
    public String rateBook(String bookName, Integer rating, String comment)
    {
        String validationMessage = validate(rating, comment);
        if (validationMessage != null) return validationMessage;
        Book book = DBMainRepo.getBookList().stream()
                .filter(b -> b.getTitle().equals(bookName))
                .findFirst()
                .orElse(null);
        if (book != null)
        {
            Review newReview = new Review(1l, comment, rating, book);
            DBMainRepo.getReviews().add(newReview);
            return generateMessage(bookName, rating);
        }
        return null;
    }


    private String generateMessage(String bookName, Integer rating)
    {
        StringBuilder message = new StringBuilder("Успешно оценихте с ");
        message.append(rating);
        if(rating>1){
            message.append(" звезди ");
        }else{
            message.append(" звезда ");
        }
        message.append("книгата ");
        message.append(bookName);
        return message.toString();
    }


    private static String validate(Integer rating, String comment)
    {
        if (null == rating)
        {
            return "Въведете оценка";
        }
        if (rating < 1 || rating >6)
        {
            return "Оценката трябва да е между 1 и 6";
        }
        if (comment != null && comment.length() > 50)
        {
            return "Коментарът трябва да е с дължина под 51";
        }
        if (comment != null && !comment.matches("[\\w\\d\\.,!\\p{L}\\s-]+"))
        {
            return "За коментари може да ползвате букви, цифри и '.,!-'";
        }
        return null;
    }
}

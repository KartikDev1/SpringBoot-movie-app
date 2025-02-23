package dev.kartik.MovieApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody,String imdbId){
        Review review = reviewRepository.insert(new Review(reviewBody));

        System.out.println("Review inserted: " + review.getId().toHexString()); // Debugging

        mongoTemplate.updateFirst(
                Query.query(Criteria.where("imdbId").is(imdbId)),
                new Update().push("reviewIds", review),
                Movie.class
        );

        System.out.println("Review linked to movie with IMDb ID: " + imdbId); // Debugging
        return review;
    }
}

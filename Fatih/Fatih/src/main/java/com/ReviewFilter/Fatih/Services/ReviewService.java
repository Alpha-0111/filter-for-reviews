package com.ReviewFilter.Fatih.Services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ReviewFilter.Fatih.IServices.IReviewService;
import com.ReviewFilter.Fatih.Models.Review;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ReviewService implements IReviewService {

    private static List<Review> _reviewList = new ArrayList<Review>();

    public ReviewService() {
        InitializeData();
    }

    private void InitializeData() {
        File file = new File(
                this.getClass().getClassLoader().getResource("json/reviews.json").getFile());
        System.out.println(file.exists());
        ObjectMapper mapper = new ObjectMapper();
        try {
            _reviewList = mapper.readValue(file, new TypeReference<List<Review>>() {
            });
        } catch (Exception exception) {

        }
    }

    public List<Review> GettAllReviews() {
        return _reviewList;
    }
}

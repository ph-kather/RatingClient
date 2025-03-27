package edu.ratingclient.dto;

public class RatingRequestDTO {
    private  int rating;

    public RatingRequestDTO(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

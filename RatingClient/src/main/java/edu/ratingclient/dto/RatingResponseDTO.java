package edu.ratingclient.dto;


import java.util.Date;
import java.util.UUID;

public class RatingResponseDTO {
    private UUID id;
    private int rating;
    private Date date;

    public RatingResponseDTO(UUID id, int rating, Date date) {
        this.id = id;
        this.rating = rating;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

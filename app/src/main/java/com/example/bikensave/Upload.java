package com.example.bikensave;
//This is my class which acts as a helper class for uploading details to the database.
public class Upload {
    private String mName, mImageUrl, mDate, mRating, mReview;

    //Empty Constructor for Firebase
    public Upload() {
    }


    public Upload(String name, String imageUrl, String date, String rating, String review) {
        this.mName= name;
        this.mImageUrl= imageUrl;
        this.mDate= date;
        this.mRating= rating;
        this.mReview= review;


    }
    public String getName() {
        return mName;
    }
    public void setName(String name) {
        mName = name;
    }

    public String getDate() {
        return mDate;
    }
    public void setDate(String date) {
        mDate = date;
    }

    public String getRating() {
        return mRating;
    }
    public void setRating(String rating) {
        mRating = rating;
    }

    public String getReview() {
        return mReview;
    }
    public void setReview(String review) {
        mReview = review;
    }


    public String getImageUrl() {
        return mImageUrl;
    }
    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}
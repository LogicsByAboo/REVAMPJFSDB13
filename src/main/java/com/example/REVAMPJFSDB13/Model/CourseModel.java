package com.example.REVAMPJFSDB13.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import org.hibernate.id.IdentityGenerator;


@Entity
public class CourseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )

    private int courseId;
    private String courseName;
    private String courseDesc;
    private String courseDuration;
    private double courseFee;
    private int courseRating;
    private double offerPrice;

    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }
    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public String getCourseDuration() {
        return courseDuration;
    }
    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public double getCourseFee() {
        return courseFee;
    }
    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

    public int getCourseRating() {
        return courseRating;
    }

    public void setCourseRating(int courseRating) {
        this.courseRating = courseRating;
    }

    public double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }
}

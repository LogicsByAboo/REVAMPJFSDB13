package com.example.REVAMPJFSDB13.Repository;

import com.example.REVAMPJFSDB13.Model.CourseModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel , Integer> {

    @Query("Select c from CourseModel c where c.courseName = :name")
    List<CourseModel> getCourseDetailsByName(String name);

    @Query("Select c from CourseModel c where c.courseName like Concat('%',:name,'%')")
    List<CourseModel> searchCourseByName(String name);

    @Query("Select c from CourseModel c where c.courseFee > :amount")
    List<CourseModel> courseFeeGreaterThanAmount(double amount);

    @Transactional
    @Modifying
    @Query("Update CourseModel c Set c.offerPrice = c.courseFee - c.courseFee * :offer where c.courseName like Concat('%',:name,'%')")
    void applyOffer(double offer, String name);
}

package com.example.REVAMPJFSDB13.Service;

import com.example.REVAMPJFSDB13.Model.CourseModel;
import com.example.REVAMPJFSDB13.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public CourseModel add(CourseModel courseModel) {
        return courseRepository.save(courseModel);
    }

    public String addAll(List<CourseModel> courseModels) {
         courseRepository.saveAll(courseModels);
         return "completed";
    }

    public List<CourseModel> addAllDetails(List<CourseModel> courseModels) {
        return courseRepository.saveAll(courseModels);
    }

    public String delete(int id){
        courseRepository.deleteById(id);
        return "Deleted Successsfully";
    }

    public String deleteAll(){
        courseRepository.deleteAll();
        return "Deleted All Courses Successsfully";
    }

    public CourseModel getCourse(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    public List<CourseModel> getAll(){
        return courseRepository.findAll();
    }

    public CourseModel update(int id,CourseModel newdata){
        CourseModel OldData = courseRepository.findById(id).orElseGet(null);
        OldData.setCourseDesc(newdata.getCourseDesc());
        OldData.setCourseDuration(newdata.getCourseDuration());
        OldData.setCourseFee(newdata.getCourseFee());
        OldData.setCourseRating(newdata.getCourseRating());
        OldData.setCourseName(newdata.getCourseName());
        return courseRepository.save(OldData);
    }

    public List<CourseModel> getCourseDetailsByName(String name){
        return courseRepository.getCourseDetailsByName(name);
    }

    public List<CourseModel> searchCourseByName(String name) {
        return courseRepository.searchCourseByName(name);
    }

    public List<CourseModel> courseFeeGreaterThanAmount(double amount) {
        return courseRepository.courseFeeGreaterThanAmount(amount);
    }

    public String applyOffer(double offer, String name) {
        courseRepository.applyOffer(offer,name);
        return "OFFER APPLIED";
    }
}

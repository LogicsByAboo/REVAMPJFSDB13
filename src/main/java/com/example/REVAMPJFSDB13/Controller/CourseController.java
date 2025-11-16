package com.example.REVAMPJFSDB13.Controller;

import com.example.REVAMPJFSDB13.Model.CourseModel;
import com.example.REVAMPJFSDB13.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/addCourse")
    public CourseModel addCourseDetails(@RequestBody CourseModel courseModel) {
        return courseService.add(courseModel);
    }

    @PostMapping("/addAllCourse")
    public String addAllCourse(@RequestBody List<CourseModel> courseModels){
        return courseService.addAll(courseModels);
    }

    @PostMapping("/addAllCourseDetails")
    public List<CourseModel> courseModels(@RequestBody List<CourseModel> courseModels){
        return courseService.addAllDetails(courseModels);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable int id){
        return courseService.delete(id);
    }

    @DeleteMapping("/deleteAllCourse")
    public String deleteAllCourses(){
        return courseService.deleteAll();
    }

    @GetMapping("/getCourseDetails/{id}")
    public CourseModel getCourseDetails(@PathVariable int id){
        return courseService.getCourse(id);
    }

    @GetMapping("/getAllCourseDetails")
    public List<CourseModel> getAll(){
        return courseService.getAll();
    }

    @PutMapping("/update/{id}")
    public CourseModel updateCourseDetails(@PathVariable int id,@RequestBody CourseModel newdata){
        return courseService.update(id,newdata);
    }

    @GetMapping("/getCourseByName")
    public List<CourseModel> getCourseDetailsByName(@RequestParam("name") String name){
        return courseService.getCourseDetailsByName(name);
    }

    @GetMapping("/searchCourseByName")
    public List<CourseModel> searchCourseByName(@RequestParam("name") String name){
        return courseService.searchCourseByName(name);
    }

    @GetMapping("/courseFeeGreaterThanAmount")
    public List<CourseModel> courseFeeGreaterThanAmount(@RequestParam("Fee") double amount){
        return courseService.courseFeeGreaterThanAmount(amount);
    }

    @PostMapping("/applyOffer")
    public String applyOffer(@RequestParam("Fee") double offer , @RequestParam("Name") String name){
        return courseService.applyOffer(offer,name);
    }
}

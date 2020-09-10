package service;

import model.Course;
import repository.CourseRep;
import java.util.List;


public class CourseService {
    public static Course getCourse(int id){
        return CourseRep.getCourse(id);
    }

    public static List<Course> getAllCourses(){
        return CourseRep.getAllCourses();
    }

    public static void createCourse(String courseName, String description ){
        CourseRep.createCourse(new Course().setActive(false).setCourseName(courseName).setDescription(description));
    }

    public static void deleteCourse(int id){
        CourseRep.deleteCourse(id);
    }



}

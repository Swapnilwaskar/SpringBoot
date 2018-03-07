package com.example.StudentBootDemo.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.StudentBootDemo.student.StudentModel;

@Service
public class CourseService {

	@Autowired
	CourseRepository repo;
	
	public List<CourseModel> getAllCousesOfStudent(Long student_id) 
	{
		
		List<CourseModel> courses=new ArrayList<>();
		
		repo.findByStudentId(student_id).forEach(courses::add);
		
		return courses;
		
	}
	
	
   public void createCourse(CourseModel course) {
		
	   repo.save(course);
		
	}
	
	

   public CourseModel getCourseById(Long course_id) 
   {
	
	   return repo.findById(course_id).get(); 
   }
	
   
   
public CourseModel updateStudent(Long id,CourseModel newStud) {
		
	CourseModel oldStud=repo.findById(id).get();
		if (oldStud == null) {
			return null;
		}
		

		CourseModel updatedStud=repo.save(newStud);
		return updatedStud;
		
	}



public Integer deleteStudent(Long id) {
	CourseModel stud = repo.findById(id).get();
    if(stud == null) {
        return 0;
    }

     repo.delete(stud);
    return 1;
}




}

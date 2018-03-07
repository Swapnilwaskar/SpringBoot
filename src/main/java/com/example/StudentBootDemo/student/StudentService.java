package com.example.StudentBootDemo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentRepository repo;
	
	public List<StudentModel> getAllStudents() 
	{
		
		return repo.findAll();
	}
	
	
	public StudentModel createNewStudent(StudentModel student)
	{
		return repo.save(student);
	}
	
	
	public StudentModel getStudById(Long id) {
		
		return repo.findById(id).get();
		
	}
	
public StudentModel updateStudent(Long id,StudentModel newStud) {
		
		StudentModel oldStud=repo.findById(id).get();
		if (oldStud == null) {
			return null;
		}
		

		StudentModel updatedStud=repo.save(newStud);
		return updatedStud;
		
	}



public Integer deleteStudent(Long id) {
	StudentModel stud = repo.findById(id).get();
    if(stud == null) {
        return 0;
    }

     repo.delete(stud);
    return 1;
}


}

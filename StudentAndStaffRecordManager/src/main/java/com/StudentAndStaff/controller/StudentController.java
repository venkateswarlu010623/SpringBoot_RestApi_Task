package com.StudentAndStaff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.StudentAndStaff.modal.Student;
import com.StudentAndStaff.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;

    @PostMapping ("/createStudents")
    public List<Student> saveAllStudents(@RequestBody List<Student>  student)
    {
        return studentService.saveStudents(student);
    }
    
    
    @GetMapping ("students-in-{year}")
    public List<Student> getStudentListByYear(@PathVariable String  year)
    {
        return studentService.getStudentsOfYear1(year);
    }
    
    
    @GetMapping("/students/{attendanceStatus}/in/{year}/{branch}")
    public List<Student> getStudentListByYearAndBranchAndPresentToday(@PathVariable String  year,@PathVariable String  branch,@PathVariable String  attendanceStatus)
    {
        return studentService.getStudentsOfYear1WhoPresentTodayInCSEBranch(year,branch,attendanceStatus);
    }
    
    
    @GetMapping ("student/{result}-in-{year}")
    public List<Student> getStudentList3(@PathVariable String  result,@PathVariable String  year)
    {
        return studentService.getStudentsWhoAreNotPassesdInYear1(result,year);
    }
    
}

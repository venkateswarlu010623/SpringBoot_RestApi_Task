package com.StudentAndStaff.service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.StudentAndStaff.modal.Student;

@Service
public class StudentService {
	
	List<Student> student1 = new LinkedList<>();

    public List<Student> saveStudents(List<Student>  student)
    {
    	student1.addAll(student);
        return student1;
    }

    //1) Retrieve Student details in year 1 
    public List<Student> getStudentsOfYear1(String year)
    {
    	return student1.stream().filter(s -> s.getCurrentYear().equalsIgnoreCase(year))
                				.collect(Collectors.toList());
    }

    
	//2) Retrieve Students who is present today in year 1 and branch CSE
    public List<Student> getStudentsOfYear1WhoPresentTodayInCSEBranch(String year, String branch,String attendanceStatus)
    {
    	LocalDate today = LocalDate.now();
    	List<Student> student3 =student1.stream().
    							filter(st->st.getCurrentYear().equals(year) &&
    										st.getStudentBranch().equalsIgnoreCase(branch) && 
    										st.getStudentYearlyAttendance().get(year).stream().
    							anyMatch(m->m.getStudentAttendanceDate().isEqual(today) &&
    									m.getStudentAttendanceStatus().equalsIgnoreCase(attendanceStatus))).
    							collect(Collectors.toList());
    			
        return student3;
    }
    
    //3) Retrieve students who are not passed in year 1
    public List<Student> getStudentsWhoAreNotPassesdInYear1(String result, String year)
    {
    	
    	List<Student> student4 = student1.stream()
    							.filter(fs->!fs.getCurrentYear().equalsIgnoreCase(year) &&
    							fs.getYearWiseStudentSubjectsAndMarksAndResult().get(year)
    							.stream().anyMatch(a->a.getResult().equalsIgnoreCase(result)))
    							.collect(Collectors.toList());
        return student4;
    }

}
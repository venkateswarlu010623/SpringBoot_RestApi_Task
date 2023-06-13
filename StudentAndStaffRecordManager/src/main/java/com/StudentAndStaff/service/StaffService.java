package com.StudentAndStaff.service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.el.stream.Optional;
import org.springframework.stereotype.Service;

import com.StudentAndStaff.modal.Staff;
import com.StudentAndStaff.modal.Student;

@Service
public class StaffService {

	List<Staff> staff1 = new LinkedList<>();
	
	public List<Staff> saveAllStaff(List<Staff> staff) {
		
		staff1.addAll(staff);
	    System.out.println(staff1);

	    return staff1;
	}

//  1) Retrieve staff details who teach year 1
    public List<Staff> getStaffWhoTeachYear1(String year)
    {
    	List<Staff> l = staff1.stream().filter(s->s.getTeachingYearsOrWorkingYears()
    									.contains(year) && s.getIsTeaching())
    									.collect(Collectors.toList());
    	System.out.println(l);
		return l;
    }
    
//    2) Retrieve staff who is present today and who teaches Subject1
    public List<Staff> getStaffWhoPresentTodayAndTeachSubject1(String subject)
    {
    	LocalDate today = LocalDate.now();
    	List<Staff> Staff3 = staff1.stream().filter(s->s.getIsTeaching() != false)
    					.filter(s->s.getTeachingsubjects().stream()
    					.anyMatch(sub->sub.getSubjectName().equalsIgnoreCase(subject)) &&
    					s.getStaffAttendanceAndDetails().stream()
    					.anyMatch(a->a.getStaffAttendanceDate().isEqual(today)))
    					.collect(Collectors.toList());
    			
        return Staff3;
    }
    
    //3) Retrieve staff who teaches more than 2 subjects in year 2 (edited) 

    public List<Staff> getStaffWhoTeachesMoreThanTwoSubjectsInYear2(int number, String year)
    {
    	
    	List<Staff> Staff4 = staff1.stream().filter(s->s.getIsTeaching() == true &&
    												s.getTeachingsubjects().stream()
    												.count()>number && s.getTeachingsubjects().stream()
    												.anyMatch(a->a.getSubjectYear().equalsIgnoreCase(year)))
    												.collect(Collectors.toList());
        return Staff4;
    }

}


//public List<Staff> saveAllStaff(List<Staff> staff) {
//	for (Staff staff2 : staff) {
//		Staff st = new Staff();
//		st.setStaffId(staff2.getStaffId());
//		st.setStaffName(staff2.getStaffName());
//		st.setStaffEmail(staff2.getStaffEmail());
//		st.setIsTeaching(staff2.getIsTeaching());
//		st.setStaffJoinDate(staff2.getStaffJoinDate());
//		st.setStaffAttendanceAndDetails(staff2.getStaffAttendanceAndDetails());
//		st.setTeachingOrWorkingBranches(staff2.getTeachingOrWorkingBranches());
//		st.setTeachingsubjects(staff2.getTeachingsubjects());
//		st.setTeachingYearsOrWorkingYears(staff2.getTeachingYearsOrWorkingYears());
//
//		staff1.add(st);
//	}
//    return staff1;
//}


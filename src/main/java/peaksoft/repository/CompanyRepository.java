package com.example.securityproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("select new peaksoft.dto.response.CompanyResponse(c.id,c.name,c.country,c.address,c.phone_number) from Company c ")
    List<CompanyResponse> getAllCompany();

    @Query("select new peaksoft.dto.response.CompanyResponse(c.id,c.name,c.country,c.address,c.phone_number) from Company c where c.id=:id")
    Optional<CompanyResponse> getCompanyById(Long id);


//    @Query("SELECT new peaksoft.dto.response.CompanyDetailsResponse(c.id, c.name, c.country ,c.address , co.course_name, i.first_name, g.group_name, COUNT (s))" +
//            "FROM Company c " +
//            " JOIN c.courses co " +
//            " JOIN co.instructor i "+
//            " JOIN co.groups g " +
//            " JOIN g.students s " +
//            "where c.id= ?1  GROUP BY c.id, c.name, c.country, c.address, co.course_name, i.first_name, g.group_name" )
//    List<CompanyDetailsResponse> getAllInfoCompany(Long id);




//    @Query("select count (s)from Company c join Instructor i join i.courses co join co.groups g join Student s where c.id=:companyId")
//    int getAllStudentSize(Long companyId);

    @Query("select count (s.id) from Company c join c.courses cour join cour.groups g join g.students s where c.id = ?1")
    int getAllStudentSize(Long companyId);

    @Query("select i.first_name from Company com join com.instructors i where com.id = ?1")
    List<String> getAllInstructorName(Long companyId);

    @Query("select g.group_name as groupName from Company com  join com.courses c  join c.groups g where com.id = ?1")
    List<String> getAllGroupName(Long companyId);

    @Query("select c.course_name as courseName from Company com join com.courses c where com.id = ?1")
    List<String> getAllCourseName(Long companyId);

}
package com.brillio.example.firstRestServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Student1DAO extends JpaRepository<Student1DTO,String> {

    @Query(value = "select s.fname, ci.cityname from sdetails s inner join connectcity c on s.sid=c.sid inner join city ci on c.citycode = ci.citycode",nativeQuery=true)
    public List<String> getStudentCity();
}

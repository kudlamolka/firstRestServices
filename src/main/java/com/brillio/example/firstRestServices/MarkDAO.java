package com.brillio.example.firstRestServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkDAO extends JpaRepository<MarkDTO,String> {

    @Query(value="select s.fname as 'Student Name' ,avg((m1+m2+m3)/3) as average,count(testno) as Tests from mark join sdetails s on s.sid = mark.sid group by mark.sid;",nativeQuery = true)
    public List<List<String>> getMarks();
}

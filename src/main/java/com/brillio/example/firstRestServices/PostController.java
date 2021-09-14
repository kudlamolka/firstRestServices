package com.brillio.example.firstRestServices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sdetail")
@EnableCaching
public class PostController {

    @Autowired
    StudentDAO studentDAO;

    @PostMapping("/insert")
    //Add @RequestBody for the pararmeter of the function which has PostMapping to fetch values from request
    public String insertStudent(@RequestBody StudentDTo sDTO)
    {
        try{
            studentDAO.save(sDTO);
             return "Data is inserted";
        }catch(Exception e)
        {
            return e.getMessage();
        }

    }
    @GetMapping("/find")
    public List<StudentDTo> findStudent()
    {
        return studentDAO.findAll();
    }

    @GetMapping("/find/{sid}")
    @Cacheable(key="#sid",value="StudentDTO")
    public Optional<StudentDTo> findStudent(@PathVariable String sid)
    {
        return studentDAO.findById(sid);
    }
    @PutMapping("/update")
    //Add @RequestBody for the pararmeter of the function which has PostMapping to fetch values from request
    public String updateStudent(@RequestBody StudentDTo sDTO)
    {
        try{
            studentDAO.save(sDTO);
            return "Data is Updated";
        }catch(Exception e)
        {
            return e.toString();
        }

    }
//    @PatchMapping("/patch/{sid}")
//    public String patchStudent(@RequestBody Map<String,String> changes, @PathVariable String sid)
//    {
//        try{
//            Optional<StudentDTo> student = studentDAO.findById(sid);
//            if(student.isPresent())
//            {
//                StudentDTo studentToChange = student.get();
//                for(String key:changes.keySet()) {
//                    studentToChange.setField(key, changes.get(key));
//                }
//                studentDAO.save(studentToChange);
//            }
//            else
//            {
//                return "No Such Student";
//            }
//            return "Data is patched";
//        }
//        catch(Exception e)
//        {
//            return e.getMessage();
//        }
//    }
    @DeleteMapping("/delete/{sid}")
    public String deleteStudent(@PathVariable String sid)
    {
        try
        {
            studentDAO.deleteById(sid);
            return "Data is Deleted";
        }catch(Exception e)
        {
            return e.getMessage();
        }
    }

}

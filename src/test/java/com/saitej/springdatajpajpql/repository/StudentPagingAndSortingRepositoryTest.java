package com.saitej.springdatajpajpql.repository;

import com.saitej.springdatajpajpql.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentPagingAndSortingRepositoryTest {

    @Autowired
    StudentPagingAndSortingRepository pagingAndSortingRepository;

    @Test
    void findAllStudents() {
       // List<Student> students = pagingAndSortingRepository.findAllStudents(PageRequest.of(1, 5));
        List<Student> students = pagingAndSortingRepository.findAllStudents(PageRequest.of(1, 5, Sort.by("firstName").ascending()));
         students.forEach(p-> System.out.println(p.getFirstName()));
        assertNotNull(students);
        assertEquals(5,students.stream().count());
    }
}
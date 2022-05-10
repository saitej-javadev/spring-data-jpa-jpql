package com.saitej.springdatajpajpql;

import com.saitej.springdatajpajpql.entities.Student;
import com.saitej.springdatajpajpql.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@Slf4j
@SpringBootTest
class SpringDataJpaJpqlApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testStudentCreate() {

        studentRepository.save(new Student().builder().firstName("Elon").lastName("Musk").score(80).build());
        studentRepository.save(new Student().builder().firstName("Bill").lastName("Gates").score(70).build());
    }

    @Test
    void testFindAllStudents() {
        List<Student> students = studentRepository.findAllStudents();
        log.info("Logging findAllStudents(): {}",students);
        assertNotNull(students);
        assertEquals(4,studentRepository.count());
    }

    @Test
    void testfindAllStudentsPartialData() {
        List<Object[]> partialData = studentRepository.findAllStudentsPartialData();
        for (Object[] objects:partialData) {
            System.out.println(objects[0]);
            System.out.println(objects[1]);
        }
        assertNotNull(partialData);
        }

    @Test
    void findAllStudentByFirstName() {
        List<Student> student = studentRepository.findAllStudentByFirstName("Elon");
        student.forEach(System.out::println);
    }

    @Test
    void findStudentsForGivenScores() {
        List<Student> students = studentRepository.findStudentsForGivenScores(65, 75);
        students.forEach(System.out::println);
    }

    @Transactional
    @Test
    @Rollback(false) // use this annotation only in test cases
    void deleteStudentsByFirstName() {
        studentRepository.deleteStudentsByFirstName("Bill");
        assertEquals(2,studentRepository.count());
    }

    @Test
    void findAllStudentsNQ() {
        List<Student> allStudentsNQ = studentRepository.findAllStudentsNQ();
        System.out.println(allStudentsNQ);
    }

    @Test
    void findAllStudentsLikeNQ() {
        List<Student> studentsLikeNQ = studentRepository.findAllStudentsLikeNQ("S");
        studentsLikeNQ.forEach(System.out::println);
    }
}

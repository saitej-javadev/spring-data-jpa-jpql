package com.saitej.springdatajpajpql.repository;

import com.saitej.springdatajpajpql.entities.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Long> {

    /*JPQL queries*/

    @Query("from Student")
    List<Student> findAllStudents();

    @Query("select st.firstName,st.lastName from Student st")
    List<Object[]> findAllStudentsPartialData();

    @Query("from Student where firstName=:firstName")
    List<Student> findAllStudentByFirstName(@Param("firstName") String firstName);

    @Query("from Student where score>:min and score<:max")
    List<Student> findStudentsForGivenScores(@Param("min") int min,@Param("max") int max);

    @Modifying
    @Query("delete from Student where firstName = :firstName")
    void deleteStudentsByFirstName(@Param("firstName") String firstName);

}

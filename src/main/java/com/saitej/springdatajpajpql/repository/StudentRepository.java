package com.saitej.springdatajpajpql.repository;

import com.saitej.springdatajpajpql.entities.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface StudentRepository extends CrudRepository<Student,Long> {

    /*JPQL queries*/
   /* In JPQL we use Entity class name to fetch values */

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


    /*NATIVE QUERIES*/
    /*Native queries are same like traditional queries table name and column names should match with database table and column names*/

    @Query(value = "select * from student",nativeQuery = true)
    List<Student> findAllStudentsNQ();

    @Query(value = "select * from student as  s  where s.lname like :input%",nativeQuery = true)
    List<Student> findAllStudentsLikeNQ(@Param("input") String input);

}

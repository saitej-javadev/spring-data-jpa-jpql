package com.saitej.springdatajpajpql.repository;

import com.saitej.springdatajpajpql.entities.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentPagingAndSortingRepository extends PagingAndSortingRepository<Student,Long> {
    /*JPQL queries using PagingAndSorting*/

    @Query("from Student")
    List<Student> findAllStudents(Pageable pageable);

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


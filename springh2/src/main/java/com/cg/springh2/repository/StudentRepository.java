package com.cg.springh2.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.springh2.modal.Student;

public interface StudentRepository extends CrudRepository<Student,Integer> {

}

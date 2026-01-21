package com.tap.repository;

import org.hibernate.boot.jaxb.mapping.spi.JaxbPersistentAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tap.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	

}

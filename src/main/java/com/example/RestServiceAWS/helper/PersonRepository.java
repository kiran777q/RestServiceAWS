package com.example.RestServiceAWS.helper;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.RestServiceAWS.DTO.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
}

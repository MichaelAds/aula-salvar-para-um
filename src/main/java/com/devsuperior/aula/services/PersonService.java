package com.devsuperior.aula.services;

import com.devsuperior.aula.dto.DepartmentDTO;
import com.devsuperior.aula.dto.PersonDTO;
import com.devsuperior.aula.dto.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DepartmentRepository departmentRepository;
    public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {
        Person entity = new Person();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        Department dept = departmentRepository.getReferenceById(dto.getDepartment().getId());
        // Department dept = new Department();
        // dept.setId(dto.getDepartment().getId());
        // dept.setName(dto.getDepartment().getName());

        entity.setDepartment(dept);

        entity = personRepository.save(entity);

        return new PersonDepartmentDTO(entity);
    }

    public PersonDTO insert(PersonDTO  dto) {
        Person entity = new Person();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        Department dept = departmentRepository.getReferenceById(dto.getDepartmentId());


        entity.setDepartment(dept);

        entity = personRepository.save(entity);

        return new PersonDTO(entity);
    }
}

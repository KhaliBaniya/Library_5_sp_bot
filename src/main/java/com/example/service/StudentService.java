package com.example.service;

import com.example.dto.StudentDTO;
import com.example.entity.StudentEntity;
import com.example.exp.AppBadRequestException;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.Inet4Address;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    StudentDTO getById(Integer id){
        StudentEntity entity = studentRepository.get(id);
        if(entity == null){
            throw new AppBadRequestException("Student not found");
        }
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());

        return dto;
    }

    public StudentDTO crate(StudentDTO dto) {
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new AppBadRequestException("Name qani?");
        }
        if (dto.getSurname() == null || dto.getSurname().isBlank()) {
            throw new AppBadRequestException("Surname qani?");
        }
        studentRepository.saveStudent(entity);
        dto.setId(entity.getId());
        return dto;
    }
//    public boolean delete(Integer id){
//        StudentEntity entity = get(id);
//        studentRepository.delete(entity);
//        return true;
//    }
//
//    public StudentEntity get(Integer id){
//        if(entity == null){
//            throw new AppBadRequestException("Student not found"+id);
//        }
//
//    }    // cheek
}

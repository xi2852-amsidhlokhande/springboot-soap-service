package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.model.*;
import com.amsidh.mvc.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private static final Map<Long, Student> studentMap = new HashMap<>();

    static {
        log.info("static method of StudentServiceImpl");
        Student student = new Student();
        student.setId(1);
        student.setName("Aditya");
        student.setAddress("PWC");
        student.setStandard(3);
        student.setGender("Male");
        studentMap.put(student.getId(), student);
    }

    @Override
    public GetStudentByIdResponse getStudentById(GetStudentByIdRequest getStudentByIdRequest) {
        log.info("getStudentById method is called");
        Student student = studentMap.get(getStudentByIdRequest.getId());
        GetStudentByIdResponse getStudentByIdResponse = new GetStudentByIdResponse();
        if (Objects.isNull(student)) {
            ServiceStatus serviceStatus = new ServiceStatus();
            serviceStatus.setStatusCode("404");
            serviceStatus.setMessage("Student Not Found");
            getStudentByIdResponse.setServiceStatus(serviceStatus);
        }
        getStudentByIdResponse.setStudent(student);
        return getStudentByIdResponse;
    }

    @Override
    public SaveStudentResponse saveStudent(SaveStudentRequest saveStudentRequest) {
        log.info("saveStudent method is called");
        Student student = saveStudentRequest.getStudent();
        studentMap.put(student.getId(), student);
        SaveStudentResponse saveStudentResponse = new SaveStudentResponse();
        saveStudentResponse.setStudent(student);
        return saveStudentResponse;
    }

    @Override
    public UpdateStudentResponse updateStudent(UpdateStudentRequest updateStudentRequest) {
        log.info("updateStudent method is called");
        long studentId = updateStudentRequest.getId();
        Optional<UpdateStudentResponse> updateStudentResponse = Optional.ofNullable(studentMap.get(studentId)).map(student -> {
            Student requestStudent = updateStudentRequest.getStudent();
            Optional.ofNullable(requestStudent.getName()).ifPresent(name -> student.setName(name));
            Optional.ofNullable(requestStudent.getStandard()).ifPresent(standard -> student.setStandard(standard));
            Optional.ofNullable(requestStudent.getAddress()).ifPresent(address -> student.setAddress(address));
            return student;
        }).map(student -> {
            UpdateStudentResponse updateStudent = new UpdateStudentResponse();
            updateStudent.setStudent(student);
            return updateStudent;
        });

        return updateStudentResponse.get();
    }

    @Override
    public DeleteStudentByIdResponse deleteStudentById(DeleteStudentByIdRequest deleteStudentByIdRequest) {
        log.info("deleteStudentById method is called");
        studentMap.remove(deleteStudentByIdRequest.getId());
        DeleteStudentByIdResponse deleteStudentByIdResponse = new DeleteStudentByIdResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatusCode(HttpStatus.OK.getReasonPhrase());
        serviceStatus.setMessage(String.format("Student with id {} delete successfully", deleteStudentByIdRequest.getId()));
        deleteStudentByIdResponse.setServiceStatus(serviceStatus);
        return deleteStudentByIdResponse;
    }

    @Override
    public GetAllStudentResponse getAllStudent(GetAllStudentRequest getAllStudentRequest) {
        log.info("getAllStudent method is called");
        GetAllStudentResponse getAllStudentResponse = new GetAllStudentResponse();
        getAllStudentResponse.getStudents().addAll(studentMap.values());
        return getAllStudentResponse;
    }
}

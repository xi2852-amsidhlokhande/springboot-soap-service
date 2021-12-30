package com.amsidh.mvc.service;

import com.amsidh.mvc.model.*;

public interface StudentService {

    GetStudentByIdResponse getStudentById(GetStudentByIdRequest getStudentByIdRequest);

    SaveStudentResponse saveStudent(SaveStudentRequest saveStudentRequest);

    UpdateStudentResponse updateStudent(UpdateStudentRequest updateStudentRequest);

    DeleteStudentByIdResponse deleteStudentById(DeleteStudentByIdRequest deleteStudentByIdRequest);

    GetAllStudentResponse getAllStudent(GetAllStudentRequest getAllStudentRequest);
}

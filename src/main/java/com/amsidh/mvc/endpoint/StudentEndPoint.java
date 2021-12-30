package com.amsidh.mvc.endpoint;

import com.amsidh.mvc.model.*;
import com.amsidh.mvc.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class StudentEndPoint {
    private static final String NAMESPACE = "http://www.model.mvc.amsidh.com";
    private final StudentService studentService;

    @PayloadRoot(namespace = NAMESPACE, localPart = "getStudentByIdRequest")
    @ResponsePayload
    public GetStudentByIdResponse studentById(@RequestPayload GetStudentByIdRequest getStudentByIdRequest) {
        return studentService.getStudentById(getStudentByIdRequest);
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "saveStudentRequest")
    @ResponsePayload
    public SaveStudentResponse saveStudent(@RequestPayload SaveStudentRequest saveStudentRequest) {
        return studentService.saveStudent(saveStudentRequest);
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "updateStudentRequest")
    @ResponsePayload
    public UpdateStudentResponse updateStudent(@RequestPayload UpdateStudentRequest updateStudentRequest) {
        return studentService.updateStudent(updateStudentRequest);
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "deleteStudentByIdRequest")
    @ResponsePayload
    public DeleteStudentByIdResponse updateStudent(@RequestPayload DeleteStudentByIdRequest deleteStudentByIdRequest) {
        return studentService.deleteStudentById(deleteStudentByIdRequest);
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "getAllStudentRequest")
    @ResponsePayload
    public GetAllStudentResponse allStudent(@RequestPayload GetAllStudentRequest getAllStudentRequest) {
        return studentService.getAllStudent(getAllStudentRequest);
    }
}

package com.amsidh.mvc.endpoint;

import com.amsidh.mvc.model.Student;
import com.amsidh.mvc.model.StudentDetailsRequest;
import com.amsidh.mvc.model.StudentDetailsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@Slf4j
public class StudentEndPoint {
    private static final String NAMESPACE_URI = "http://www.model.mvc.amsidh.com";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
    @ResponsePayload
    public StudentDetailsResponse getElinkIssueResponse(@RequestPayload StudentDetailsRequest studentDetailsRequest) {
        log.info("StudentDetailsRequest received {}", studentDetailsRequest);
        StudentDetailsResponse studentDetailsResponse = new StudentDetailsResponse();
        Student student = new Student();
        student.setName("Amsidh");
        student.setStandard(16);
        student.setAddress("Pune");
        studentDetailsResponse.setStudent(student);
        return studentDetailsResponse;
    }
}

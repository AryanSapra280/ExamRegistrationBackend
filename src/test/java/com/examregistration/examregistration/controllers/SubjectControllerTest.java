package com.examregistration.examregistration.controllers;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.examregistration.examregistration.entities.Subject;

@AutoConfigureMockMvc
@SpringBootTest
public class SubjectControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void totalSubject() {
        List<Subject>subjects = new ArrayList<>();
        Subject hindi = new Subject();
        Subject Maths = new Subject();
        Subject Grammar = new Subject();
        hindi.setSubjectId(3L);
        hindi.setSubjectName("Hindi");
        Maths.setSubjectId(2L);
        Maths.setSubjectName("Maths");
        Grammar.setSubjectId(4L);
        Grammar.setSubjectName("Grammar");
        subjects.add(hindi);
        subjects.add(Maths);
        subjects.add(Grammar);
        
    }
}

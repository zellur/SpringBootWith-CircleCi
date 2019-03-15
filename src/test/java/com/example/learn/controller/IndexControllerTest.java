package com.example.learn.controller;

import com.example.learn.Services.TestService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

    @Mock
    TestService testService;

    @Mock
    Model model;

    IndexController indexController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(testService);
    }

    @Test
    public void getTest() {
        String viewName = indexController.getTest(model);
        assertEquals("index",viewName);
        verify(testService,times(1)).getTest();
        verify(model,times(1)).addAttribute(eq("test"),any());
    }

    @Test
    public void getTestMockMvc() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

    }
}
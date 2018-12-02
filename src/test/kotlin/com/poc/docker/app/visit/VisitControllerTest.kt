package com.poc.docker.app.visit

import com.poc.docker.app.controller.CounterController
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.hamcrest.Matchers.containsString

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class VisitControllerTest {

    @Autowired
    private lateinit var counterController: CounterController

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun contextLoads() {
        assertThat(counterController).isNotNull
    }

    @Test
    fun visitCounterShouldReturnNumberOfVisits() {
        mockMvc.perform(get("/api/visits/counter"))
                .andExpect(status().is2xxSuccessful)
                .andExpect(content().string(containsString("Number of visits")))
    }
}
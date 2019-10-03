package com.altran.manuelstore.controller;

import com.altran.manuelstore.model.Product;
import com.altran.manuelstore.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ProductControllerTest {

    @MockBean
    ProductRepository productRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldCreateProduct() throws Exception {
        Product p = new Product();
        p.setName("Produto 1");
        p.setDescription("Descrição toop");
        p.setPrice(50.0);
        p.setStock(5);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/products")
                .content(new ObjectMapper().writeValueAsString(p))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldNotCreateProduct() throws Exception {
        Product p = new Product();
        p.setStock(32);
        p.setDescription("asjdnladna");
        p.setPrice(12.2);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/products")
                .content(new ObjectMapper().writeValueAsString(p))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}

package com.hackers.mycommerce.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackers.mycommerce.hello.ProductController;
import com.hackers.mycommerce.hello.ProductDto;
import com.hackers.mycommerce.hello.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired private MockMvc mockMvc;
    @MockBean
    ProductService productService;

    @Test
    void getProductTest() throws Exception {
        given(productService.getProduct("book")).willReturn(ProductDto.builder().name("book").price(10000.0).build());

        String name = "book";

        // 기대하는 값이 나왔는지
        mockMvc.perform(
                       get("/products/" + name))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("book"))
                .andExpect(jsonPath("$.price").value(10000.0))
                .andDo(print());
        verify(productService).getProduct("book");
    }

    @Test
    void postProductTEst() throws Exception {
        given(productService.saveProduct("book", 10000.0)).willReturn(ProductDto.builder().name("book").price(10000.0).build());

        ProductDto productDto = ProductDto.builder()
                .name("book")
                .price(10000.0)
                .build();
        String testJson = new ObjectMapper().writeValueAsString(productDto);

        mockMvc.perform(
                post("/products")
                        .content(testJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("book"))
                .andExpect(jsonPath("$.price").value(10000.0))
                .andDo(print());

        verify(productService).saveProduct("book", 10000.0);
    }
}

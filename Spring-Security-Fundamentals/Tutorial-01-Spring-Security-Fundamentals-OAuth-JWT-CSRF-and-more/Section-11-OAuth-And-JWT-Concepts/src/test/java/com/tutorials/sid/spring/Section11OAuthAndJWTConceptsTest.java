package com.tutorials.sid.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Section11OAuthAndJWTConcepts.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class Section11OAuthAndJWTConceptsTest {

    @Test
    void test() {
        System.out.println("Hello World");
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetCouponWithoutAuth() throws Exception {
        mockMvc.perform(get("/couponapi/getcoupon/SUPERVALUE12345")).andExpect(status().isOk());
    }

    @Test
    public void testGetCouponWithoutAuthForbidden() throws Exception {
        mockMvc.perform(get("/couponapi/getcoupon/SUPERVALUE12345")).andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser
    public void testGetCouponWithAuth() throws Exception {
        mockMvc.perform(get("/couponapi/getcoupon/SUPERVALUE12345")).andExpect(status().isOk());
    }

    @Test
    @WithUserDetails("doug@bailey.com")
    public void testGetCouponWithAuthUsingUserDetails() throws Exception {
        mockMvc.perform(get("/couponapi/getcoupon/SUPERVALUE12345")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = {"USER"})
    public void testGetCouponWithAuthRole() throws Exception {
        mockMvc.perform(get("/couponapi/getcoupon/SUPERVALUE12345"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"code\":\"SUPERVALUE12345\",\"discount\":20.00,\"expDate\":\"22062024\"}"));
    }

    @Test
    public void testGetCouponWithoutAuthCSRFForbidden() throws Exception {
        mockMvc.perform(get("/couponapi/getcoupon/SUPERVALUE12345")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = {"USER"})
    public void testGetCouponWithoutAuthCSRF() throws Exception {
        mockMvc.perform(get("/couponapi/getcoupon/NEWYEAR")
                        .with(csrf().asHeader()))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"code\":\"NEWYEAR\",\"discount\":20.00,\"expDate\":\"22062024\"}"));
    }

}

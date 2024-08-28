package com.peter.springsecurity.service;

import org.springframework.stereotype.Service;

@Service
public class JWTService {


    public String generateToken() {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6InNzIiwiaWF0IjoxNTE2MjM5MDIyLCJleHAiOjE1MTYyNDkwMjJ9.coWt4ipv4tMFmSvj_gDFp6m-npjfQszxN1DGudRf5YE";
    }
}

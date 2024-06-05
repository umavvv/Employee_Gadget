package org.example.employee_gadget.dto;

import lombok.Builder;

@Builder
public class AuthenticationDto {
    private Long id;
    private String gmail;
    private String password;

    public AuthenticationDto() {
    }

    public AuthenticationDto(Long id, String gmail, String password) {
        this.id = id;
        this.gmail = gmail;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
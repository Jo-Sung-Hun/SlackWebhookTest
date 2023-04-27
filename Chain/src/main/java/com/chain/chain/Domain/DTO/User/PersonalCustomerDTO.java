package com.chain.chain.Domain.DTO.User;

import com.chain.chain.Domain.Entity.User.PersonalCustomer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


public class PersonalCustomerDTO {

    private String name;
    private String phoneNumber;
    private String birth;

    private String nickName;
    private String email;
    private String password;
    public PersonalCustomerDTO() {
    }
    @Builder
    public PersonalCustomerDTO(String name, String phoneNumber, String birth, String nickName, String email, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public PersonalCustomer toEntity(){
        return PersonalCustomer.builder()
                .name(this.name)
                .nickName(this.nickName)
                .password(this.password)
                .phoneNumber(this.phoneNumber)
                .email(this.email)
                .build();
    }
}

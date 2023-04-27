package com.chain.chain.Domain.Entity.User;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class PersonalCustomer implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
   //@NotNull
    //@NotEmpty
    //@NotBlank
    //@Pattern(regexp = "^[ㄱ-ㅎㅏ-ㅣ가-힣]{2,4}$")
    private String name;
    //@Pattern(regexp = "\\\\d{3}-\\\\d{4}-\\\\d{4}")
    //@NotEmpty
    //@NotNull
    private String phoneNumber;
    //@NotEmpty
    //@NotNull
    //@Pattern(regexp = "\\\\d{4}\\\\d{2}\\\\d{2}")
    private String birth;
    private String email;
    // 특수문자 불허
    private String nickName;
    private String password;
/*    @NotEmpty
    @NotNull
    @NotBlank*/
    private LocalDateTime signDay;
    @Enumerated(EnumType.STRING)
    private Role role;


    public PersonalCustomer() {
    }
    @Builder
    public PersonalCustomer(UUID id, String name, String phoneNumber, String birth, String email, String nickName, String password) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
        this.email = email;
        this.nickName = nickName.replace("[^a-zA-Z0-9]", "");
        this.role = Role.USER;
        this.signDay = LocalDateTime.now();
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public LocalDateTime getSignDay() {
        return signDay;
    }

    public void setSignDay(LocalDateTime signDay) {
        this.signDay = signDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PersonalCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birth='" + birth + '\'' +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", signDay=" + signDay +
                ", role=" + role +
                '}';
    }
}

package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Id;
//import javax.persistence.MappedSuperclass;
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nic;
    private String first_name;
    private String last_name;
    private String tel_no;
    private String email;
    private String address;
    private String password;
    private Integer status; //To mark active users
    private Integer type; //To mark users type - Ministry User, RDHS User etc
    private Integer role; //to mark the role of user in each type

    public User(String nic, String first_name, String last_name, String tel_no, String email, String address, String password, Integer status, Integer type, Integer role) {
        this.nic = nic;
        this.first_name = first_name;
        this.last_name = last_name;
        this.tel_no = tel_no;
        this.email = email;
        this.address = address;
        this.password = password;
        this.status = status;
        this.type = type;
        this.role = role;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "nic='" + nic + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", tel_no='" + tel_no + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", role=" + role +
                '}';
    }

}

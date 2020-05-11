package com.example.pharmanic;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Ministry_Driver {
    private @Id String nic;
    private String name;
    private String email;
    private String address;
    private String telephone;

    public Ministry_Driver() {
    }

    public Ministry_Driver(String nic, String name, String email, String address, String telephone) {
        this.nic = nic;
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}

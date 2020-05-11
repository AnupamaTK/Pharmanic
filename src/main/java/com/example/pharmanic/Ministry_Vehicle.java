package com.example.pharmanic;

import com.sun.xml.bind.v2.runtime.SchemaTypeTransducer;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Ministry_Vehicle {
    private @Id String vehicle_no;

    private String type;
    private Long capacity;

    public Ministry_Vehicle() {
    }

    public Ministry_Vehicle(String vehicle_no, String type, Long capacity) {
        this.vehicle_no = vehicle_no;
        this.type = type;
        this.capacity = capacity;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }
}

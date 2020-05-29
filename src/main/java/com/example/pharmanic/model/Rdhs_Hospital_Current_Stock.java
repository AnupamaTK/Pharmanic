package com.example.pharmanic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "Rdhs_Hospital_Current_Stock")
public class Rdhs_Hospital_Current_Stock {
    @Id
    private Long batchId;
    private int quantity;
    private String expiredate;

    @ManyToOne
    @JoinColumn(name = "reg_no", nullable = false, referencedColumnName = "reg_no")
    private Hospital_By_Rdhs hospital_by_rdhs;


    @ManyToOne
    @JoinColumn(name = "sr_no", nullable = false, referencedColumnName = "sr_no")
    private Medicine medicine;


}

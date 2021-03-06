package com.example.pharmanic.web;

import com.example.pharmanic.model.Ministry_Current_Stock;
import com.example.pharmanic.model.Ministry_Store_Damage_Drug;
import com.example.pharmanic.repositories.Ministry_Store_Damage_DrugRepository;
import com.example.pharmanic.services.Ministry_Store_Damage_DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Ministry_Store_Damage_DrugController {

    @Autowired
    Ministry_Store_Damage_DrugRepository ministry_store_damage_drugRepository;

    @Autowired
    Ministry_Store_Damage_DrugService ministry_store_damage_drugService;

    @GetMapping("/ministrydamagestocks")
    public List<Ministry_Store_Damage_Drug> getMinistryDamageStockList(){
        return ministry_store_damage_drugService.getMinistryDamageDrugStockList();
    }

    @PostMapping("/ministrydamagestock/add")
    public Integer addMinistryDamageStock(@RequestBody Ministry_Store_Damage_Drug ministry_store_damage_drug){
        return ministry_store_damage_drugService.addDrugsToMinistryDamageStock(ministry_store_damage_drug);
    }

    @PutMapping("/ministrydamagestock/update")
    public ResponseEntity<Ministry_Store_Damage_Drug> updateMinistryDamageStock(@Valid @RequestBody Ministry_Store_Damage_Drug object) {
        Ministry_Store_Damage_Drug ministry_store_damage_drug = ministry_store_damage_drugService.updateMinistryDamageStock(object);
        if (ministry_store_damage_drug.getDid()!= null) {
            return ResponseEntity.ok(ministry_store_damage_drug);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/ministrydamagestock/{did}")
    public ResponseEntity<Void> deleteDamageStock(@PathVariable("did") Long did) {
        //  System.out.println("In vehicleId controller delete method");

        String reply = ministry_store_damage_drugService.deleteministryDamageStock(did);
        if (reply.equals("success")) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

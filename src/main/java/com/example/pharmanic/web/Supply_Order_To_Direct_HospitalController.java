package com.example.pharmanic.web;

import com.example.pharmanic.model.Supply_Order_To_Direct_Hospital;
import com.example.pharmanic.model.Supply_Order_To_Direct_HospitalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Supply_Order_To_Direct_HospitalController {
    private final Logger log = LoggerFactory.getLogger(Supply_Order_To_Direct_HospitalController.class);
    private Supply_Order_To_Direct_HospitalRepository supply_order_to_direct_hospitalRepository;

    public Supply_Order_To_Direct_HospitalController(Supply_Order_To_Direct_HospitalRepository supply_order_to_direct_hospitalRepository) {
        this.supply_order_to_direct_hospitalRepository = supply_order_to_direct_hospitalRepository;
    }

    @GetMapping("/supplyordertodirecthospitals")
    Collection<Supply_Order_To_Direct_Hospital> supplyordertodirecthospitals(){
        return supply_order_to_direct_hospitalRepository.findAll();
    }

    @GetMapping("/supplyordertodirecthospital/{id}")
    ResponseEntity<?> getSupplyordertodirecthospital(@PathVariable Long order_id){
        Optional<Supply_Order_To_Direct_Hospital> supply_order_to_direct_hospital=supply_order_to_direct_hospitalRepository.findById(order_id);
        return supply_order_to_direct_hospital.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/supplyordertodirecthospital")
    ResponseEntity<Supply_Order_To_Direct_Hospital> createSupplyordertodirecthospital(@Valid @RequestBody Supply_Order_To_Direct_Hospital supply_order_to_direct_hospital) throws URISyntaxException{
        log.info("Request to create supply order to direct hospital: {}",supply_order_to_direct_hospital);
        Supply_Order_To_Direct_Hospital result = supply_order_to_direct_hospitalRepository.save(supply_order_to_direct_hospital);
        return ResponseEntity.created(new URI("/api/supplyordertodirecthospital/"+result.getOrder_id()))
                .body(result);
    }

    @DeleteMapping("/supplyordertodirecthospital/{id}")
    public ResponseEntity<?> deleteSupplyordertodirecthospital(@PathVariable Long order_id){
        log.info("Request to delete supply order to direct hospital: {}" ,order_id);
        supply_order_to_direct_hospitalRepository.deleteById(order_id);
        return ResponseEntity.ok().build();
    }
}

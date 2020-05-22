package com.example.pharmanic.web;

import com.example.pharmanic.model.Ministry_Vehicle;
import com.example.pharmanic.model.Rdhs;
import com.example.pharmanic.repositories.RdhsRepository;
import com.example.pharmanic.services.RdhsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class RdhsController {

    @Autowired
    RdhsRepository rdhsRepository;

    @Autowired
    RdhsService rdhsService;

    @GetMapping("/rdhss")
    public List<Rdhs> getRdhsList()
    {
        return rdhsService.getRdhsList();
    }

    @GetMapping("/rdhss/{reg_no}")
    public ResponseEntity<Rdhs> getRdhs(@PathVariable("reg_no") String reg_no){
        Rdhs rdhs=(Rdhs) rdhsService.getRdhsDetails(reg_no);
        if(rdhs.getReg_no() !=null){
            return ResponseEntity.ok(rdhs);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/rdhs")
    public ResponseEntity<Rdhs> addRdhs(@RequestBody Rdhs newRdhs) {
        if (newRdhs == null)
            return ResponseEntity.noContent().build();
        newRdhs = rdhsService.addRdhs(newRdhs);
        return ResponseEntity.ok(newRdhs);
    }


    @PutMapping("/rdhs")
    public ResponseEntity<Rdhs> updateRdhs(@RequestBody Rdhs newRdhs) {

//        return repository.findById(id)
//                .map(employee -> {
//                    employee.setName(newEmployee.getName());
//                    employee.setRole(newEmployee.getRole());
//                    return repository.save(employee);
//                })
//                .orElseGet(() -> {
//                    newEmployee.setId(id);
//                    return repository.save(newEmployee);
//                });
      if(rdhsService.updateRdhs(newRdhs)!=null){
          return ResponseEntity.ok(newRdhs);
      }
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/rdhs/{reg_no}")
    public ResponseEntity<Integer> deleteRdhs(@PathVariable String reg_no) {
        Integer reply=rdhsService.deleteRdhs(reg_no);

        if (reply != null) {
            return ResponseEntity.ok(reply);
        }
        return ResponseEntity.notFound().build();
    }


}

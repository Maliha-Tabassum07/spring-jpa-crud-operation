package com.maliha.springjpadatabase.controller;

import com.maliha.springjpadatabase.model.Wizards;
import com.maliha.springjpadatabase.service.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WizardController {
    @Autowired
    WizardService wizardService;

    @GetMapping("/wizard/all")
    public ResponseEntity<List<Wizards>> getAllWizard() {
        List<Wizards> wizardList = wizardService.getAllWizards();
        return new ResponseEntity<>(wizardList, HttpStatus.OK);
    }

    @GetMapping("/wizard/{id}")
    public ResponseEntity<Wizards> getWizardById(@PathVariable Integer id) {
        Wizards wizard = wizardService.getWizardById(id).get();
        return new ResponseEntity<>(wizard, HttpStatus.OK);
    }

    @PostMapping("/add/wizard")
    public ResponseEntity<Void> addWizard(@RequestBody Wizards wizard) {
        wizardService.addWizards(wizard);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    @DeleteMapping("/delete/wizard/{id}")
    public boolean deleteWizard(@PathVariable Integer id) {
        wizardService.deleteWizardById(id);
        return true;
    }
    @PutMapping("/update/wizard/{id}")
    public boolean updateWizard(@PathVariable Integer id) {
        wizardService.updateWizard(wizardService.getWizardById(id).get());
        return true;
    }

}

package com.maliha.springjpadatabase.service;

import com.maliha.springjpadatabase.model.Wizards;
import com.maliha.springjpadatabase.repository.WizardInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WizardService {
    @Autowired
    private WizardInterface repositoryInterface;

    public List<Wizards> getAllWizards(){
        return repositoryInterface.findAll();

    }
    public Optional<Wizards> getWizardById(Integer id){
        return repositoryInterface.findById(id);
    }

    public void addWizards(Wizards wizards){
        repositoryInterface.save(wizards);
    }

    public void deleteWizardById(Integer id){
        repositoryInterface.deleteById(id);
    }


    public Wizards updateWizard (Wizards updatedWizard){
        if (repositoryInterface.existsById(updatedWizard.getId()))
            return repositoryInterface.save(updatedWizard);
        else return null;
    }

}

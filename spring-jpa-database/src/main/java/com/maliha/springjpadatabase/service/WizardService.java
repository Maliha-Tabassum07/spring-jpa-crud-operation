package com.maliha.springjpadatabase.service;

import com.maliha.springjpadatabase.model.House;
import com.maliha.springjpadatabase.model.Wizards;
import com.maliha.springjpadatabase.repository.RepositoryInterface;
import com.maliha.springjpadatabase.repository.WizardInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WizardService {
    @Autowired
    private WizardInterface wizardInterface;
    private final RepositoryInterface houseRepository;

    public WizardService(WizardInterface wizardInterface, RepositoryInterface houseRepository) {
        this.wizardInterface = wizardInterface;
        this.houseRepository = houseRepository;
    }

    public List<Wizards> getAllWizards(){
        return wizardInterface.findAll();

    }
    public Optional<Wizards> getWizardById(Integer id)throws NullPointerException{
        if (wizardInterface.existsById(id))
        return wizardInterface.findById(id);
        else throw new NullPointerException();
    }

    public void addWizards(Wizards wizards, Integer houseId){

        House house = houseRepository.findById(houseId).orElseThrow(()-> new NullPointerException());
        Wizards savedWizard = wizardInterface.save(wizards);
        house.getWizards().add(savedWizard);
        houseRepository.save(house);

    }

    public void deleteWizardById(Integer wId,Integer hId) {
        House house = houseRepository.findById(hId).orElseThrow(()-> new NullPointerException());
        Wizards wizards=wizardInterface.findById(wId).orElseThrow(()-> new NullPointerException());
        house.getWizards().remove(wizards);
        houseRepository.save(house);
        wizardInterface.deleteById(wId);
    }
//    public void deleteWizardById(Integer wId){
//        wizardInterface.deleteById(wId);
//    }


    public Wizards updateWizard (Wizards updatedWizard) throws NullPointerException{
        if (wizardInterface.existsById(updatedWizard.getId()))
            return wizardInterface.save(updatedWizard);
        else throw new NullPointerException();
    }

}

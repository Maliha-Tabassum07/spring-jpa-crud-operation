package com.maliha.springjpadatabase.service;

import com.maliha.springjpadatabase.model.House;
import com.maliha.springjpadatabase.repository.RepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {
    @Autowired
    private RepositoryInterface repositoryInterface;

    public List<House> getAllHouse(){
        return repositoryInterface.findAll();

    }
    public Optional<House> getHouseById(Integer id)throws NullPointerException{
        if (repositoryInterface.existsById(id)){
        return repositoryInterface.findById(id);
        }
        else throw new NullPointerException();
    }

    public void addHouses(House house){
        repositoryInterface.save(house);
    }

    public void deleteHouseById(Integer id)throws NullPointerException, RuntimeException{
        if (repositoryInterface.existsById(id)){
            if (repositoryInterface.findById(id).get().getWizards().isEmpty()){
            repositoryInterface.deleteById(id);}
            else {throw new RuntimeException();}
        }
        else {throw new NullPointerException();}
    }





}

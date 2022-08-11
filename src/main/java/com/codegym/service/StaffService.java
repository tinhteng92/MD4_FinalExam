package com.codegym.service;


import com.codegym.model.Staff;
import com.codegym.repository.IStaffRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
@Repository
public class StaffService implements IStaffService {
    @Autowired
    IStaffRepo iStaffRepo;

    @Override
    public List<Staff> getAll(){
        return (List<Staff>) iStaffRepo.findAll();
    }
    @Override
    public List<Staff> getAllByName(String name){
        return iStaffRepo.findByNameContaining(name);
    }
    @Override
    public void save(Staff staff){
        iStaffRepo.save(staff);
    }
    @Override
    public void delete(int id){
        iStaffRepo.deleteById(id);
    }
    @Override
    public Optional<Staff> findById(int id){
        return iStaffRepo.findById(id);
    }
    @Override
    public Optional<Staff> findByName(String name){
        return iStaffRepo.findByName(name);
    }
}

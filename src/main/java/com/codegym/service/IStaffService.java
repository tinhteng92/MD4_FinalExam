package com.codegym.service;

import com.codegym.model.Branch;
import com.codegym.model.Staff;

import java.util.List;
import java.util.Optional;

public interface IStaffService extends IService<Staff>{
    List<Staff> getAll();
    void save(Staff staff);
    List<Staff> getAllByName(String name);
    void delete(int id);
    Optional<Staff> findById(int id);
    Optional<Staff> findByName(String name);
}

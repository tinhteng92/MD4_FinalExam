package com.codegym.service;

import com.codegym.model.Branch;

import java.util.List;

public interface IBranchService extends IService<Branch> {
    List<Branch> getAll();
    void save(Branch branch);
    Branch findById(int idB);
}

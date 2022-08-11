package com.codegym.service;

import com.codegym.model.Branch;
import com.codegym.repository.IBranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService implements IBranchService{
    @Autowired
    IBranchRepo iBranchRepo;

    public List<Branch> getAll(){
        return (List<Branch>) iBranchRepo.findAll();

    }

    @Override
    public void save(Branch branch) {

    }

    public Branch findById(int idB) {
        return iBranchRepo.findById(idB).get();
    }
}

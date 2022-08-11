package com.codegym.repository;

import com.codegym.model.Branch;
import org.springframework.data.repository.CrudRepository;

public interface IBranchRepo extends CrudRepository<Branch, Integer> {
}

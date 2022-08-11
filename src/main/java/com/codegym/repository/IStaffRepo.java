package com.codegym.repository;

import com.codegym.model.Staff;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;
public interface IStaffRepo extends CrudRepository<Staff, Integer> {
    List<Staff> findByNameContaining(String name);
    Optional<Staff> findByName(String name);
    @Query(nativeQuery = true, value = "Select * from staff order by age")
    List<Staff> sortByAge();
}

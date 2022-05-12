package com.example.branchservice.persistence;

import com.example.branchservice.model.Branch;

import java.util.Collection;
import java.util.Optional;

public interface BranchRepository {
    Collection<Branch> findAll();
    Optional<Branch> findById(Long id);
    Branch save(Branch branch);
    void deleteById(Long id);
}

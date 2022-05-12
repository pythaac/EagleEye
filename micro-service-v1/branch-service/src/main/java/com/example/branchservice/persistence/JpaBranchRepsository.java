package com.example.branchservice.persistence;

import com.example.branchservice.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaBranchRepsository extends JpaRepository<Branch, Long>, BranchRepository {
    List<Branch> findAll();
    Optional<Branch> findById(Long id);
    Branch save(Branch branch);
    void deleteById(Long id);
}

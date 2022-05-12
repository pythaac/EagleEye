package com.example.branchservice.service;

import com.example.branchservice.model.Branch;
import com.example.branchservice.persistence.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchCRUDService {
    private final BranchRepository branchRepository;

    @Autowired
    public BranchCRUDService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public void newBranch(Branch branch){
        branchRepository.save(branch);
    }

    public Branch findBranch(Long id){
        return branchRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public List<Branch> findAllBranches(){
        return (List<Branch>) branchRepository.findAll();
    }

    public void changeBranchInfo(Long id, String newName){
        Branch branch = findBranch(id);
        branch.setName(newName);
        branchRepository.save(branch);
    }

    public void removeBranch(Long id){
        branchRepository.deleteById(id);
    }
}

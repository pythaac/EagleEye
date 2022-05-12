package com.example.branchservice.controller;

import com.example.branchservice.model.Branch;
import com.example.branchservice.request.RequestDeleteBranch;
import com.example.branchservice.request.RequestPostBranch;
import com.example.branchservice.request.RequestPutBranchName;
import com.example.branchservice.service.BranchCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BranchController {
    private final BranchCRUDService branchCRUDService;

    @Autowired
    public BranchController(BranchCRUDService branchCRUDService) {
        this.branchCRUDService = branchCRUDService;
    }

    @RequestMapping(value = "/branch/{id}", method = RequestMethod.GET)
    public ResponseEntity getBranch(@PathVariable("id") Long id){
        return new ResponseEntity<>(branchCRUDService.findBranch(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/branch/all", method = RequestMethod.GET)
    public ResponseEntity getBranchAll(){
        return new ResponseEntity<>(branchCRUDService.findAllBranches(), HttpStatus.OK);
    }

    @RequestMapping(value = "/branch", method = RequestMethod.POST)
    public ResponseEntity postBranch(RequestPostBranch requestPostBranch){
        Branch branch = new Branch();
        branch.setName(requestPostBranch.getName());
        branchCRUDService.newBranch(branch);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/branch/name", method = RequestMethod.PUT)
    public ResponseEntity putBranch(RequestPutBranchName requestPutBranchName){
        branchCRUDService.changeBranchInfo(requestPutBranchName.getId(), requestPutBranchName.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/branch", method = RequestMethod.DELETE)
    public ResponseEntity deleteBranch(RequestDeleteBranch requestDeleteBranch){
        branchCRUDService.removeBranch(requestDeleteBranch.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}




























package com.example.branchservice.response;

import com.example.branchservice.model.Branch;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGetBranchAll {
    private List<Branch> branches;
}

package com.boehm.siebel.deploy.deploy;

import com.boehm.siebel.deploy.deploy.dto.BranchDTO;
import com.boehm.siebel.deploy.deploy.exception.MergeException;
import org.springframework.stereotype.Service;

import java.io.File;

public interface MergeService {
    public void mergeBranch(BranchDTO from, BranchDTO to) throws MergeException;
    public void initBranch(BranchDTO to, File f) throws MergeException;
}

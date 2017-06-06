package com.boehm.siebel.deploy.deploy;

import com.boehm.siebel.deploy.deploy.dto.BranchDTO;
import com.boehm.siebel.deploy.deploy.exception.MergeException;
import org.springframework.stereotype.Service;
import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNProperties;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.*;

import java.io.File;
import java.util.UUID;

@Service
public class MergeServiceImpl implements MergeService{
    private String workingDirectory = "C:/Temp/SVNMerge/";

    public MergeServiceImpl() {

    }

    public String getWorkingDirectory() {
        return workingDirectory;
    }

    public void setWorkingDirectory(String workingDirectory) {
        this.workingDirectory = workingDirectory;
    }

    @Override
    public void mergeBranch(BranchDTO from, BranchDTO to) throws MergeException {
        try {
            String comment = "SIE-25: Merge von XXX auf YYY";
            File f = new File("c9ce7ac2-20ef-4bea-9fcf-6c28d0070145/");

            f.mkdir();

            SVNURL fromSVNURL = SVNURL.parseURIEncoded(from.getBranchUrl());
            SVNURL fromSVNFileURL = SVNURL.fromFile(f);
            SVNURL toSVNURL = SVNURL.parseURIEncoded(to.getBranchUrl());

            SVNClientManager clientManager = SVNClientManager.newInstance();
            SVNDiffClient diffClient = clientManager.getDiffClient();
            SVNCommitClient commitClient = clientManager.getCommitClient();
            SVNUpdateClient updateClient = clientManager.getUpdateClient();
            updateClient.setIgnoreExternals(false);

            //updateClient.doCheckout(fromSVNURL, f, null, SVNRevision.HEAD, SVNDepth.INFINITY, false);
            updateClient.doUpdate(f, SVNRevision.HEAD, SVNDepth.INFINITY, true, true);

            diffClient.doMerge(SVNURL.parseURIEncoded(from.getBranchUrl()), SVNRevision.HEAD, SVNURL.parseURIEncoded(to.getBranchUrl()), SVNRevision.HEAD, f, SVNDepth.INFINITY, false, true, false, false);
            //commitClient.doCommit(new File[]{f}, false, comment, new SVNProperties(), null, false, true, SVNDepth.INFINITY);
        } catch (SVNException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initBranch(BranchDTO to, File f) throws MergeException {
        SVNURL toSVNURL = null;
        SVNUpdateClient updateClient = null;

        try {
            toSVNURL = SVNURL.parseURIEncoded(to.getBranchUrl());
            updateClient = SVNClientManager.newInstance().getUpdateClient();
            updateClient.doCheckout(toSVNURL, f, null, SVNRevision.HEAD, SVNDepth.INFINITY, false);
        } catch (SVNException ex){
            throw new MergeException(ex);
        }
    }
}

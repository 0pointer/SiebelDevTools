package com.boehm.siebel.deploy.development;

import com.boehm.siebel.deploy.siebel.SiebelTaskException;
import com.boehm.siebel.deploy.siebel.SingleTask.SiebelUnlockObjectTask;

public class ScaffoldingServiceImpl {
    public void unlockObject() throws SiebelTaskException{
        new SiebelUnlockObjectTask(new SifDTO()).execute();
    }
}
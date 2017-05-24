package com.boehm.siebel.deploy.siebel.SingleTask;

import com.boehm.siebel.deploy.development.SifDTO;
import com.boehm.siebel.deploy.siebel.SiebelAtomicTask;
import com.boehm.siebel.deploy.siebel.SiebelTaskException;
import com.siebel.data.SiebelException;

public class SiebelUnlockObjectTask extends SiebelAtomicTask{
    SifDTO sif;

    public SiebelUnlockObjectTask(SifDTO sif) {
        this.sif = sif;
    }

    @Override
    protected void run() throws SiebelTaskException {
        try {
            this.setFieldFalues("Repository Workflow Process", "Repository Workflow Process", "[Id]='5-1HCQEDJ'",
                    new String[]{
                        "Object Language Locked",
                            "Object Locked",
                            "Object Locked By Id",
                            "Object Locked Date"
                    }, new String[]{
                        "N",
                            "",
                            "",
                            ""
                    });
        } catch (SiebelException ex){
            throw new SiebelTaskException(ex.getMessage());
        }
    }
}
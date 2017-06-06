package com.boehm.siebel.deploy.siebel.singleTask;

import com.boehm.siebel.deploy.siebel.SiebelAtomicTask;
import com.boehm.siebel.deploy.siebel.SiebelTaskException;
import com.siebel.data.SiebelException;

public class SiebelMigrateKuendReason extends SiebelAtomicTask{
    String id;
    String reason;
    String subreason;

    public SiebelMigrateKuendReason(String id, String reason, String subreason) {
        this.id = id;
        this.reason = reason;
        this.subreason = subreason;
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
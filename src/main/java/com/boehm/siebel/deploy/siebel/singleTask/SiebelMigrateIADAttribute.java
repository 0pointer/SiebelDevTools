package com.boehm.siebel.deploy.siebel.singleTask;

import com.boehm.siebel.deploy.siebel.SiebelAtomicTask;
import com.boehm.siebel.deploy.siebel.SiebelTask;
import com.boehm.siebel.deploy.siebel.SiebelTaskException;
import com.boehm.siebel.deploy.siebel.SiebelTaskParam;

@SiebelTask(name = "Migrate IAD Attribute", description = "Adds the two missing attributes to the IAD")
public class SiebelMigrateIADAttribute extends SiebelAtomicTask {
    String orderItemId = "";

    public SiebelMigrateIADAttribute(@SiebelTaskParam(name = "", description = "") String orderItemId) {
        this.orderItemId = orderItemId;
    }

    @Override
    protected void run() throws SiebelTaskException {

    }
}

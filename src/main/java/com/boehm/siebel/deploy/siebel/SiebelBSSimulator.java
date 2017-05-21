package com.boehm.siebel.deploy.siebel;

import com.boehm.siebel.deploy.maintenance.SiebelBSServiceCallDTO;
import com.siebel.data.SiebelException;

public class SiebelBSSimulator extends SiebelAtomicTask {
    SiebelBSServiceCallDTO call;

    public SiebelBSSimulator(SiebelBSServiceCallDTO call) {
        this.call = call;
    }

    @Override
    public void run() throws SiebelTaskException {
        String[] key = new String[call.getParameter().size() - 1];
        String[] value = new String[key.length];

        try {
            this.invokeService(call.getBs(), call.getMethod(), this.getSimplePropertySet(key, value));
        } catch (SiebelException e) {
            throw new SiebelTaskException("Fehler beim Import");
        }
    }
}

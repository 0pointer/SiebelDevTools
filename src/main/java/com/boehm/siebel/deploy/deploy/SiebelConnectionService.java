package com.boehm.siebel.deploy.deploy;

import com.siebel.data.SiebelDataBean;
import com.siebel.data.SiebelException;
import com.siebel.data.SiebelPropertySet;

public abstract class SiebelConnectionService {
    protected SiebelDataBean bean = null;

    protected SiebelDataBean getBean() {
        return bean;
    }

    protected SiebelPropertySet invokeService(String serviceName, String methodName, SiebelPropertySet psIn) throws SiebelException {

        SiebelPropertySet psOut = null;
        com.siebel.data.SiebelService serv = null;

        try {
            psOut = this.getBean().newPropertySet();
            serv = this.getBean().getService(serviceName);

            serv.invokeMethod(methodName, psIn, psOut);
        } finally {
            if(serv != null){
                serv.release();
            }
        }

        return psOut;
    }

    protected SiebelPropertySet getSimplePropertySet(String[] keys, String[] values){
        SiebelPropertySet psOut = this.bean.newPropertySet();

        if(keys.length == values.length){
            for(int i = 0; i < keys.length; i++){
                psOut.setProperty(keys[i], values[i]);
            }
        }

        return psOut;
    }

    protected void login() throws SiebelException{
        if(bean == null){
            bean = new SiebelDataBean();
        } else {
            bean.logoff();
        }

        bean.login("Siebel://XXX", "xxx", "xxx");
    }

    protected void logoff() throws SiebelException{
        this.bean.logoff();
    }
}

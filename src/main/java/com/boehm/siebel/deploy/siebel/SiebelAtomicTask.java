package com.boehm.siebel.deploy.siebel;

import com.siebel.data.SiebelDataBean;
import com.siebel.data.SiebelException;
import com.siebel.data.SiebelPropertySet;

public abstract class SiebelAtomicTask {
    protected SiebelDataBean bean = null;
    private String siebelUrl;
    private String siebelUser;
    private String siebelPw;

    protected abstract void run() throws SiebelTaskException;

    protected SiebelDataBean getBean() {
        return bean;
    }

    public void setSiebelUrl(String siebelUrl) {
        this.siebelUrl = siebelUrl;
    }

    public void setSiebelUser(String siebelUser) {
        this.siebelUser = siebelUser;
    }

    public void setSiebelPw(String siebelPw) {
        this.siebelPw = siebelPw;
    }

    public void execute() throws SiebelTaskException {
        try {
            this.login();
            this.run();
            this.logoff();
        } catch (Exception ex){
            throw new SiebelTaskException(ex.getMessage());
        }
    }

    protected void login() throws SiebelException{
        if(bean == null){
            bean = new SiebelDataBean();
        } else {
            bean.logoff();
        }

        bean.login("", "", "");
    }

    protected void logoff() throws SiebelException{
        this.bean.logoff();
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
}

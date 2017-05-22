package com.boehm.siebel.deploy.siebel;

import com.siebel.data.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class SiebelAtomicTask {
    public final static int VIEW_MODE_ALL_VIEW = 3;
    public static boolean CONST_BC_FORWARD_ONLY = true;

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
        } catch (Exception ex){
            throw new SiebelTaskException(ex.getMessage());
        } finally {
            try {
                this.logoff();
            } catch (Exception ex){
                //Nothing to do her
            }
        }
    }

    protected void login() throws SiebelException {
        bean = new SiebelDataBean();
        bean.login(this.siebelUrl, this.siebelUser, this.siebelPw);
    }

    protected void logoff() throws SiebelException{
        if(this.bean != null){
            this.bean.logoff();
        }
    }

    protected Map<String, String> readFieldValues(String sBo, String sBc, String searchSpec, String[] fields) throws SiebelException {
        SiebelBusObject bo = null;
        SiebelBusComp bc = null;
        HashMap<String, String> result = new HashMap<>();

        try {
            bo = this.bean.getBusObject(sBo);
            bc = bo.getBusComp(sBc);
            bc.clearToQuery();

            for(int i = 0; i < fields.length; i++){
                bc.activateField(fields[i]);
            }

            bc.setViewMode(SiebelAtomicTask.VIEW_MODE_ALL_VIEW);
            bc.invokeMethod("SetAdminMode", new String[]{"TRUE"});
            bc.executeQuery(SiebelAtomicTask.CONST_BC_FORWARD_ONLY);

            if(bc.firstRecord()){
                for(int i = 0; i < fields.length; i++){
                    result.put(fields[i], bc.getFieldValue(fields[i]));
                }

                bc.writeRecord();
            }
        } finally {
            bc.release();
            bo.release();
        }

        return result;
    }

    protected void setFieldFalues(String sBo, String sBc, String searchSpec, String[] fields, String[] values) throws SiebelException{
        SiebelBusObject bo = null;
        SiebelBusComp bc = null;

        try {
            bo = this.bean.getBusObject(sBo);
            bc = bo.getBusComp(sBc);
            bc.clearToQuery();

            bc.setViewMode(SiebelAtomicTask.VIEW_MODE_ALL_VIEW);
            bc.invokeMethod("SetAdminMode", new String[]{"TRUE"});
            bc.executeQuery(SiebelAtomicTask.CONST_BC_FORWARD_ONLY);

            for(int i = 0; i < fields.length; i++){
                bc.activateField(fields[i]);
            }

            if(bc.firstRecord()){
                for(int i = 0; i < fields.length; i++){
                    bc.setFieldValue(fields[i], values[i]);
                }

                bc.writeRecord();
            }
        } finally {
            bo.release();
            bc.release();
        }
    }

    protected void createRecord(String sBo, String sBc, String[] fields, String[] values) throws SiebelException {
        SiebelBusObject bo = null;
        SiebelBusComp bc = null;

        try {
            bo = this.bean.getBusObject(sBo);
            bc = bo.getBusComp(sBc);

            bc.setViewMode(SiebelAtomicTask.VIEW_MODE_ALL_VIEW);
            bc.invokeMethod("SetAdminMode", new String[]{"TRUE"});
            bc.executeQuery(SiebelAtomicTask.CONST_BC_FORWARD_ONLY);

            bc.executeQuery(true);
            bc.newRecord(1);

            for(int i = 0; i < fields.length; i++){
                bc.setFieldValue(fields[i], values[i]);
            }

            bc.writeRecord();
        } finally {
            bo.release();
            bc.release();
        }
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

    protected SiebelPropertySet invokeService(String serviceName, String methodName, String[] keys, String[] values) throws SiebelException {
        return invokeService(serviceName, methodName, this.getSimplePropertySet(keys, values));
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
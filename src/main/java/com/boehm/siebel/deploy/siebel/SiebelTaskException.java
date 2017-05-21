package com.boehm.siebel.deploy.siebel;

import java.rmi.server.ExportException;

public class SiebelTaskException extends Exception{
    public SiebelTaskException(String message) {
        super(message);
    }
}

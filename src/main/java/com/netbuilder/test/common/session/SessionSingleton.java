package com.netbuilder.test.common.session;

public class SessionSingleton {

    private static Session sessionInstance;

    private SessionSingleton() {
    }

    public synchronized static Session getSession(){
        if(sessionInstance == null){
           return sessionInstance = new Session();
        }
        return sessionInstance;
    }
}

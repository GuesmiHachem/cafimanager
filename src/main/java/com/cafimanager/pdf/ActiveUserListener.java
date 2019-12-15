package com.cafimanager.pdf;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class ActiveUserListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
    	System.out.println("name : "+event.getName());
        System.out.println("value : "+event.toString());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
    	System.out.println("name : "+event.getName());
        System.out.println("value : "+event.toString());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
    	System.out.println("name : "+event.getName());
        System.out.println("value : "+event.toString());
    }

}
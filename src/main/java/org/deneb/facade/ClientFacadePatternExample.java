package org.deneb.facade;

// https://gustavopeiretti.com/patron-de-diseno-facade-en-java/

public class ClientFacadePatternExample {

    public static void main(String[] args) {

        MobileFacade facade = new MobileFacade();
        Mobile mobile = facade.on();

        System.out.println("---------------");

        facade.off(mobile);
    }
}
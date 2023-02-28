package org.example;

import java.util.logging.Logger;

class Person
{
    private static final String COM="com.api.jar";

    String name;
    String email;
    String num;
    Person(String name,String email,String num)
    {
        this.name=name;
        this.num=num;
        this.email=email;
    }
    void display()
    {
        Logger log=Logger.getLogger(COM);
        log.info("Name=");
        log.info(this.name);
        log.info("Number=");
        log.info(this.num);
        log.info("Email=");
        log.info(this.email);
        log.info("");
    }
}

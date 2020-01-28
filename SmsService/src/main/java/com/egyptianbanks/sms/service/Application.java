package com.egyptianbanks.sms.service;

import javax.xml.ws.Endpoint;

public class Application {
    public static void main(String[] args) {
        if (args.length == 2) Endpoint.publish("http://" + args[0] + ":" + args[1] + "/smsService", new SmsService());
        else {
            System.err.println("You should put your ip and port as parameters");
            System.exit(0);
        }
    }
}

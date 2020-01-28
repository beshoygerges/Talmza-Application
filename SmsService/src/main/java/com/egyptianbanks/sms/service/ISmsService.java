package com.egyptianbanks.sms.service;


import com.egyptianbanks.sms.client.SMS;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface ISmsService {

    @WebMethod
    boolean sendSMS(@WebParam(name = "SMS") SMS sms) throws Exception;

    @WebMethod
    boolean sendSMSTest(@WebParam(name = "message") String message, @WebParam(name = "to-mobile") String toMobileNumber) throws Exception;
}

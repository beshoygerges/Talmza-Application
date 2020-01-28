package com.egyptianbanks.sms.service;

import com.egyptianbanks.sms.client.SMS;
import com.egyptianbanks.sms.client.SMSServer;
import com.egyptianbanks.sms.service.util.ConfigurationLoader;
import javax.jws.WebService;
import java.rmi.Naming;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@WebService(endpointInterface = "com.egyptianbanks.sms.service.ISmsService")
public class SmsService implements ISmsService {

    private ExecutorService executorService;
    private SMSServer smsServer;
    private ConfigurationLoader loader;

    public SmsService() {
        loader = new ConfigurationLoader();
        createThreadPool();
        loadSmsServer();
    }

    private void createThreadPool() {
        executorService = Executors.newFixedThreadPool(loader.getThreadPoolSize());
    }

    private synchronized void loadSmsServer() {
        try {
            String url = getServerRMIURL();
            smsServer = (SMSServer) Naming.lookup(url);
        } catch (Exception ex) {
            System.err.println("Error while loading sms server");
            ex.printStackTrace();
        }
    }

    private String getServerRMIURL() {
        StringBuilder url = new StringBuilder("rmi://");
        return url.append(loader.getServerUrl())
                .append("/")
                .append(loader.getServerName())
                .toString();
    }

    public boolean sendSMS(SMS sms) {
        executorService.submit(new SendSmsTask(sms));
        return true;
    }

    public boolean sendSMSTest(String message, String toMobileNumber) {
        SMS sms = new SMS(message.getBytes(), 0, 0, toMobileNumber);
        sms.setSourceStation("Intern-Notification");
        executorService.submit(new SendSmsTask(sms));
        return true;
    }

    private class SendSmsTask implements Runnable {

        private final SMS sms;

        private SendSmsTask(SMS sms) {
            this.sms = sms;
        }

        public void run() {
            boolean success = false;
            int smsRetryCounter = loader.getSmsRetryCounter();

            while (!success && smsRetryCounter > 0) {
                try {
                    smsServer.sendSMS(sms);
                    success = true;
                } catch (Exception e) {
                    System.err.println("Error while sending sms");
                    loadSmsServer();
                    smsRetryCounter--;
                }
            }
        }
    }

}

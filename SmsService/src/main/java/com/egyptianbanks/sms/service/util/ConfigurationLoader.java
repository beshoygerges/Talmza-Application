package com.egyptianbanks.sms.service.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationLoader {

    private Properties prop;


    public ConfigurationLoader() {
        init();
    }

    private void init() {
        try (InputStream input = new FileInputStream("src/config/application.properties")) {
            prop = new Properties();
            prop.load(input);
        } catch (IOException ex) {
            System.err.println("Can't load Configuration file");
            System.exit(0);
        }
    }

    public String getServerUrl() {
        return prop.getProperty("sms.server.url");
    }

    public String getServerName() {
        return prop.getProperty("sms.server.name");
    }

    public int getThreadPoolSize() {
        return Integer.parseInt(prop.getProperty("thread.pool.size"));
    }

    public int getSmsRetryCounter() {
        return Integer.parseInt(prop.getProperty("sms.retry.counter"));
    }

}

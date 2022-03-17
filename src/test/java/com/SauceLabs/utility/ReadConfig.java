package com.SauceLabs.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {



    public static Properties pro;

    public ReadConfig() {
        File src = new File("./configuration/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro =new Properties();
            pro.load(fis);

        }catch(Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getApplicationURL() {
        String url = pro.getProperty("HRMURL");
        return url;
    }
    public String getusername() {
        String uname = pro.getProperty("username");
        return uname;
    }
    public String getpassword() {
        String pass = pro.getProperty("password");
        return pass;
    }

    public String getCdriver() {
        String cdriver = pro.getProperty("Chrome");
        return cdriver;
    }
    public String getFdriver() {
        String fdriver = pro.getProperty("Firefox");
        return fdriver;
    }
    public String getIEdriver() {
        String iedriver = pro.getProperty("IEbrowser");
        return iedriver;
    }
    public String getEdgeDriver() {
        String edgedriver = pro.getProperty("Edge");
        return edgedriver;
    }
    public String getLogPath(){
        String logpath = pro.getProperty("logpath");
        return logpath;
    }
    public String getclinicURL(){
        String clinicpath = pro.getProperty("clinic");
        return clinicpath;
    }
    public String getClinicUsername(){
        String username = pro.getProperty("clinic_username");
        return username;
    }
    public String getClinicpassword(){
        String password = pro.getProperty("clinic_password");
        return password;
    }
}
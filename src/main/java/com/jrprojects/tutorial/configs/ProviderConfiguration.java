package com.jrprojects.tutorial.configs;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class ProviderConfiguration {

    @Value("${urls.database}")
    private String inyectedDatabaseURL;

    @Value("${db.owner}")
    private String inyectedOwner;

    @Value("${db.corp}")
    private String inyectedCorp;

    @Value("${db.project}")
    private String inyectedProject;

    private static String databaseURL;
    private static String owner;
    private static String corp;
    private static String project;

    @PostConstruct
    public void init(){
        databaseURL = inyectedDatabaseURL;
        owner = inyectedOwner;
        corp = inyectedCorp;
        project = inyectedProject;
    }

    public static String getDatabaseURL() {
        return databaseURL;
    }

    public static String getOwner() {
        return owner;
    }

    public static String getCorp() {
        return corp;
    }

    public static String getProject() {
        return project;
    }
}

package com.jrprojects.tutorial.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UtilsProvider {

    private static final Logger logger = LoggerFactory.getLogger(UtilsProvider.class);

    private static String databaseURL;
    private static String owner;
    private static String corp;
    private static String project;

    public static void logDataBaseProperties() {
        logger.info("DB URL: " + databaseURL);
        logger.info("Owner: " + owner);
        logger.info("Corp: " + corp);
        logger.info("Project: " + project);
    }

    @Value("${urls.database}")
    public void setDatabaseURL(String databaseURL){
        UtilsProvider.databaseURL = databaseURL;
    }

    @Value("${db.owner}")
    public void setOwner(String owner){
        UtilsProvider.owner = owner;
    }

    @Value("${db.corp}")
    public void setCorp(String corp) {
        UtilsProvider.corp = corp;
    }

    @Value("${db.project}")
    public void setProject(String project) {
        UtilsProvider.project = project;
    }
}

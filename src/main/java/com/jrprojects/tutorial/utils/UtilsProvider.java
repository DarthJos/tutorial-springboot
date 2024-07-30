package com.jrprojects.tutorial.utils;

import com.jrprojects.tutorial.configs.ProviderConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilsProvider {

    private static final Logger logger = LoggerFactory.getLogger(UtilsProvider.class);

    public static void logDataBaseProperties() {
        logger.info("DB URL: " + ProviderConfiguration.getDatabaseURL());
        logger.info("Owner: " + ProviderConfiguration.getOwner());
        logger.info("Corp: " + ProviderConfiguration.getCorp());
        logger.info("Project: " + ProviderConfiguration.getProject());
    }

}

package br.com.cdi.api.lib.config;

import javax.enterprise.inject.Produces;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurantionFactory {

    @Produces
    @ConfigurationQualifier
    public Properties geProperties() throws IOException {
        InputStream streamFile = ConfigurantionFactory.class.getResourceAsStream("/lib-persistence.properties");
        Properties properties = new Properties();
        properties.load(streamFile);

        return  properties;
    }
}

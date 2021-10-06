package utilsBrowser.configuration;

import java.util.Properties;

public class Configuration {
    private String url;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public Configuration(Properties properties) {
        this.url = properties.getProperty("url");
        this.username = properties.getProperty("username");
        this.password = properties.getProperty("password");
    }
}

package com.kkalletla.hibernatetraining.HibernateUtility;

public class ConfigurationProperties {

    private String driverClass;
    private String url;
    private String userName;
    private String password;
    private String poolSize;
    private String dialect;
    private String showSQL;
    private String currentSessionContextClass;

    public ConfigurationProperties() {

    }

    public ConfigurationProperties(String driverClass, String url, String userName, String password, String poolSize, String dialect, String showSQL, String currentSessionContextClass) {
        this.driverClass = driverClass;
        this.url = url;
        this.userName = userName;
        this.password = password;
        this.poolSize = poolSize;
        this.dialect = dialect;
        this.showSQL = showSQL;
        this.currentSessionContextClass = currentSessionContextClass;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(String poolSize) {
        this.poolSize = poolSize;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getShowSQL() {
        return showSQL;
    }

    public void setShowSQL(String showSQL) {
        this.showSQL = showSQL;
    }

    public String getCurrentSessionContextClass() {
        return currentSessionContextClass;
    }

    public void setCurrentSessionContextClass(String currentSessionContextClass) {
        this.currentSessionContextClass = currentSessionContextClass;
    }

    @Override
    public String toString() {
        return "ConfigurationProperties{" +
                "driverClass='" + driverClass + '\'' +
                ", url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", poolSize='" + poolSize + '\'' +
                ", dialect='" + dialect + '\'' +
                ", showSQL='" + showSQL + '\'' +
                ", currentSessionContextClass='" + currentSessionContextClass + '\'' +
                '}';
    }
}

package net.bizare.lunchvoteapp;

public class Profiles {
    public static final String
            POSTGRES = "postgres",
            HSQLDB = "hsqldb";

    public static String getActiveDbProfile() {
        try {
            Class.forName("org.postgresql.Driver");
            return Profiles.POSTGRES;
        } catch (ClassNotFoundException ex) {
            try {
                Class.forName("org.hsqldb.jdbcDriver");
                return Profiles.HSQLDB;
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Could not resolve DB profile");
            }
        }
    }
}
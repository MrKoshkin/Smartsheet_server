package org.smartsheet;

import java.io.*;

public class Instance {
    private final static File PATH = new File("Z:\\13. FD Arc\\Кошкин С.А\\Smartsheet configuration\\config.txt");
    private static Instance instance;
    public final static String BEARER_TOKEN;
    private static String documentologUrl;
    private static String username;
    private static String password;

    static {
        String token = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            token = reader.readLine();
            documentologUrl = reader.readLine();
            username = reader.readLine();
            password = reader.readLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            BEARER_TOKEN = token;
        }
    }

    private Instance() {

    }

    public static Instance getInstance() {
        if (instance == null) {
            synchronized (Instance.class) {
                if (instance == null) {
                    instance = new Instance();
                }
            }
        }
        return instance;
    }

    public static String getDocumentologUrl() {
        return documentologUrl;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}

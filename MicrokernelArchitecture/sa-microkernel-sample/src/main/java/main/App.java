package main;


import vn.edu.ueh.bit.core.Language;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class App {
//    public static final String DEFAULT_LANGUAGE_PLUGIN_FILE_PATH = "module02/build/libs/module02-1.0-SNAPSHOT.jar";
//    public static final String JAPANESE_LANGUAGE_PLUGIN_FILE_PATH = "module03/build/libs/module03-1.0-SNAPSHOT.jar";

    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            String path = new File("src/main/resources/application.properties").getAbsolutePath();
            properties.load(new FileReader(path));
            properties.forEach((key, value) -> {
                PluginManager.loadPlugin(value.toString());
                PluginManager.get(Language.class).sayHello("Some people " + key);
            });

            /*PluginManager.loadPlugin(DEFAULT_LANGUAGE_PLUGIN_FILE_PATH);
            sayHello("nguyen van teo");

            PluginManager.loadPlugin(JAPANESE_LANGUAGE_PLUGIN_FILE_PATH);
            sayHello("than thi det");*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void sayHello(String name) {
        System.out.println(PluginManager.get(Language.class).sayHello(name));
    }
}
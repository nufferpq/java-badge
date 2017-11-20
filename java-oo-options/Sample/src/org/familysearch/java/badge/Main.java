package org.familysearch.java.badge;

import java.io.IOException;

public class Main {

    public static void main( String[] args ) {
        try{
            XMLFile xmlFile = new XMLFile("xmlfile.xml");
            ConfigFile configFile = new ConfigFile("config.cfg");
            xmlFile.appendComment("This is a comment x");
            configFile.appendComment("This is a comment a");
            xmlFile.appendComment("This is a comment y");
            configFile.appendComment("This is a comment b");
            xmlFile.appendComment("This is a comment z");
            configFile.appendComment("This is a comment c");
            configFile.close();
            xmlFile.close();
        } catch (IOException e){
            System.err.println("IOException: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}

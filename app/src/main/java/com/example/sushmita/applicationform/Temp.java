package com.example.sushmita.applicationform;

public class Temp {
    public static MyDbHandler myDbHandler;

    public static MyDbHandler getMyDbHandler() {
        return myDbHandler;
    }

    public static void setMyDbHandler(MyDbHandler myDbHandler) {
        Temp.myDbHandler = myDbHandler;
    }
}

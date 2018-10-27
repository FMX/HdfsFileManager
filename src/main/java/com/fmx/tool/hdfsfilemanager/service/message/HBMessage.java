package com.fmx.tool.hdfsfilemanager.service.message;

/**
 */
public class HBMessage {

    private TYPE type;
    private String content;
    private String user;
    private String time;
    public enum TYPE {
        MSG, ERROR, EXPECTION
    }

}

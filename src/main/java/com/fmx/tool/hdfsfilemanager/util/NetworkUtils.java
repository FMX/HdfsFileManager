package com.fmx.tool.hdfsfilemanager.util;

import org.apache.commons.net.telnet.TelnetClient;

import java.io.IOException;

/**
 */
public class NetworkUtils {

    public static boolean telnet(String host, String port) {
        TelnetClient telnetClient = new TelnetClient("VT100");
        try {
            telnetClient.connect(host, Integer.parseInt(port));
            if (telnetClient.isAvailable()) {
                telnetClient.disconnect();
                return true;
            } else return false;
        } catch (IOException e) {
            return false;
        }
    }
}

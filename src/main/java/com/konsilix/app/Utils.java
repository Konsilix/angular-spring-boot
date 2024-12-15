package com.konsilix.app;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
public class Utils {
    public static String getMyHostname() {
        try {
//            String localHost = InetAddress.getLocalHost().getCanonicalHostName();
            String localHost = InetAddress.getLocalHost().getHostName();
            log.debug(String.format("Hostname: %s", localHost));
            return localHost;
//            InetAddress localHost = InetAddress.getLocalHost();
//            if (localHost.getAddress().length == 4) { // Check for IPv4 (4 bytes)
//                String hostname = localHost.getHostName();
//                log.debug(String.format("Hostname: %s", hostname));
//                log.debug(String.format("IPv4 Address: %s", localHost.getHostAddress()));
//                return hostname;
//            } else {
//                System.err.println("No IPv4 address found.");
//            }
        } catch (UnknownHostException e) {
            log.error("failed to fetch hostname!", e);
            throw new RuntimeException("failed to fetch hostname!", e);
        }
    }
}

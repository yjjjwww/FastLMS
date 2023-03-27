package com.zerobase.fastlms.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class RequestUtils {

    public static String getClientIp(HttpServletRequest httpServletRequest) {
        String clientIp = httpServletRequest.getHeader("X-FORWARDED-FOR");
        if (clientIp == null || clientIp.length() == 0) {
            clientIp = httpServletRequest.getHeader("Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.length() == 0) {
            clientIp = httpServletRequest.getHeader("WL-Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.length() == 0) {
            clientIp = httpServletRequest.getHeader("HTTP_CLIENT_IP");
        }
        if (clientIp == null || clientIp.length() == 0) {
            clientIp = httpServletRequest.getRemoteAddr();
        }

        return clientIp;
    }

    public static String getUserAgent(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader("User-Agent");
    }
}

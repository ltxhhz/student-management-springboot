package cn.ltxhhz.springboot_demo.utils;


public class Utils {
    public static boolean verifyUser(String jwt) {
        if (jwt == null || "".equals(jwt)) {
            return false;
        }
        return !JWT.isTokenExpired(jwt);
    }
}

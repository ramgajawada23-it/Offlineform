package com.example.off2.util;

public class MaskUtil {

    public static String maskAadhaar(String aadhaar) {
        if (aadhaar == null || aadhaar.length() < 4) return "****";
        return "********" + aadhaar.substring(aadhaar.length() - 4);
    }

    public static String maskBankAccount(String account) {
        if (account == null || account.length() < 4) return "****";
        return "******" + account.substring(account.length() - 4);
    }
}

package com.hl.hw28.src.main.java.security;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CredentialUtils {
    public String[] parse(String credentialsLine) {
        String[] credentialsSegments = credentialsLine.split("\\s");
        String username = credentialsSegments[1].split("=")[1];
        String password = credentialsSegments[2].split("=")[1];
        String role = credentialsSegments[3];
        if (role.equals("-su"))
            return new String[]{username, password, "ADMIN"};
        return new String[]{username, password, "USER"};
    }

}

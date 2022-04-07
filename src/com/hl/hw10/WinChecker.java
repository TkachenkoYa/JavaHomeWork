package com.hl.hw10;

public class WinChecker {
    public boolean win(char ch, Field field) {
        char[][] data = field.getData();
        for (int i = 0; i < 3; i++) {
            if ((data[i][0] == ch && data[i][1] == ch &&
                    data[i][2] == ch) ||
                    (data[0][i] == ch && data[1][i] == ch &&
                            data[2][i] == ch)) {
                return true;
            }
        }
        if ((data[0][0] == ch && data[1][1] == ch &&
                data[2][2] == ch) ||
                (data[2][0] == ch && data[1][1] == ch &&
                        data[0][2] == ch)) {
            return true;
        }
        return false;
    }

}




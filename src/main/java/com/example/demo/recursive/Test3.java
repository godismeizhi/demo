package com.example.demo.recursive;

public class Test3 {

    /**
     * 连续字符串统计
     *
     * @param args
     */

    public static void main(String[] args) {

        String result = deal("AAAABBC");

        System.out.println(result);
    }


    public static String deal(String str) {

        if (str == null || str.length() < 2) {
            return str;
        }

        String result = "";
        int count = 1;
        for (int i = 0; i < str.length(); i++) {

            Character cur = str.charAt(i);
            Character next = null;
            if (i < str.length() - 1) {
                next = str.charAt(i + 1);
            }

            if (next == null || !cur.equals(next)) {
                result += cur;
                if (count > 1) {
                    result += count;
                }
                count = 1;
            } else {
                count++;
            }
        }

        return result;
    }

}

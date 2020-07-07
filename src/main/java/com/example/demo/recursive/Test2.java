package com.example.demo.recursive;

public class Test2 {

    /**
     * 翻转字符串
     *
     * @param args
     */
    public static void main(String[] args) {


        deal("AAVVV");
        String s = deal2("AAVVV");
        System.out.println(s);
    }


    public static void deal(String str) {

        char[] strs = str.toCharArray();

        char temp;

        for (int i = 0; i < str.length() / 2; i++) {
            temp = strs[i];
            strs[i] = strs[str.length() - (i + 1)];
            strs[strs.length - (i + 1)] = temp;
        }

        System.out.println(String.valueOf(strs));

    }

    public static String deal2(String str) {

        if (str == null || str.length() < 2) return str;

        char[] strs = str.toCharArray();
        char c = strs[0];
        String result = deal2(str.substring(1, str.length()));
        return result + c;
    }
}

package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    // searchkey: remove duplicate string
    public static StringBuffer removeDuplicateStr(StringBuffer sb) {
        StringBuffer buffer = new StringBuffer();
        if (sb.length() > 1) {
            int first = 0;
            int second = 1;
            while (second < sb.length()) {
                if (sb.charAt(first) != sb.charAt(second)) {
                    buffer.append(sb.charAt(first));
                    first = second;
                }
                second++;
            }
            buffer.append(sb.charAt(sb.length() - 1));
        } else {
            return sb;
        }
        return buffer;
    }
}

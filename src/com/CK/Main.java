package com.CK;

public class Main {

    public static void main(String[] args) {
        int result = new Solution().lengthOfLongestSubstring("ckclybxyyqsqieccych");
        System.out.println(result);
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        System.out.println(longSub(s));
        return longSub(s).length();
    }

    public static String longSub(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s;
        } else {
            int len = s.length();
            String prevLongSubString = longSub(s.substring(0, len - 1));
            if ((prevLongSubString.indexOf(s.charAt(len - 1)) < 0) && // longSub(string) does not contain the last char
                    (s.substring(0, len - 1).endsWith(prevLongSubString)) // && prevLongSubString ends with longSub(string)
            ) {
                return prevLongSubString + s.charAt(len - 1);
            } else {
                if (prevLongSubString.length() > longSub(s.substring(1, len)).length()) {
                    return prevLongSubString;
                } else {
                    return longSub(s.substring(1, len));
                }
            }
        }
    }
}



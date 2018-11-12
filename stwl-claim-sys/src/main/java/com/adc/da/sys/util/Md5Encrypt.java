package com.adc.da.sys.util;

import java.security.MessageDigest;

/**
 *
 * @author Administrator
 *
 */
public final class Md5Encrypt {

    /**
     * 私有构造器.
     */
    private Md5Encrypt() {
    }

    /**
     * 十六进制下数字到字符的映射数组.
     */
    private static final String[] HEXDIGITS = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    /** * 把inputString加密.
     * @param inputString 要加密的字符串
     * @return 加密后的字符串 */
    public static String generatePassword(String inputString) {
        return encodeByMD5(inputString);
    }

    /**
     * 验证输入的密码是否正确.
     *
     * @param password
     *            加密后的密码
     * @param inputString
     *            输入的字符串
     * @return 验证结果，TRUE:正确 FALSE:错误
     */
    public static boolean validatePassword(String password, String inputString) {
        String temp = encodeByMD5(inputString);
        return password.equals(temp);
    }

    /** 对字符串进行MD5加密 .
     * @param originString 原始字符串
     * @return 加密后字符串*/
    private static String encodeByMD5(String originString) {
        if (originString != null) {
            try {
                // 创建具有指定算法名称的信息摘要
                MessageDigest md = MessageDigest.getInstance("MD5");
                // 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
                byte[] results = md.digest(originString.getBytes());
                // 将得到的字节数组变成字符串返回
                String resultString = byteArrayToHexString(results);
                return resultString.toUpperCase();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 转换字节数组为十六进制字符串.
     *
     * @param b 字节数组
     * @return 十六进制字符串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /** 将一个字节转化成十六进制形式的字符串.
     * @param b byte
     * @return  十六进制形式字符串*/
    private static String byteToHexString(byte b) {
        final int total = 256;
        final int hexadecimal = 16;
        int n = b;
        if (n < 0) {
            n = total + n;
        }
        int d1 = n / hexadecimal;
        int d2 = n % hexadecimal;
        return HEXDIGITS[d1] + HEXDIGITS[d2];
    }
    
    public static void main(String[] args){
    	System.out.println(encodeByMD5("alexa"));
    	
    }
}

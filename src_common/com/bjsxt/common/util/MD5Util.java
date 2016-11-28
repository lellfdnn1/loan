package com.bjsxt.common.util;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;  
/**
 * 加密的工具类
 * @author Administrator
 *
 */
@Component("mD5Util")
public class MD5Util 
{
	private RegCheck regCheck = new RegCheck();
	/**
	 * md5加密
	 * @param s
	 * @return
	 */
    public final  String MD5(String s) {  
        char hexDigits[] = { '0', '1', '2', '3', '4',  
                             '5', '6', '7', '8', '9',  
                             'A', 'B', 'C', 'D', 'E', 'F' };  
        try {  
            byte[] btInput = s.getBytes();  
            //获得MD5摘要算法的 MessageDigest 对象  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            //使用指定的字节更新摘要  
            mdInst.update(btInput);  
            //获得密文  
            byte[] md = mdInst.digest();  
            //把密文转换成十六进制的字符串形式  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(str);  
        }  
        catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
    
    /**
     * md5二次加密
     * 明文：
     * 一个随机的32位的随机数字的组合+$md5$+密码
     * 数据库存的是：
     * 一个随机的32位的随机数字的组合+$md5$+MD5(一个随机的32位的随机数字的组合+$md5$+密码)
     * @param args
     */
    public String encryString(String password)
    {
    	/* 获得32位随机数 */
    	String randomStr = regCheck.getRandomStr(32);
    	/* 拼装密文 */
    	String encryPwd = randomStr+"$md5$"+password ;
    	/* 加密 */
    	encryPwd = this.MD5(encryPwd);
    	return randomStr+"$md5$"+encryPwd;
    }
    /**
     * 密码的验证
     * @param args
     */
    public boolean checkPwd(String password,String encryString)
    {
    	String[] encry = encryString.split("\\$");
    	//拼接密文
    	String encryStr = encry[0]+"$md5$"+password;
    	encryStr = encry[0]+"$md5$" + MD5(encryStr);
    	if(encryString.equals(encryStr))
    	{
    		return true;
    	}
    	return false;
    }
    
    
    public static void main(String[] args) {  
    	MD5Util md5 = new MD5Util();
/*    	for(int i=0; i<10; i++)
    	{
            System.out.println(md5.MD5("111111"));
            System.out.println(md5.encryString("111111"));
    	}
*/
    	String encryString = md5.encryString("123456");
    	System.out.println(encryString);
    	boolean checkPwd = md5.checkPwd("123456", "4tl8sfvSysM50nq1TZoGg2OGV2yIMG7L$md5$8F8DD04F8AFCE62E535C2E8FDCE16478");
    	System.out.println(checkPwd);
    }  
}  
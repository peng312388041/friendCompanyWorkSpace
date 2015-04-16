package com.e6mall.utils;

import java.security.*;

/**
 *
 * <p>Title: Unix加密算法</p>
 * <p>Description: Unix的系统的crypt()支持四种加密算法,最基础的crypt因为密钥长度和随机种子<br>
 * 太短,基本已经没有使用,目前大多数版本的linux系统中都使用md实现的加算法,但到目前为止,我能找到<br>
 * 的用java实现的crypt只有基本f的crypt()实现,即密钥长度只能是8位而随机种子只能是两位.支持md5的<br>
 * crypt()的J***A实现到目前我还没有发现,所以只好去读linux的源码,根本C的实现思想自己用java来重新<br>
 * 实现,现提供给大家.
 * </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company:e6mail.com </p>
 * @author bingzhou "bingzhou6@gmail.com"
 * @version 1.0
 */
public class UnixCrypt {

  private static final String MAGIC = "$1$";
  private static byte[] finals = new byte[16];
  private static String table =
      "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  private static char[] intToAscii64 = table.toCharArray();

  /**
   * 方法:md5_crypt(String,String)
   * @param salt:一个包含$1$的种子串,加密算法的种子特征和长度详见Unix系统加密的内容
   * @param pw:一个待加密的原始串
   * @return:返回一个加密后的随机串
   */
  public static String md5_crypt(String salt, String pw) {
    try {
      String fix = salt.substring(3);
      if (fix.length() > 8) {
        fix = fix.substring(0, 8);
      }
      int index = fix.indexOf("$");
      if (index != -1) {
        fix = fix.substring(0, index);
      }
      MessageDigest md = MessageDigest.getInstance("MD5");
      MessageDigest md1 = MessageDigest.getInstance("MD5");
      md.reset();
      md.update(pw.getBytes());
      md.update(MAGIC.getBytes());
      md.update(fix.getBytes());

      md1.reset();
      md1.update(pw.getBytes());
      md1.update(fix.getBytes());
      md1.update(pw.getBytes());
      finals = md1.digest();
      for (int i = pw.length(); i > 0; i -= 16) {
        int len = (i > 16) ? 16 : i;
            md.update(finals, 0, len);
      }
      finals = new byte[16];
      for (int j = pw.length(); j > 0; j >>= 1) {
        if ( (j & 1) > 0) {
          md.update(finals, 0, 1);
        }
        else {
          md.update(pw.getBytes(), 0, 1);
        }
      }
      StringBuffer password = new StringBuffer();
      password.append(MAGIC).append(fix).append("$");
      finals = md.digest();
      for (int k = 0; k < 1000; k++) {
        md1.reset();
        if ( (k & 1) > 0) {
          md1.update(pw.getBytes());
        }
        else {
          md1.update(finals);
        }
        if (k % 3 > 0) {
          md1.update(fix.getBytes());
        }
        if (k % 7 > 0) {
          md1.update(pw.getBytes());
        }
        if ( (k & 1) > 0) {
          md1.update(finals);
        }
        else {
          md1.update(pw.getBytes());
        }
        finals = md1.digest();
      }
      long pow24 = (long) Math.pow(2, 24);
      long pow16 = (long) Math.pow(2, 16);
      long pow8 = (long) Math.pow(2, 8);
      long l = ( (finals[0] << 16) + pow24) % pow24 |
          ( (finals[6] << 8) + pow16) % pow16 | (finals[12] + pow8) % pow8;
      crypt_i2a64(password, l, 4);
      l = ( (finals[1] << 16) + pow24) % pow24 |
          ( (finals[7] << 8) + pow16) % pow16 | (finals[13] + pow8) % pow8;
      crypt_i2a64(password, l, 4);
      l = ( (finals[2] << 16) + pow24) % pow24 |
          ( (finals[8] << 8) + pow16) % pow16 | (finals[14] + pow8) % pow8;
      crypt_i2a64(password, l, 4);
      l = ( (finals[3] << 16) + pow24) % pow24 |
          ( (finals[9] << 8) + pow16) % pow16 | (finals[15] + pow8) % pow8;
      crypt_i2a64(password, l, 4);
      l = ( (finals[4] << 16) + pow24) % pow24 |
          ( (finals[10] << 8) + pow16) % pow16 | (finals[5] + pow8) % pow8;
      crypt_i2a64(password, l, 4);
      l = (finals[11] + pow8) % pow8;
      crypt_i2a64(password, l, 2);
      finals = new byte[16];
      return new String(password);
    }
    catch (Exception e) {
      return "";
    }
  }

  /**
   * 方法:crypt_i2a64(StringBuffer,long,int)
   *
   * @param sb :一个保存返回值的StringBuffer,
   * @param v  :一个长整型数值
   * @param n  :一个整型数值,控制循环次数
   */
  private static void crypt_i2a64(StringBuffer sb, long v, int n) {
    while (--n >= 0) {
      sb.append(intToAscii64[ (int) (v & 0x3f)]);
      v >>= 6;
    }
  }
}

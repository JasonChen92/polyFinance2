package com.jnshu.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

//用于生成账户密码加密的随机盐。
public class RandomSalt {
    private static final String UCLETTER ="QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String LCLETTER ="zxcvbnmlkjhgfdsaqwertyuiop";
    private static final String NUM ="1234567890";
    private static final Character SYML[] ={'@','*','!','"','&','.',',',':','}','%','^','?','<','-','~','】','`','{'};

    public String getSalt(Integer length) {
        Random random = new Random();

        StringBuffer salt = new StringBuffer();
        for (int i=0;i<length;i++){
            int x = random.nextInt(4);

            switch (x){
                case 0:
                    salt.append(UCLETTER.charAt(random.nextInt(26)));
                    break;
                case 1:
                    salt.append(LCLETTER.charAt(random.nextInt(26)));
                    break;
                case 2:
                    salt.append(NUM.charAt(random.nextInt(10)));
                    break;
                case 3:
                    salt.append(SYML[random.nextInt(18)]);
                    break;
            }
        }
        return salt.toString();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String salt =new RandomSalt().getSalt(32);
        String passwd = "123";
        DESUtil desUtil = new DESUtil();
        String d = desUtil.encrypt(passwd, salt);
        System.out.println(salt);
        System.out.println(d);
        System.out.println(d.length());

        System.out.println(desUtil.decrypt(d, salt));
    }

}

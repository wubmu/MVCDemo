package com.wwwyb.until;

/**
 * Created by 吴亚斌 on 2017/2/10.
 */
public class demo {
    public static void main(String[] args) {
        ClassLoader cl=JdbcUtil.class.getClassLoader();
        System.out.print(cl);
    }
}

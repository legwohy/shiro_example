package com.webclient.test;

import com.webclient.utils.WebClient;

/**
 * 测试webClient
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        WebClient webClient = WebClient.getInstance();
        String rs = webClient.doGet("http://blog.csdn.net/jason0539/article/details/20899087");
        System.out.println("输出："+rs);
    }

}

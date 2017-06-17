package com.laotan.easyreader;

import org.junit.Test;

/**
 * Created by quantan.liu on 2017/6/17 0017.
 */

public class ReturnBreakContinueTest
{
    @Test
    public void ReturnBreakContinueTest() throws Exception {
        for (int i = 0; i<=10;i++){
            if (i==5)
//                continue;
//            break;
            return;
            System.out.println("i:"+i);
        }
        System.out.println("方法还在继续");
    }
}

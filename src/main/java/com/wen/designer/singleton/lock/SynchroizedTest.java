package com.wen.designer.singleton.lock;

/**
 * @program: designer
 * @description:
 * @author: wentz
 * @create: 2023-09-04 14:07
 **/
public class SynchroizedTest {


    public static Integer addOne(Integer one) {

        one++;

        System.out.println(one);
        return one;

    }

    public static void main(String[] args) {

        Integer one = 0;
        for (int i = 0; i < 100000; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
//                    one = addOne(one);
                }
            }).start();
        }
    }


}

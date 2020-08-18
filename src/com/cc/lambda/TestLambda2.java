package com.cc.lambda;

public class TestLambda2 {

    public static void main(String[] args) {


        ILove love = (int a) -> {
            System.out.println("I love you-->" + a);
        };
        love.love(2);

        //去除参数类型
        love = (a) -> {
            System.out.println("I love you-->" + a);
        };
        love.love(3);

        //去除括号
        love = a -> {
            System.out.println("I love you-->" + a);
        };
        love.love(4);

        //去除大括号
        love = a -> System.out.println("I love you-->" + a);
        love.love(5);
    }
}

interface ILove {
    void love(int a);
}

class Love implements ILove {
    @Override
    public void love(int a) {
        System.out.println("I love you1" + a);
    }
}

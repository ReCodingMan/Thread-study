package com.cc.syn;

public class UnsafeBank {

    public static void main(String[] args) {
        Account account = new Account(100,"结婚基金");
        Drawing you = new Drawing(account,50,"你");
        Drawing girlFriend = new Drawing(account,100,"girlFriend");

        you.start();
        girlFriend.start();
    }
}

class Account {
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行：模拟取款
class Drawing extends Thread {
    //账户
    Account account;
    //取了多少钱
    int drawingMoney;
    //现在手里有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        //判断有没有钱
        if (account.money-drawingMoney < 0) {
            System.out.println(Thread.currentThread().getName()+"钱不够了，取不了");
            return;
        }

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //卡内余额
        account.money = account.money - drawingMoney;
        nowMoney = nowMoney + drawingMoney;

        System.out.println(account.name+"余额为："+account.money);
        System.out.println(this.getName()+"手里的钱："+nowMoney);

    }
}

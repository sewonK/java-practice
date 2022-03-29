public class SynchronizedPractice {
    public static void main(String[] args) {
        Runnable r = new RunnableExample();
        new Thread(r).start();
        new Thread(r).start();
    }
}

class Account {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

//    non-synchronized 함수
//    public void withdraw(int money) {
//        if(balance >= money) {
//            try { Thread.sleep(1000);} catch(InterruptedException e) {}
//            balance -= money;
//        }
//    }

//    1. 메서드 전체를 임계 영역으로 지정
//    public synchronized void withdraw(int money) {
//        if(balance >= money) {
//            try { Thread.sleep(1000);} catch(InterruptedException e) {}
//            balance -= money;
//        }
//    }
//

//  2. 특정한 영역을 임계 영역으로 지정
    public void withdraw(int money) {
        synchronized (this) {
            if (balance >= money) {
                try {Thread.sleep(1000);} catch (InterruptedException e) {}
                balance -= money;
            }
        }
    }
}

class RunnableExample implements Runnable {
    Account acc = new Account();

    public void run() {
        while(acc.getBalance() > 0) {
            int money = (int)(Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance:"+acc.getBalance());
        }
    }
}

package com.dongnaoedu.waitnotify;

/**
 */
public class TestUser {

    private static User user = new User(30,User.CITY);

    private static class CheckAge extends Thread{
        @Override
        public void run() {
            user.waitAge();
        }
    }

    private static class CheckCity extends Thread{
        @Override
        public void run() {
            user.waitCity();
        }
    }

    public static void main(String[] args) throws InterruptedException {
/*        for(int i=0;i<3;i++){
            //启动三个等待用户年龄变化的线程
            new CheckAge().start();
        }*/
/*        for(int i=0;i<3;i++){
            //启动三个等待用户城市变化的线程
            new CheckCity().start();
        }*/
//        Thread.sleep(10000);
    	 new CheckAge().start();
    	Thread.sleep(5000);
//        user.changeCity();//变动用户的城市
    	user.changeAge();
        System.out.println(Thread.currentThread().getName());
//        System.exit(0);
    }

}

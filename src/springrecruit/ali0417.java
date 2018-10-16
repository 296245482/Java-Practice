package springrecruit;

public class ali0417 {
    public static void main(String[] args) {
        final User user1 = new User();
        user1.setID("1");
        user1.setMoney(1000);

        final User user2 = new User();
        user2.setID("2");
        user2.setMoney(1000);

        final ali0417 ali = new ali0417();

        Runnable run = new Runnable() {
            public void run() {
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
                ali.transfer(user1, user2, 1);
            }
        };

        for(int i=0; i<1; i++){
            new Thread(run).start();
        }
    }

    private synchronized boolean transfer(User fromUser, User toUser, double money){
        if(money > fromUser.getMoney())
            return false;
        double rowMoney = fromUser.getMoney();
        fromUser.setMoney(fromUser.getMoney() - money);
        try{
            toUser.setMoney(toUser.getMoney() + money);
        }catch(Exception e){
            fromUser.setMoney(rowMoney);
            return false;
        }
        System.out.println(fromUser.getMoney()+":"+toUser.getMoney());
        return true;
    }

}
class User{
    private String ID;
    private double money;
    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }
}

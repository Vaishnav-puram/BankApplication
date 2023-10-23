package MainBank;

public class Bank {
    static int idcounter=1000;
    private int id;
    private String name;
    private String acc;
    private double bal;

    public Bank(String name, String acc, double bal) {
        this.id = idcounter++;
        this.name = name;
        this.acc = acc;
        this.bal = bal;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAcc() {
        return acc;
    }

    public double getBal() {
        return bal;
    }

    public Locker getLocker() {
        return locker;
    }

    private Locker locker;


    public void assignLocker(int duration){
        this.locker=new Locker(duration);
    }

    private class Locker{
        static int locCounter=100;
        private int locid;
        private int duration;
        private double charges;
        static double cost=2000;

        public Locker(int duration) {
            this.locid = locCounter++;
            this.duration = duration;
            this.charges=cost*this.duration;
        }

        public int getLocid() {
            return locid;
        }

        public int getDuration() {
            return duration;
        }

        public double getCharges() {
            return charges;
        }

    }
    public void transferMoney(Bank b,int amt){
        if(this.bal<amt){
            System.out.println("Insufficient balance !");
            return;
        }
        this.bal-=amt;
        b.bal+=amt;
    }


    @Override
    public String toString() {
       if (this.locker==null){
           return "ACCno: "+this.getId()+"\n"+"Customer: "+this.getName()+"\n"+"ACCType: "+this.getAcc()+"\n"+"Balance: "+this.getBal()+"\n"+"Locker Status: Not Assigned Yet.";
       }
        return "ACCno: "+this.getId()+"\n"+"Customer: "+this.getName()+"\n"+"ACCType: "+this.getAcc()+"\n"+"Balance: "+this.getBal()+"\n"+"Locker Status: "+"Locker id: "+this.locker.getLocid()+" "+"Locker duration :"+this.locker.getDuration()+" "+"Locker charges: "+this.locker.getCharges();
    }
}

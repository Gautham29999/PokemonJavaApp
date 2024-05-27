import java.util.Random;
public abstract class Move {
    private String name;
    private int atkValue;
    private int type;
    private int pp;
    private int accuracy;
    private int status;
    private String description;

    public Move(String name, int type,int atkValue, int pp, int accuracy, int status, String description){
        this.name = name;
        this.atkValue = atkValue;
        this.type = type;
        this.pp = pp;
        this.accuracy = accuracy;
        this.status = status;
        this.description = description;
    }

    public Move(Move base){
        this.name = base.name;
        this.atkValue = base.atkValue;
        this.pp = base.pp;
        this.accuracy = base.accuracy;
    }

    public abstract void attack(Pokemon attacker, Pokemon defender);
    public static int randomizer(){
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        return randomNumber;
    }
    public boolean checkAccuracy(int accuracy){
        if (randomizer() <= accuracy){
            return true;
        }
        else {
            return false;
        }
    }

    public void printMove(){
        System.out.println(name + ": " + description);
    }

    public boolean canAtk(Pokemon attacker){
        if (attacker.getStatus() == 2) {
            attacker.reduceStatusTimer();
            System.out.println(attacker.getName() + " is frozen!!!");
            return false;

        } else if (attacker.getStatus() == 3) {
            attacker.reduceStatusTimer();
            if (randomizer() <= 35) {
                System.out.println(attacker.getName() + " can't move, it's paralyzed!!!");
                return false;
            }
        }
        if (checkAccuracy(this.getAccuracy())){
             return true;
        }
        System.out.println(attacker.getName()+ " missed!!!");
        return false;
    }
    public String getName(){return name;}
    public int getAtkValue(){return atkValue;}
    public int getPp(){return pp;}
    public int getAccuracy(){return accuracy;}
    public int getStatus(){return status;}
    public int getType(){return type;}
    public String getDescription(){return description;}

    public void setName(String name) { this.name = name; }
    public void setType(int type) {this.type = type;}
    public void setAtkValue(int atkValue) { this.atkValue = atkValue; }
    public void setPp(int pp) { this.pp = pp; }
    public void setAccuracy(int accuracy) { this.accuracy = accuracy; }
    public void setStatus(int status) {this.status = status;}

}

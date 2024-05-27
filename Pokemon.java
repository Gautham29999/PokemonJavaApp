import java.util.Scanner;
public class Pokemon {
    private String name;
    private int type; // 1 - Fire, 2 - Water, 3 - Plant, 4 - Flying, 5 - Lightning, 6 - Ground.
    private int hp;
    private int maxHp;
    private int speed;
    private double atk;
    private double def;
    private Move move1;
    private Move move2;
    private Move move3;
    private Move move4;
    private int status; // 1- burn, 2 - freeze, 3 - paralysis
    private int statusTimer; // 10 -burn, 2 - freeze, 4 - paralysis

    /*
    * Fire is strong against Plant and Flying, but weak against Water and Ground.
    Water is strong against Fire and Ground, but weak against Plant and Lightning.
    Plant is strong against Water and Lightning, but weak against Fire and Flying.
    Flying is strong against Plant and Ground, but weak against Fire and Lightning.
    Lightning is strong against Water and Flying, but weak against Plant and Ground.
    Ground is strong against Fire and Lightning, but weak against Water and Flying.
    * */


    public Pokemon(String name,int type, int hp, int speed, double atk, double def) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.maxHp =hp;
        this.speed = speed;
        this.atk = atk;
        this.def = def;
        this.status = 0;
    }
    public Pokemon(Pokemon base){
        this.name = base.name;
        this.type = base.type;
        this.hp = base.hp;
        this.maxHp =base.maxHp;
        this.speed = base.speed;
        this.atk = base.atk;
        this.def = base.def;
        this.status = 0;

    }
    public int turn(int move){
        if (move == 1){
            this.getMove1().setPp(this.getMove1().getPp() - 1);
            return this.getMove1().getAtkValue();

        } else if (move == 2){
            this.getMove2().setPp(this.getMove2().getPp() - 1);
            return this.getMove1().getAtkValue();
        } else if (move == 3){
            this.getMove3().setPp(this.getMove3().getPp() - 1);
            return this.getMove3().getAtkValue();
        } else if (move == 4){
            this.getMove4().setPp(this.getMove4().getPp() - 1);
            return this.getMove3().getAtkValue();
        } else {
            return 0;
        }

    }
    public double atkDefMultiplier(){
        return(atk/def);
    }

    public void checkTurnStatus(){
        if(status == 1){
            this.hp = this.hp - (int)(this.maxHp*0.10);
        }
    }
    public String getName() {
        return name;
    }
    public int getType(){return type;}
    public int getHp() {
        return hp;
    }
    public double getAtk(){return atk;}
    public double getDef(){return def;}

    public Move getMove1() {
        return move1;
    }
    public Move getMove2() {
        return move2;
    }
    public Move getMove3() {
        return move3;
    }
    public Move getMove4() {
        return move4;
    }
    public int getSpeed(){
        return speed;
    }

    public int getMaxHp(){return maxHp;}
    public int getStatus(){ return status;}
    public void setStatus(int newStatus){status = newStatus;}
    public void setHp(int newHp){hp = newHp;}
    public void setSpeed(int newSpeed){ speed = newSpeed;}
    public void setAtk (double newAtk){atk = newAtk;}
    public void setDef (double newDef){atk = newDef;}

    public int getStatusTimer() {return statusTimer;}

    public void setStatusTimer(int time){statusTimer = time;}
    public void reduceStatusTimer(){statusTimer--;}


    public void setMove1(Move move1){
        this.move1 = move1;
    }
    public void setMove2(Move move2){
        this.move2 = move2;
    }
    public void setMove3(Move move3){
        this.move3 = move3;
    }
    public void setMove4(Move move4){
        this.move4 = move4;
    }

    public void printMoves(){
        System.out.println("1. " + move1.getName() + "(" + move1.getPp()+ "): " + move1.getDescription());
        System.out.println("2. " + move2.getName() + "(" + move2.getPp()+ "): " + move2.getDescription());
        System.out.println("3. " + move3.getName() + "(" + move3.getPp()+ "): " + move3.getDescription());
        System.out.println("4. " + move4.getName() + "(" + move4.getPp()+ "): " + move4.getDescription());
    }

    // Special attack 1: Burn, 2: Freeze, 3: Paralysis, 4: Poison, 5:Heal , 6: Boost speed, 7: Boost atk, 8: Boost Def, 9: Boost speed, 10: Boost atk, 11: Boost Def 12: Steal Life
    public void checkStatus(){
        if (this.status == 1){
            System.out.println(this.name + " is burnt");
            this.hp = (this.hp - (int)(this.maxHp * 0.10));
            this.reduceStatusTimer();
        } else if (this.status == 4) {
            System.out.println(this.name + " is poisoned");
            this.hp = (this.hp - (int) (this.maxHp * 0.05));
            this.reduceStatusTimer();
        }
        if (this.statusTimer <= 0){
            this.statusTimer = 0;
            this.status  = 0;
        }
    }

    public Move selectMove(int choice){
        while (choice < 1 || choice > 4){
            System.out.println("Invalid Move choice, please select the int between 1 - 4: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
        }
        if (choice == 1){
            move1.setPp(move1.getPp()-1);
            return move1;
        } else if (choice == 2){
            move2.setPp(move2.getPp()-1);
            return move2;
        } else if (choice == 3){
            move3.setPp(move3.getPp()-1);
            return move3;
        } else if (choice == 4){
            move4.setPp(move4.getPp()-1);
            return move4;
        } else {
            return null;
        }
    }
}

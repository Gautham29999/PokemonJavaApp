public class SpecialMove extends Move{
    public SpecialMove(String name, int type, int atkValue, int pp,int accuracy, int status, String description){ super(name, type, atkValue,pp,accuracy, status,description);}

    @Override
    public void attack(Pokemon attacker, Pokemon defender){
        // Special attack 1: Burn, 2: Freeze, 3: Paralysis, 4: Poison, 5:Heal , 6: Boost speed, 7: Boost atk, 8: Boost Def, 9: Boost speed, 10: Boost atk, 11: Boost Def 12: Steal Life
        attacker.checkStatus();
        System.out.println(attacker.getName() + " used " + this.getName());
        if (canAtk(attacker)){
            if(this.getStatus() == 1){
                defender.setStatus(1);
                defender.setStatusTimer(5);
                System.out.println(attacker.getName() + " burnt " + defender.getName());
            } else if (this.getStatus()==2){
                defender.setStatus(2);
                defender.setStatusTimer(2);
                System.out.println(attacker.getName() + " froze " + defender.getName());
            }else if (this.getStatus() == 3){
                defender.setStatus(3);
                defender.setStatusTimer(5);
                System.out.println(attacker.getName() + " paralyzed " + defender.getName());
            } else if (this.getStatus()==4){
                defender.setStatus(4);
                defender.setStatusTimer(10);
                System.out.println(attacker.getName() + " poisoned " + defender.getName());
            } else if(this.getStatus() == 5){// Heal
                attacker.setHp((int)(attacker.getHp()*1.5));
                System.out.println(attacker.getName() + " healed itself!!!");
            } else if(this.getStatus() == 6){// Speed Boost
                attacker.setSpeed((int)(attacker.getSpeed()*1.5));
                System.out.println(attacker.getName() + " increased it's speed!!!");
            } else if (this.getStatus() == 7){ // Atk Boost
                attacker.setAtk((int)(attacker.getAtk()*1.5));
                System.out.println(attacker.getName() + " increased it's attack!!!");
            } else if (this.getStatus() == 8){ // Def Boost
                attacker.setDef((int)(attacker.getDef()*1.5));
                System.out.println(attacker.getName() + " increased it's defence!!!");
            } else if(this.getStatus() == 9){// Speed Reduce
                defender.setSpeed((int)(attacker.getSpeed()*0.5));
                System.out.println(defender.getName() + "'s speed decreased");
            } else if (this.getStatus() == 10){ // Atk Reduce
                defender.setAtk((int)(attacker.getAtk()*0.5));
                System.out.println(defender.getName() + "'s attack decreased");
            } else if (this.getStatus() == 11){ // Def Reduce
                defender.setDef((int)(attacker.getDef()*0.5));
                System.out.println(defender.getName() + "'s defence decreased");
            } else if (this.getStatus()==12){
                if(((int)(defender.getMaxHp()*0.25) + attacker.getHp()) >= attacker.getMaxHp()){
                    System.out.println(attacker.getName() + " healed up all its HP");
                } else {
                    attacker.setHp(((int)(defender.getMaxHp()*0.25) + attacker.getHp()));
                }
                defender.setHp(defender.getHp() - (int)(defender.getMaxHp()*0.25));
            }
        }
    }
}
/*
*  else if (this.getStatus() == 9){
                defender.setStatus(9);// BLOCKed
            } */
public class NormalMove extends Move{
    public NormalMove(String name, int type, int atkValue, int pp, int accuracy, int status, String description) {
        super(name, type, atkValue, pp, accuracy, status,description);
    }

    @Override
    public void attack(Pokemon attacker, Pokemon defender){
        System.out.println(attacker.getName() + " used " + this.getName() + "!!!");
        attacker.checkStatus();
        if(canAtk(attacker)){
            int dmgDealt = (int)(this.getAtkValue()* ((this.typeMultiplier(defender.getType()))));
            System.out.println("It dealt " + dmgDealt + " hp!!!");
            defender.setHp(defender.getHp()-dmgDealt);
        }
    }

    public double typeMultiplier( int defenderType){
        double multiplier = 1;
        int [][] weaknesses = {{2,6},{3,5},{1,4},{1,5},{3,6},{2,4}};
        int [][] strengths = {{3,4},{1,6},{2,5},{3,6},{2,4},{1,5}};

        if (weaknesses[(this.getType()-1)][0] == defenderType || weaknesses[(this.getType()-1)][1] == defenderType){
            multiplier = 0.5;
            System.out.println( this.getName() + " is not effective!!!");
        }  else if (strengths[(this.getType()-1)][0] == defenderType || strengths[(this.getType()-1)][1] == defenderType){
            multiplier = 2;
            System.out.println(this.getName() + " is super effective!!!");
        }
        return multiplier;
    }
}

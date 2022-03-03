package u9pp.MonsterFighter;

class Monster extends Combatant{
    //instances
    private int exp;

    //constructor
    public Monster(String name, int maxH, int atk, int expE){
        super(name, maxH, atk);
        if(expE < 0){
            exp = 0;
        }else{
            exp = expE;
        }
    }

    public int getExpGiven(){
        return exp;
    }

    public String takeTurn(Combatant target){
        target.getAttacked(this.getAttackPower());
        return this.getName() + " " + target.getName() + ", with " + this.getAttackPower() + " attackPower";
    }
}



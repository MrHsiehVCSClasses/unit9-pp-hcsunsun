package u9pp.MonsterFighter;

class HealingMonster extends Monster{
    //instance
    private int heal;

    //constructor
    public HealingMonster(String name, int maxH, int atk, int expE, int toHeal){
        super(name, maxH, atk, expE);
        heal = toHeal;
    }

    public String takeTurn(Combatant target){
        this.heal(this.getHealingPerTurn());
        return super.takeTurn(target)+ ", healed " + getHealingPerTurn();
    }

    public int getHealingPerTurn(){
        return heal;
    }
}

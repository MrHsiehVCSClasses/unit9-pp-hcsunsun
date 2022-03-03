package u9pp.MonsterFighter;

class SlowMonster extends Monster{

    //instances
    private int atkOnEven;

    //constructor
    public SlowMonster(String name, int maxH, int atk, int expE){
        super(name, maxH, atk, expE);
        atkOnEven = 0;
    }

    //methods
    public String takeTurn(Combatant target){
        atkOnEven++;
        if(atkOnEven % 2 == 0){
            return super.takeTurn(target);
        }
        return this.getName() + " is sleeping";
    }
}


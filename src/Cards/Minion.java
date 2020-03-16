package Cards;
import Heroes.HeroClass;

public class Minion extends card {
    private long HP ;
    private long Attack;

    public long getHP() {
        return HP;
    }
    public void setHP(long HP) {
        this.HP = HP;
    }
    public long getAttack() {
        return Attack;
    }
    public void setAttack(long attack) {
        Attack = attack;
    }

    public Minion(long manaCost, String name, String description, card.rarity rarity, HeroClass heroClass, card.type type, long HP, long Attack) {
        super(manaCost, name, description, rarity, heroClass, type);
        this.HP = HP;
        this.Attack = Attack;
    }

    @Override
    public String toString() {
        return super.toString().substring(0,super.toString().indexOf("}")) + ", HP  : "+ this.HP + ", Attack : "+ this.Attack + " } *";
    }
}

package Cards;
import Heroes.HeroClass;

public class Weapon extends card{
    private long durability,Attack;

    Weapon(long manaCost, String name, String description, card.rarity rarity, HeroClass heroClass, card.type type , long durability, long Attack) {
        super(manaCost, name, description, rarity, heroClass, type);
        this.durability = durability;
        this.Attack = Attack;
    }
    @Override
    public String toString() {
        return super.toString().substring(0,super.toString().indexOf("}")) + ", durability  : "+ this.durability + ", Attack : "+ this.Attack + " } *";
    }
}

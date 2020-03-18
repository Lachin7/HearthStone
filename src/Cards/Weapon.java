package Cards;
import com.google.gson.annotations.Expose;

public class Weapon extends card{
    @Expose private long durability,Attack;

    public Weapon(int manaCost, String name, String description, card.rarity rarity, HeroClass heroClass, card.type type,int price, int durability, int Attack) {
        super(manaCost, name, description, rarity, heroClass, type , price);
        this.durability = durability;
        this.Attack = Attack;
    }
//    @Override
//    public String toString() {
//        return super.toString().substring(0,super.toString().indexOf("}")) + ", durability  : "+ this.durability + ", Attack : "+ this.Attack + " } *";
//    }
}

package Cards;

public class Weapon extends card{
    int durability;

    Weapon(int manaCost, String name, String description, card.rarity rarity, card.heroClass heroClass, card.type type , int durability) {
        super(manaCost, name, description, rarity, heroClass, type);
        this.durability = durability;
    }
}

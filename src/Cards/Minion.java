package Cards;

public class Minion extends card {
    int HP ;
    int Attack;

    Minion(int manaCost, String name, String description, card.rarity rarity, card.heroClass heroClass, card.type type, int HP , int Attack) {
        super(manaCost, name, description, rarity, heroClass, type);
        this.HP = HP;
        this.Attack = Attack;
    }


}

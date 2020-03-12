package Cards;

import java.util.ArrayList;

public class Spell extends card {
    String QuestReward ;
    Spell(int manaCost, String name, String description, rarity rarity, heroClass heroClass, type type , String QuestReward) {
        super(manaCost, name, description, rarity, heroClass, type);
        this.QuestReward = QuestReward;
    }

    ArrayList SpellCards = new ArrayList();

    static Spell Polymorph = new Spell(4,"Polymorph", "Transform minion in to 1/1 sheep",
                          card.rarity.RARE, card.heroClass.MAGE, card.type.SPELL,"");

//    public card TransformMinionTo1_1Sheep(Minion minion){
//        return Sheep;
//    }

   //

    public static void main(String[] args) {
        System.out.println(Polymorph.rarity);
    }

    //Quest and reward
}

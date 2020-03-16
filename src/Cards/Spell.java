package Cards;
import Heroes.HeroClass;

public class Spell extends card {
    private String Quest , Reward ;
    public Spell(long manaCost, String name, String description, rarity rarity, HeroClass heroClass, type type, String Quest, String Reward) {
        super(manaCost, name, description, rarity, heroClass, type);
        this.Quest=Quest;
        this.Reward=Reward;
    }

    @Override
    public String toString() {
        return super.toString().substring(0,super.toString().indexOf("}")) + ", Quest : "+ this.Quest + ", Reward : "+ this.Reward + " } *";
    }
}

package Cards;

public class card {
    int manaCost ;
    public int getManaCost() {
        return manaCost;
    }
    public void setManaCost(int mana) {
        manaCost = mana;
    }

    String name;
    public String getNameame() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    static rarity rarity;
    static heroClass heroClass;
    static type type;

    public enum rarity {
        COMMON,RARE,EPIC,LEGENGARY

    }
    public enum heroClass{
        MAGE,ROGUE,WARLOCK,NEUTRAL
    }
    public enum type {
        MINION,SPELL, WEAPON
    }

    card(int manaCost, String name,String description, rarity rarity, heroClass heroClass,type type){
        this.manaCost = manaCost;
        this.name = name;
        this.description = description;
        this.rarity = rarity;
        this.heroClass = heroClass;
        this.type = type;
    }



}

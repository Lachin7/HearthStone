package Cards;
import Heroes.HeroClass;

public class card {
    /** defining fields here */
    private long manaCost ;
    private String name , description;
    private static rarity rarity;
    private type type;
    private HeroClass heroClass;
    /** defining getters and setters here */
    public long getManaCost() {
        return manaCost;
    }
    public void setManaCost(long mana) {
        manaCost = mana;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public HeroClass getHeroClass() {
        return this.heroClass;
    }
    public void setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
    }
    public card.type getType() {
        return type;
    }
    public void setType(card.type type) {
        this.type = type;
    }
    /** defining relevant enums and classes here */
    public enum rarity {
        COMMON,RARE,EPIC,LEGENGARY

    }

    public enum type {
        MINION,SPELL, WEAPON
    }
    /** defining constructor here */
    card(long manaCost, String name, String description, rarity rarity, HeroClass heroClass, type type){
        this.manaCost = manaCost;
        this.name = name;
        this.description = description;
        this.rarity = rarity;
        this.heroClass = heroClass;
        this.type = type;
    }
    /** defining methods here */
    @Override
    public String toString() {
         return "* {   Card name : "+ this.name + ", mana Cost : "+ this.manaCost + ", hero Calss : " + this.heroClass + ", type : " + this.type + ", rarity : " + this.rarity + ", description : " + this.description + "} * ";
    }
    public Long getCardCost(card card){
        if(card.rarity == Cards.card.rarity.COMMON){
            return new Long(5);
        }
        if(card.rarity == Cards.card.rarity.RARE){
            return new Long(10);
        }
        if(card.rarity == Cards.card.rarity.EPIC){
            return new Long(15);
        }
        if(card.rarity == Cards.card.rarity.LEGENGARY){
            return new Long(20);
        }
        else
            return new Long(0);
    }
}

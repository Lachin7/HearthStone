package Heroes;

public class HeroClass extends Hero {
    public Mage MAGE = Mage.getInstance();
    public Rogue ROGUE = Rogue.getInstance();
    public Warlock WARLOCK = Warlock.getInstance();
    public Neutral NEUTRAL = Neutral.getInstance();

    public static HeroClass valueOf(String heroClass) {
        if(heroClass.equalsIgnoreCase("Mage")){
            return  Mage.getInstance();
        }
        if(heroClass.equalsIgnoreCase("Rogue")){
            return Rogue.getInstance();
        }
        if(heroClass.equalsIgnoreCase("Warlock")){
            return  Warlock.getInstance();
        }
        if(heroClass.equalsIgnoreCase("Neutral")){
            return Neutral.getInstance();
        }
        return null;

    }
}

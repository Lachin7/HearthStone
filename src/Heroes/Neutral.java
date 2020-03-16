package Heroes;

public class Neutral extends HeroClass {

    static Neutral Neutral = new Neutral();

    public Neutral() {
    }

    public static Neutral getInstance(){
        return Neutral;
    }

}

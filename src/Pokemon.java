public abstract class Pokemon {
    private final String name;
    private final int level;
    private int hp;
    private final String food;
    private final String sound;
    private final int maxHp;

    public Pokemon(String name, int level, int hp, String food, String sound) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.food = food;
        this.sound = sound;
        this.maxHp = hp;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getFood() {
        return food;
    }

    public String getSound() {
        return sound;
    }

    public void feedPokemon() {
        this.hp = Math.min(this.hp + 30, maxHp); //controleert of het toevoegen van 30 hp de maximale hp overschrijdt
    }

    public void throwFood(String food) {
        if (this.food.equalsIgnoreCase(food) || this.food.equalsIgnoreCase("everything")){
            System.out.printf("%s eagerly devours its favorite food, its spirits lifted and energy renewed by the delicious treat. %s, and gets %shp boost %n",
                    this.getName(), this.getSound(), Main.ANSI_GREEN + 30 + Main.ANSI_RESET);
            this.feedPokemon();
        } else {
            System.out.printf("%s shakes its head in refusal if it doesn't like the food, displaying its displeasure with the offered treat.",
                    this.getName());
        }
    };

    public abstract String getType();
}

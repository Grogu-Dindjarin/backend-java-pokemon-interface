import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GrassPokemon extends Pokemon{
    private final List<String> attacks = Arrays.asList("leafStorm", "solarBeam", "leechSeed", "leaveBlade");
    private final HashMap<String, Integer> typeAttackMultipliers = new HashMap<>();

    public GrassPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound);
        this.typeAttackMultipliers.put("electric", 4);
        this.typeAttackMultipliers.put("grass", 1);
        this.typeAttackMultipliers.put("fire", 3);
        this.typeAttackMultipliers.put("water", 2);
    }

    @Override
    public String getType() {
        return "grass";
    }

    public List<String> getAttacks() {
        return attacks;
    }

    private int calculateDamage(int baseDamage, int opponentMultiplier) {
        return baseDamage * opponentMultiplier;
    }

    private int getOpponentMultiplier(Pokemon enemy, HashMap<String, Integer> multipliers) {
        return multipliers.get(enemy.getType());
    }

    public void leafStorm(Pokemon pokemon, Pokemon enemy) {
        int baseDmg = 15;
        int leafStormDmg = calculateDamage(baseDmg, getOpponentMultiplier(enemy, typeAttackMultipliers));

        int pokemonEnemyHp = enemy.setHp(enemy.getHp() - leafStormDmg);
        System.out.printf("%s! Whoosh! leaves swirl and dance around with a loud whoosh, enveloping %s in a tempest of nature's fury. Leafstorm deals -%sdmg to %s, %s has %shp left %n",
                pokemon.getSound(), enemy.getName(), Main.ANSI_RED + leafStormDmg + Main.ANSI_RESET, enemy.getName(), enemy.getName(), Main.ANSI_BLACK + pokemonEnemyHp + Main.ANSI_RESET);
    }

    public void solarBeam(Pokemon pokemon, Pokemon enemy) {
        int baseDmg = 20;
        int leafStormDmg = calculateDamage(baseDmg, getOpponentMultiplier(enemy, typeAttackMultipliers));

        int pokemonEnemyHp = enemy.setHp(enemy.getHp() - leafStormDmg);
        System.out.printf("%s! %s gathers solar energy with its flower on its back and then fires a powerful beam of sunlight at %s. Solar beam deals -%sdmg to %s, %s has %shp left %n",
                pokemon.getSound(), pokemon.getName(), enemy.getName(), Main.ANSI_RED + leafStormDmg + Main.ANSI_RESET, enemy.getName(), enemy.getName(), Main.ANSI_BLACK + pokemonEnemyHp + Main.ANSI_RESET);
    }

    public void leechSeed(Pokemon pokemon, Pokemon enemy) {
        int baseDmg = 13;
        int leechSeedDmg = calculateDamage(baseDmg, getOpponentMultiplier(enemy, typeAttackMultipliers));
        int enemyHp = enemy.setHp(enemy.getHp() - leechSeedDmg);
        pokemon.setHp(pokemon.getHp() + leechSeedDmg);

        System.out.printf("%s's Leech Seed saps %s's vitality draining %shp weakening the other Pokémon while replenishing %s's own strength with %shp. %s has %shp left %n",
                pokemon.getName(), enemy.getName(), Main.ANSI_RED + leechSeedDmg + Main.ANSI_RESET ,pokemon.getName(), Main.ANSI_GREEN + leechSeedDmg  +  Main.ANSI_RESET, enemy.getName(),  Main.ANSI_BLACK + enemyHp + Main.ANSI_RESET);
    }

    public void leaveBlade(Pokemon pokemon, Pokemon enemy) {
        int baseDmg = 9;
        int leaveBladeDmg = calculateDamage(baseDmg, getOpponentMultiplier(enemy, typeAttackMultipliers));

        int pokemonEnemyHp = enemy.setHp(enemy.getHp() - leaveBladeDmg);
        System.out.printf("%s! %s's leaves glow with energy as it swiftly slashes %s with razor-sharp blades! SLASH! Leaf Blade deals -%sdmg to %s, %s has %shp left %n",
                pokemon.getSound(), pokemon.getName(), enemy.getName(), Main.ANSI_RED + leaveBladeDmg + Main.ANSI_RESET, enemy.getName(), enemy.getName(), Main.ANSI_BLACK + pokemonEnemyHp + Main.ANSI_RESET);
    }
}

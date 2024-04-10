import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FirePokemon extends Pokemon {
    private final List<String> attacks = Arrays.asList("inferno", "pyroBall", "fireLash", "flameThrower");
    private final HashMap<String, Integer> typeAttackMultipliers = new HashMap<>();

    public FirePokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound);
        this.typeAttackMultipliers.put("electric", 2);
        this.typeAttackMultipliers.put("grass", 4);
        this.typeAttackMultipliers.put("fire", 1);
        this.typeAttackMultipliers.put("water", 3);
    }

    public void throwFood(String food) {

    }

    public String getType() {
        return "fire";
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

    void inferno(Pokemon pokemon, Pokemon enemy) {
        int baseDmg = 9;
        int infernoDmg = calculateDamage(baseDmg, getOpponentMultiplier(enemy, typeAttackMultipliers));

        enemy.setHp(enemy.getHp() - infernoDmg);
        System.out.printf("%s! Whoosh! CRACK! inferno deals -%sdmg to %s, %s has %shp left %n",
                pokemon.getSound(), Main.ANSI_RED + infernoDmg + Main.ANSI_RESET, enemy.getName(), enemy.getName(), Main.ANSI_BLACK + enemy.getHp() + Main.ANSI_RESET);
    }

    void pyroBall(Pokemon pokemon, Pokemon enemy) {
        int baseDmg = 12;
        int infernoDmg = calculateDamage(baseDmg, getOpponentMultiplier(enemy, typeAttackMultipliers));

        enemy.setHp(enemy.getHp() - infernoDmg);
        System.out.printf("%s Swoosh! The Pyro Ball ignites with blazing fury! %s loses %shp, %s has %shp left %n",
                pokemon.getSound(), enemy.getName(), Main.ANSI_RED + infernoDmg + Main.ANSI_RESET, enemy.getName(), Main.ANSI_BLACK + enemy.getHp() + Main.ANSI_RESET);

    }

    void fireLash(Pokemon pokemon, Pokemon enemy) {
        int baseDmg = 15;
        int fireLashDmg = calculateDamage(baseDmg, getOpponentMultiplier(enemy, typeAttackMultipliers));

        enemy.setHp(enemy.getHp() - fireLashDmg);
        System.out.printf("%s Ssss... Woosh! Fire Lash lashes out, engulfing %s in searing flames, %s loses %shp, %s has %shp left %n",
                pokemon.getSound(), enemy.getName(), enemy.getName(), Main.ANSI_RED + fireLashDmg + Main.ANSI_RESET, enemy.getName(), Main.ANSI_BLACK + enemy.getHp() + Main.ANSI_RESET);
    }

    void flameThrower(Pokemon pokemon, Pokemon enemy) {
        int baseDmg = 20;
        int flameThrowerDmg = calculateDamage(baseDmg, getOpponentMultiplier(enemy, typeAttackMultipliers));

        enemy.setHp(enemy.getHp() - flameThrowerDmg);
        System.out.printf("%s Fwoosh! Sizzle! Burn! A searing jet of flames erupts from the Pokémon's mouth! %s loses %shp and has %shp left %n",
             pokemon.getSound(), enemy.getName(), Main.ANSI_RED + flameThrowerDmg + Main.ANSI_RESET, Main.ANSI_BLACK + enemy.getHp() + Main.ANSI_RESET);
    }
}

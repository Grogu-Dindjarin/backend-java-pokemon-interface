import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WaterPokemon extends Pokemon {
    private final List<String> attacks = Arrays.asList("surf", "hydroPump", "hydroCanon");
    private final HashMap<String, Integer> typeAttackMultipliers = new HashMap<>();

    public WaterPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound);
        this.typeAttackMultipliers.put("electric", 3);
        this.typeAttackMultipliers.put("grass", 2);
        this.typeAttackMultipliers.put("fire", 4);
        this.typeAttackMultipliers.put("water", 1);
    }

    @Override
    public String getType() {
        return "water";
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

    void surf(Pokemon pokemon, Pokemon enemy) {
        int baseDmg = 9;
        int surfDmg = calculateDamage(baseDmg, getOpponentMultiplier(enemy, typeAttackMultipliers));

        enemy.setHp(enemy.getHp() - surfDmg);
        System.out.printf("%s's surf dealt %s to %s, %s has %s hp %n",
                pokemon.getName(), Main.ANSI_RED + surfDmg + Main.ANSI_RESET, enemy.getName(), enemy.getName(), Main.ANSI_BLACK + enemy.getHp() + Main.ANSI_RESET);
    }

    public void hydroPump(Pokemon pokemon, Pokemon enemy) {
        int baseDmg = 11;
        int hydroPumpDmg = calculateDamage(baseDmg, getOpponentMultiplier(enemy, typeAttackMultipliers));

        enemy.setHp(enemy.getHp() - hydroPumpDmg);

        System.out.printf("%s's hydro pump dealt %s to %s, %s has %s hp %n",
                pokemon.getName(), Main.ANSI_RED + hydroPumpDmg + Main.ANSI_RESET, enemy.getName(), enemy.getName(), Main.ANSI_BLACK + enemy.getHp() + Main.ANSI_RESET);
    }

    public void hydroCanon(Pokemon pokemon, Pokemon enemy) {
        int baseDmg = 15;
        int hydroCanonDmg = calculateDamage(baseDmg, getOpponentMultiplier(enemy, typeAttackMultipliers));

        enemy.setHp(enemy.getHp() - hydroCanonDmg);
        System.out.printf("%s's surf dealt %s to %s, %s has %s hp %n",
                pokemon.getName(), Main.ANSI_RED + hydroCanonDmg + Main.ANSI_RESET, enemy.getName(), enemy.getName(), Main.ANSI_BLACK + enemy.getHp() + Main.ANSI_RESET);
    }

    public void rainDance(Pokemon pokemon, Pokemon enemy) {
        String pokemonName = pokemon.getName();
        String pokemonEnemyName = enemy.getName();
        String pokemonEnemyType = enemy.getType();

        int baseDmg = 5;

        switch (pokemonEnemyType) {
            case "electric" -> System.out.printf("%s's rain dance has no effect on %s %n", pokemonName, pokemonEnemyName);
            case "grass" -> {
                int hpBoost = 15;
                enemy.setHp(enemy.getHp() + hpBoost);

                System.out.printf("%s's rain dance heals %s with %shp! %s has %s hp left !%n",
                        pokemonName, pokemonEnemyName, Main.ANSI_GREEN + hpBoost + Main.ANSI_RESET, pokemonEnemyName, Main.ANSI_BLACK + enemy.getHp() + Main.ANSI_RESET);
            }
            case "fire" -> {
                int rainDanceDmg = calculateDamage(baseDmg, getOpponentMultiplier(enemy, typeAttackMultipliers));
                enemy.setHp(enemy.getHp() - rainDanceDmg);

                System.out.printf("%s's rain dance deals %s to %s, %s has %s hp left %n",
                        pokemonName, Main.ANSI_RED + rainDanceDmg + Main.ANSI_RESET, pokemonEnemyName, pokemonEnemyName, Main.ANSI_BLACK + enemy.getHp() + Main.ANSI_RESET);
            }
            case "water" -> {
                enemy.setHp(enemy.getHp() - baseDmg);

                System.out.printf("Rain dance deals %ddmg to %s, %s has %s hp left%n",
                        baseDmg, pokemonEnemyName, pokemonEnemyName, enemy.getHp());
            }
        }
    }
}

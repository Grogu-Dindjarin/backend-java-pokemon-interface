import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ElectricPokemon extends Pokemon {
    private List<String> attacks = Arrays.asList("thunderPunch", "electroBall", "thunder", "voltTackle");
    private final HashMap<String, Integer> typeAttackMultipliers = new HashMap<>();

    public ElectricPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound);
        this.typeAttackMultipliers.put("fire", 2);
        this.typeAttackMultipliers.put("water", 4);
        this.typeAttackMultipliers.put("electric", 1);
        this.typeAttackMultipliers.put("grass", 3);
    }

    @Override
    public String getType() {
        return "electric";
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

    void thunderPunch(Pokemon pokemon, Pokemon enemy) {
        int baseDmg = 11;
        int thunderPunchDmg = calculateDamage(baseDmg, getOpponentMultiplier(enemy, typeAttackMultipliers));

        enemy.setHp(enemy.getHp() - thunderPunchDmg);
        System.out.printf("%s! Crackle! Zap! The Thunder Punch electrifies the air with a sharp crack and a surge of power! dealing -%sdmg , %s has %shp left %n",
                pokemon.getSound(), Main.ANSI_RED + thunderPunchDmg + Main.ANSI_RESET, enemy.getName(), Main.ANSI_BLACK + enemy.getHp() + Main.ANSI_RESET);
    }

    void electroBall(Pokemon pokemon, Pokemon enemy) {
        int baseDmg = 20;
        int electroBallDmg = calculateDamage(baseDmg, getOpponentMultiplier(enemy, typeAttackMultipliers));

        enemy.setHp(enemy.getHp() - electroBallDmg);
        System.out.printf("%s! %s unleashes a crackling sphere of electrical energy, zapping %s with a surge of electrifying power.! dealing -%sdmg , %s has %shp left %n",
                pokemon.getSound(), pokemon.getName(), enemy.getName(), Main.ANSI_RED + electroBallDmg + Main.ANSI_RESET, enemy.getName(), Main.ANSI_BLACK + enemy.getHp() + Main.ANSI_RESET);
    }

    void thunder(Pokemon pokemon, Pokemon enemy) {
        if (enemy.getType().equals(pokemon.getType())) {
            int hpBoost = 35;
            enemy.setHp(enemy.getHp() + hpBoost);

            System.out.printf("Fzzzz! CRACK! BOOM! %s is surprised to see its Thunder move heal %s with %shp, %s! %s has %shp left !%n",
                    pokemon.getSound(), enemy.getName(), Main.ANSI_GREEN + hpBoost + Main.ANSI_RESET, enemy.getSound(), enemy.getName(), Main.ANSI_BLACK + enemy.getHp() + Main.ANSI_RESET);
        } else {
            int baseDmg = 15;
            int thunderDmg = calculateDamage(baseDmg, getOpponentMultiplier(enemy, typeAttackMultipliers));

            enemy.setHp(enemy.getHp() - thunderDmg);
            System.out.printf("%s! %s releases a thunderous bolt, crackling with electric energy as it strikes %s! Fzzzz! CRACK! BOOM! dealing -%sdmg , %s has %shp left %n",
                    pokemon.getSound(), pokemon.getName(), enemy.getName(), Main.ANSI_RED + thunderDmg + Main.ANSI_RESET, enemy.getName(), Main.ANSI_BLACK + enemy.getHp() + Main.ANSI_RESET);
        }
    }

    void voltTackle(Pokemon pokemon, Pokemon enemy) {
        int baseDmg = 9;
        int voltTackleDmg = calculateDamage(baseDmg, getOpponentMultiplier(enemy, typeAttackMultipliers));

        enemy.setHp(enemy.getHp() - voltTackleDmg);
        System.out.printf("%s! A crackling surge of electricity as %s charges into %s! dealing -%sdmg , %s has %shp left %n",
                pokemon.getSound(), pokemon.getName(), enemy.getName(), Main.ANSI_RED + voltTackleDmg + Main.ANSI_RESET, enemy.getName(), Main.ANSI_BLACK + enemy.getHp() + Main.ANSI_RESET);
    }
}

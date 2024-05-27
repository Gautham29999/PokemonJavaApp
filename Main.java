import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Pokemon Moves and Data:

        Pokemon charizard = new Pokemon("CHARIZARD", 1, 150, 100, 1.1, 0.85);
        Pokemon gyrados = new Pokemon("GYRADOS", 2, 145, 90, 1.05, 0.9);
        Pokemon venusaur = new Pokemon("VENUSAUR", 3, 165, 80, 0.9, 1.3);
        Pokemon staraptor = new Pokemon("STARAPTOR", 4, 125, 110, 1.2, 0.75);
        Pokemon pikachu = new Pokemon("PIKACHU", 5, 115, 125, 1.15, 0.8);
        Pokemon onix = new Pokemon("ONIX", 6, 175, 75, 0.95, 0.95);

        Pokemon [] allPokemon = {charizard, gyrados, venusaur, staraptor, pikachu, onix};


        //Game Variables:
        Scanner sc = new Scanner(System.in);
        int player1choice, player2choice;
        Pokemon player1Pokemon, player2Pokemon;

        // Player 1 Chooses Pokemon
        System.out.println("1. Charizard");
        System.out.println("2. Gyrados");
        System.out.println("3. Venusaur");
        System.out.println("4. Staraptor");
        System.out.println("5. Pikachu");
        System.out.println("6. Onix");
        System.out.println("Choose Your Pokemon Player 1: ");
        player1choice = sc.nextInt();
        player1Pokemon = new Pokemon (allPokemon[player1choice-1]);
        System.out.println("You chose " + player1Pokemon.getName());
        setMoves(player1Pokemon,player1choice);

        //Player 2 Chooses Pokemon
        System.out.println("1. Charizard");
        System.out.println("2. Gyrados");
        System.out.println("3. Venusaur");
        System.out.println("4. Staraptor");
        System.out.println("5. Pikachu");
        System.out.println("6. Onix");
        System.out.println("Choose Your Pokemon Player 2: ");
        player2choice = sc.nextInt();
        player2Pokemon = new Pokemon (allPokemon[player2choice-1]);
        System.out.println("You chose " + player2Pokemon.getName());
        setMoves(player2Pokemon,player2choice);

        // Game begins
        int p1MoveChoice, p2MoveChoice;
        Move p1Move, p2Move;
        while (player1Pokemon.getHp()> 0 && player2Pokemon.getHp() > 0) {
            System.out.printf("Player 1: %-20sPlayer 2: %-20s%n", (player1Pokemon.getName() + "(" + player1Pokemon.getHp() +"HP)"),  (player2Pokemon.getName() + "(" + player2Pokemon.getHp() +"HP)"));
            System.out.println("Player 1 : Choose the move you would like to use: ");
            player1Pokemon.printMoves();
            p1MoveChoice = sc.nextInt();
            p1Move = player1Pokemon.selectMove(p1MoveChoice);
            System.out.println("Player 2 : Choose the move you would like to use: ");
            player2Pokemon.printMoves();
            p2MoveChoice = sc.nextInt();
            p2Move = player2Pokemon.selectMove(p2MoveChoice);
            if (player1Pokemon.getSpeed()> player2Pokemon.getSpeed()){
                p1Move.attack(player1Pokemon, player2Pokemon);
                p2Move.attack(player2Pokemon, player1Pokemon);
            }

        }
        if (player1Pokemon.getHp()>0){
            System.out.println("PLAYER 1 WON!!!");
        } else {
            System.out.println("PLAYER 2 WON!!!");
        }

    }

    public static void setMoves(Pokemon playerPokemon, int playerChoice){
        Scanner sc = new Scanner(System.in);

        // ALL MOVES:
        // Normal Moves:
        Map<String, Move> normalMoves = new HashMap<>();
        normalMoves.put("EMBER", new NormalMove("EMBER", 1, 30, 25, 90, 0, "A burst of flames is shot at the opponent."));
        normalMoves.put("FLAMETHROWER", new NormalMove("FLAMETHROWER", 1, 45, 15, 100, 0, "A powerful stream of fire is unleashed."));
        normalMoves.put("FIRE SPIN", new NormalMove("FIRE SPIN", 1, 40, 20, 75, 0, "Creates a vortex of fire that traps the target."));
        normalMoves.put("BLAZE KICK", new NormalMove("BLAZE KICK", 1, 70, 10, 90, 0, "A fiery kick with a high chance of causing a burn."));
        normalMoves.put("FIRE BLAST", new NormalMove("FIRE BLAST", 1, 110, 5, 85, 0, "Unleashes a massive ball of fire that engulfs the target."));

        normalMoves.put("SURF", new NormalMove("SURF", 2, 55, 15, 85, 0, "Creates a large wave to crash into the opponent."));
        normalMoves.put("HYDRO PUMP", new NormalMove("HYDRO PUMP", 2, 70, 10, 80, 0, "Blasts a high-pressure stream of water at the target."));
        normalMoves.put("AQUA TAIL", new NormalMove("AQUA TAIL", 2, 60, 15, 90, 0, "Swings a strong tail made of water to hit the opponent."));
        normalMoves.put("WATER GUN", new NormalMove("WATER GUN", 2, 40, 25, 100, 0, "Shoots a stream of water at the target."));
        normalMoves.put("BRINE", new NormalMove("BRINE", 2, 100, 5, 75, 0, "Summons a heavy rain that boosts Water-type moves."));

        normalMoves.put("VINE WHIP", new NormalMove("VINE WHIP", 3, 40, 20, 100, 0, "Strikes the target with long, flexible vines."));
        normalMoves.put("LEAF BLADE", new NormalMove("LEAF BLADE", 3, 90, 5, 75, 0, "Slashes the target with a sharp blade of leaves."));
        normalMoves.put("SOLAR BEAM", new NormalMove("SOLAR BEAM", 3, 70, 10, 90, 0, "Gathers sunlight and releases it in a powerful beam."));
        normalMoves.put("MAGICAL LEAF", new NormalMove("MAGICAL LEAF", 3, 50, 15, 100, 0, "Launches sharp leaves that never miss the target."));
        normalMoves.put("PETAL DANCE", new NormalMove("PETAL DANCE", 3, 60, 10, 85, 0, "Dances and releases a flurry of petals that confuses the opponent."));

        normalMoves.put("FLY", new NormalMove("FLY", 4, 20, 25, 100, 0, "Flies high into the air and then dives at the target."));
        normalMoves.put("AIR SLASH", new NormalMove("AIR SLASH", 4, 75, 8, 90, 0, "Slashes the target with razor-sharp air currents."));
        normalMoves.put("BRAVE BIRD", new NormalMove("BRAVE BIRD", 4, 90, 5, 80, 0, "A powerful, reckless move that damages the user."));
        normalMoves.put("WING ATTACK", new NormalMove("WING ATTACK", 4, 60, 20, 90, 0, "Strikes the target with wings spread wide."));
        normalMoves.put("AERIAL ACE", new NormalMove("AERIAL ACE", 4, 40, 25, 100, 0, "An attack that never misses the target."));

        normalMoves.put("THUNDERBOLT", new NormalMove("THUNDERBOLT", 5, 90, 10, 100, 0, "Fires a bolt of electricity at the target."));
        normalMoves.put("SPARK", new NormalMove("SPARK", 5, 40, 20, 95, 0, "Creates a small spark that may paralyze the target."));
        normalMoves.put("THUNDER PUNCH", new NormalMove("THUNDER PUNCH", 5, 75, 15, 85, 0, "Punches the target with an electrified fist."));
        normalMoves.put("VOLT TACKLE", new NormalMove("VOLT TACKLE", 5, 120, 5, 80, 0, "Charges at the target with electrified tackles."));
        normalMoves.put("CHARGE BEAM", new NormalMove("CHARGE BEAM", 5, 50, 20, 100, 0, "Fires a beam of electricity that may raise the user's Special Attack."));

        normalMoves.put("EARTHQUAKE", new NormalMove("EARTHQUAKE", 6, 100, 5, 90, 0, "Causes a powerful earthquake to shake the ground."));
        normalMoves.put("DIG", new NormalMove("DIG", 6, 60, 15, 100, 0, "Digs underground on the first turn and strikes on the second."));
        normalMoves.put("MUD SHOT", new NormalMove("MUD SHOT", 6, 55, 10, 95, 0, "Sprays mud to reduce the target's Speed."));
        normalMoves.put("BULLDOZE", new NormalMove("BULLDOZE", 6, 70, 10, 100, 0, "A powerful quake that shakes the ground and lowers the target's Speed."));
        normalMoves.put("EARTH BLAST", new NormalMove("EARTH BLAST", 6, 50, 10, 100, 0, "Blasts the target with a burst of earth energy."));


        // Special Moves:
        Map<String, Move> specialMoves = new HashMap<>();
        specialMoves.put("INFERNO", new SpecialMove("INFERNO", 1, 0, 25, 90, 1, "Burns the target"));
        specialMoves.put("CHILLING STREAM", new SpecialMove("CHILLING STREAM", 1, 0, 25, 90, 2, "A chilling wind envelops the target."));
        specialMoves.put("ELECTRO WAVE", new SpecialMove("ELECTRO WAVE", 1, 0, 25, 90, 3, "Sends out a wave of electrical energy."));
        specialMoves.put("TOXIC SPORES", new SpecialMove("TOXIC SPORES", 1, 0, 25, 90, 4, "Scatters toxic spores, poisoning the target."));
        specialMoves.put("REGENERATE", new SpecialMove("REGENERATE", 1, 0, 25, 90, 5, "Restores the user's health through regeneration."));
        specialMoves.put("AGILITY", new SpecialMove("AGILITY", 1, 0, 25, 90, 6, "Increases speed stat."));
        specialMoves.put("SWORDS DANCE", new SpecialMove("SWORDS DANCE", 1, 0, 25, 90, 7, "Sharply raises the user's attack stat."));
        specialMoves.put("IRON DEFENCE", new SpecialMove("IRON DEFENCE", 1, 0, 25, 90, 8, "Raises the user's defense with an iron-like protective barrier."));
        specialMoves.put("CONSTRICT", new SpecialMove("CONSTRICT", 1, 0, 25, 90, 9, "Constricts the target with a squeezing motion lowering opponents speed."));
        specialMoves.put("CHARM", new SpecialMove("CHARM", 1, 0, 25, 90, 10, "Charms the opponent lowering their attack stat."));
        specialMoves.put("SCREECH", new SpecialMove("SCREECH", 1, 0, 25, 90, 11, "Emits a high-pitched screech to sharply lower the target's defense."));
        specialMoves.put("LEECH", new SpecialMove("LEECH", 1, 0, 25, 90, 12, "Drains the target's energy with a leeching effect."));

        // Learnable moves for every pokemon:

        String [][] learnableMoves = {{"EMBER","FLAMETHROWER","FIRE SPIN", "BLAZE KICK" , "FIRE BLAST", "FLY" , "THUNDER PUNCH","INFERNO" , "SWORDS DANCE" },
                {"SURF" , "HYDRO PUMP", "AQUA TAIL" , "WATER GUN" , "BRINE", "FLAMETHROWER" , "MUD SHOT","CHILLING STREAM", "IRON DEFENCE"},
                {"VINE WHIP" , "LEAF BLADE", "SOLAR BEAM" , "MAGICAL LEAF" , "PETAL DANCE" , "TOXIC SPORES" , "LEECH", "DIG", "REGENERATE"},
                {"FLY" , "AIR SLASH" , "BRAVE BIRD" , "WING ATTACK" , "AERIAL ACE" , "AGILITY", "SWORDS DANCE" , "SCREECH", "REGENERATE"},
                {"THUNDERBOLT", "SPARK" , "THUNDER PUNCH" , "VOLT TACKLE" , "CHARGE BEAM", "ELECTRO WAVE" , "CHARM" , "DIG"},
                {"EARTHQUAKE" , "DIG" , "MUD SHOT" , "BULLDOZE" , "EARTH BLAST" , "IRON DEFENCE", "CONSTRICT", "SCREECH", "THUNDER BOLT"}};
        int moveChoice;
        Move choice;
        for (int j = 0; j < 4; j ++){
            for (int i = 0; i < learnableMoves[playerChoice-1].length; i++){
                System.out.println((i + 1) + ": " + learnableMoves[playerChoice-1][i]);
            }
            System.out.println("Choose move "+ (j + 1) +  " for " + playerPokemon.getName());
            moveChoice = sc.nextInt();
            if (normalMoves.containsKey(learnableMoves[playerChoice-1][moveChoice-1])){
                choice = normalMoves.get(learnableMoves[playerChoice- 1][moveChoice-1]);
            } else if (specialMoves.containsKey(learnableMoves[playerChoice-1][moveChoice-1])){
                choice = specialMoves.get(learnableMoves[playerChoice-1][moveChoice-1]);
            } else {
                System.out.println("The move does not exist");
                choice = null;
            }

            switch (j) {
                case 0:
                    playerPokemon.setMove1(choice);
                    System.out.println(playerPokemon.getName() + " learnt " + playerPokemon.getMove1().getName());
                    break;
                case 1:
                    playerPokemon.setMove2(choice);
                    System.out.println(playerPokemon.getName() + " learnt " + playerPokemon.getMove2().getName());
                    break;
                case 2:
                    playerPokemon.setMove3(choice);
                    System.out.println(playerPokemon.getName() + " learnt " + playerPokemon.getMove3().getName());
                    break;
                case 3:
                    playerPokemon.setMove4(choice);
                    System.out.println(playerPokemon.getName() + " learnt " + playerPokemon.getMove4().getName());

                    break;
                default:
                    System.out.println("Default case: j is not in the range of 0 to 3");
            }
        }

    }


}
import java.util.*;
import java.io.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    String getName() {
        return name;
    }

    int getScore() {
        return score;
    }
}

class Checker implements Comparator<Player> {
    public int compare(Player a, Player b) {
        if (a.getScore() != b.getScore()) {
            return b.getScore() - a.getScore();
        } else {
            return a.getName().compareTo(b.getName());
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Checker checker = new Checker();

        Arrays.sort(player, checker);
        for (Player p : player) {
            System.out.println(p.name + " " + p.score);
        }
    }
}
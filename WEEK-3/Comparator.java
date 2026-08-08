import java.util.*;
import java.io.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    public int compare(Player a, Player b) {
        // Decreasing order of score
        if (a.score != b.score) {
            return b.score - a.score;
        }
        // Same score -> ascending alphabetical order by name
        return a.name.compareTo(b.name);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        Player[] player = new Player[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            player[i] = new Player(name, score);
        }

        Checker checker = new Checker();
        Arrays.sort(player, checker);

        StringBuilder sb = new StringBuilder();
        for (Player p : player) {
            sb.append(p.name).append(" ").append(p.score).append("\n");
        }
        System.out.print(sb);
    }
}

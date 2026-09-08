import java.util.Scanner;

interface Food {
    String getType();
}

class Pizza implements Food {
    public String getType() {
        return "Someone ordered Fast Food!";
    }
}

class Cake implements Food {
    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

class FoodFactory {
    public Food getFood(String type) {
        if (type == null) {
            return null;
        }
        switch (type.trim().toLowerCase()) {
            case "pizza":
                return new Pizza();
            case "cake":
                return new Cake();
            default:
                return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String foodChoice = scan.nextLine();

        FoodFactory foodFactory = new FoodFactory();
        Food food = foodFactory.getFood(foodChoice);

        if (food != null) {
            System.out.println("The factory returned " + food.getClass());
            System.out.println(food.getType());
        } else {
            System.out.println("Unknown food type: " + foodChoice);
        }

        scan.close();
    }
}
package programmers.week11;

import java.util.*;

public class Week11_4 {
    public int week11_4(int money, int[] chips) {
        // Sort the chips in descending order to start with the largest chip value
        Arrays.sort(chips);
        int count = 0;

        // Start from the largest chip value
        for (int i = chips.length - 1; i >= 0; i--) {
            if (money == 0) break;

            // Use as many of the current chip as possible
            int numChips = money / chips[i];
            count += numChips;
            money -= numChips * chips[i]; // Update remaining money
        }

        // If money is not 0 here, it means exact change was not possible
        if (money != 0) {
            return -1; // Indicate that it's not possible to exchange without remainder
        }

        return count;
    }

    public static void main(String[] args) {
        Week11_4 solution = new Week11_4();
        int money = 3000;
        int[] chips = {1100, 500, 200, 150, 25};
        System.out.println(solution.week11_4(money, chips)); // Expected: 5
    }
}



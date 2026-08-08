class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        
        // January 1, 1971 was a Friday -> index 5 in the array
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int totalDays = 0;
        
        // Add days for all complete years from 1971 to year-1
        for (int y = 1971; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }
        
        // Add days for all complete months before this month in the current year
        for (int m = 0; m < month - 1; m++) {
            totalDays += daysInMonth[m];
            if (m == 1 && isLeapYear(year)) {
                totalDays += 1; // account for leap day in February
            }
        }
        
        // Add the days in the current month (day - 1 since we haven't "completed" today yet)
        totalDays += (day - 1);
        
        // Jan 1, 1971 was a Friday, which is index 5 in the days array
        int dayIndex = (5 + totalDays) % 7;
        
        return days[dayIndex];
    }
    
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
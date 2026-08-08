class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(toEpochDays(date1) - toEpochDays(date2));
    }
    
    private int toEpochDays(String date) {
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int days = 0;
        // Add days for all complete years before this year (since year 0 for consistency)
        for (int y = 0; y < year; y++) {
            days += isLeapYear(y) ? 366 : 365;
        }
        // Add days for all complete months before this month
        for (int m = 0; m < month - 1; m++) {
            days += daysInMonth[m];
            if (m == 1 && isLeapYear(year)) {
                days += 1; // February in a leap year
            }
        }
        // Add the days in the current month
        days += day;
        
        return days;
    }
    
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
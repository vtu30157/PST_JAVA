class Solution {
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int result = day;
        
        for (int m = 0; m < month - 1; m++) {
            result += daysInMonth[m];
        }
        
        // Add 1 for leap year Feb 29 if we've passed February
        if (month > 2 && isLeapYear(year)) {
            result += 1;
        }
        
        return result;
    }
    
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
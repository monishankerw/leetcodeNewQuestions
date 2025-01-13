package com.leetcode.leetcode.java17;

public class SwitchStatements {
    public static class OldSwitch {
        public static void main(String[] args) {

            int day = 3;
            String dayType;

            switch (day) {
                case 1:
                case 7:
                    dayType = "Weekend";
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    dayType = "Weekday";
                    break;
                default:
                    dayType = "Invalid day";
            }
            System.out.println(dayType); // Output: Weekday
        }


        public static class A {
            public static void main(String[] args) {
                int days = 2;

                // Correct usage of switch expression
                String result = switch (days) {
                    case 1, 3 -> "Sunday or Thursday";
                    case 2 -> "Monday";
                    case 4 -> "Wednesday";
                    case 5 -> "Friday";
                    default -> "Invalid day";
                };

                System.out.println("Day is: " + result);
            }
        }
    }
}
package javacoreexample.leetcode;

import java.util.Scanner;

/** Given a time in -hour AM/PM format, convert it to military (24-hour) time.
Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
- 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock. ***/

public class TimeConversionSystem {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String inputTime = in.nextLine();

        int hours = Integer.parseInt(inputTime.substring(0,2));
        int minutes = Integer.parseInt(inputTime.substring(3,5));
        int seconds = Integer.parseInt(inputTime.substring(6,8));
        String description = inputTime.substring(8);

        if(description.equals("AM")){
            if (hours == 12){
                hours = 00;
            }

            String newHour = String.format("%02d",hours);
            String newMinutes = String.format("%02d",minutes);
            String newSeconds = String.format("%02d",seconds);

            System.out.println(newHour + ":" + newMinutes + ":" + newSeconds);
        }

        if(description.equals("PM")){
            if (hours == 12) {
                String newHour = String.format("%02d", hours);
                String newMinutes = String.format("%02d",minutes);
                String newSeconds = String.format("%02d",seconds);

                System.out.println(newHour + ":" + newMinutes + ":" + newSeconds);
            }
            else {
                hours = hours +12;
                String newHour = String.format("%02d", hours);
                String newMinutes = String.format("%02d", minutes);
                String newSeconds = String.format("%02d", seconds);
                System.out.println(newHour + ":" + newMinutes + ":" + newSeconds);
            }
        }
    }
}

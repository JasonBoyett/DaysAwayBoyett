/*
* Jason Boyett - jaboye2448
* CIT 4423 01
* October 13, 2022
* mac OS
*/

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

public class Main {
    private static String bDayMessage = "What is your birthday? Please use the MM/DD/YYYY format.";
    private static String pattern = "M/d/uuuu";
    private static String errorMessage = "That didn't work. Please try again with the MM/DD/YYYY format.";
    private static DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);

    public static void main(String[] args) throws ParseException {

        LocalDate birthday = getDate(bDayMessage, format, errorMessage);
        String message = String.format("Your birthday is %d days away. You'll be %d years old.", daysTo(birthday), findAgeThisYear(birthday) );
        JOptionPane.showMessageDialog(null, message);
        
    }
    
    public static LocalDate getDate(String message, DateTimeFormatter format, String errorMessage) {

        try{
            String getDate = JOptionPane.showInputDialog(message);
            return LocalDate.parse(getDate, format);
        }
        catch(DateTimeParseException e){
            return getDate(errorMessage, format, errorMessage);
        }

    }

    public static int daysTo(LocalDate date) {

        LocalDate currentDate = LocalDate.now();
        LocalDate myDate = date.withYear(currentDate.getYear());
        int startDay = currentDate.getDayOfYear();
        int endDay = myDate.getDayOfYear();

        if ((endDay - startDay) > 0) {
            return (endDay - startDay);
        } else if ((endDay - startDay) < 0) {
            return ((currentDate.lengthOfYear() - startDay) + endDay);
        } else if(date.lengthOfYear() > 365){
            return (date.lengthOfYear() - (endDay - startDay)); 
        } else{
            return 0;
        }

    }

    public static int findAgeThisYear(LocalDate birthDate){

        LocalDate currentDate = LocalDate.now();

        if(currentDate.isAfter(birthDate.withYear(currentDate.getYear()))){
            return (currentDate.getYear() - birthDate.getYear()) + 1;
        }
        else{
            return currentDate.getYear() - birthDate.getYear();
        }

    }

}
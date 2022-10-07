import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args)
    {
        Scanner string = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String input = string.nextLine();
        input = input.replaceAll("\\s", "");
        char[] chararr = input.toCharArray();
        try{
            for(Character ch: chararr){
                if(Pattern.matches("[a-zA-Zа-яА-Я]&[^I|II|III|IV|V|VI|VII|VIII|IX|X]", ch.toString())){
                    throw new LetterException();
                }
            }

            if(!Pattern.matches("\\b([1-9]|10|I|II|III|IV|V|VI|VII|VIII|IX|X)\\b[+-/*]\\b([1-9]|10|I|II|III|IV|V|VI|VII|VIII|IX|X)\\b", input)){
                throw new NotMatchException();
            }
            for(String s: input.split("\\D")){
                if (s.length()>1&!s.contains("10")){
                    throw new NumberOverflow();
                }
            }
            int countOperations = 0;
            for(String s: input.split("\\d")){
                if(!s.isEmpty()){
                    countOperations++;
                }
            }
            if(countOperations>1){
                throw new OperationOverflow();
            }
            int combiningArab = 0;
            int combiningRoman = 0;
            for(String s: input.split("[+\\-/*]")){
                if (s.matches("I|II|III|IV|V|VI|VII|VIII|IX|X")){
                    combiningRoman++;
                } else if (s.matches("\\b([1-9]|10)\\b")) {
                    combiningArab++;
                }
            }
            if(combiningRoman==combiningArab){
                throw new CombineProhibit();
            }
        }
        catch (LetterException e){
            System.out.println(e);
            return;
        }
        catch (NotMatchException e){
            System.out.println(e);
            return;
        } catch (NumberOverflow e) {
            System.out.println(e);
            return;
        } catch (OperationOverflow e) {
            System.out.println(e);
            return;
        } catch (CombineProhibit e) {
            System.out.println(e);
            return;
        }

        System.out.println(calc(input));
    }

    public static String calc(String input)
    {
        if(Pattern.matches("\\d{1,2}[+\\-/*]\\d{1,2}",input)){
           var numbers = input.split("\\D");
           var operationArr = input.split("\\d");
           int answer;
           String operation="bruh";

           for (String s: operationArr) {
                if(s.matches("[+\\-*/]")){
                    operation=s;
                }
           }

           switch (operation){
               case "+":
                   answer = Integer.parseInt(numbers[0])+Integer.parseInt(numbers[1]);
                   return Integer.toString(answer);
               case "-":
                   answer = Integer.parseInt(numbers[0])-Integer.parseInt(numbers[1]);
                   return Integer.toString(answer);
               case "/":
                   answer = Integer.parseInt(numbers[0])/Integer.parseInt(numbers[1]);
                   return Integer.toString(answer);
               case "*":
                   answer = Integer.parseInt(numbers[0])*Integer.parseInt(numbers[1]);
                   return Integer.toString(answer);
               case "bruh":
                   return "bruh";
            }
        }
        else{
            var numbersS = input.split("[+-/*]");
            var operationArr = input.split("I|II|III|IV|V|VI|VII|VIII|IX|X");
            int answer;
            String operation="bruh";
            ArrayList<Integer> numbers = new ArrayList<Integer>();

            for (String s: operationArr) {
                if(s.matches("[+\\-*/]")){
                    operation=s;
                }
            }

            try{
                for (String s: numbersS){
                    if(RomanArabNumbers.toArab(s)==-1){
                        throw new NumberOverflow();
                    }
                    else{
                        numbers.add(RomanArabNumbers.toArab(s));
                    }
                }
            }
            catch(NumberOverflow e){
                return e.toString();
            }

            switch (operation){
                case "+":
                    answer = numbers.get(0)+numbers.get(1);
                    return RomanArabNumbers.toRoman(answer);
                case "-":
                    try {
                        answer = numbers.get(0) - numbers.get(1);
                        if (answer <= 0) {
                            throw new ZeroRomanAnswerException();
                        }
                    }
                    catch (ZeroRomanAnswerException e){
                        return e.toString();
                    }
                    return RomanArabNumbers.toRoman(answer);
                case "/":
                    answer = numbers.get(0)/numbers.get(1);
                    return RomanArabNumbers.toRoman(answer);
                case "*":
                    answer = numbers.get(0)*numbers.get(1);
                    return RomanArabNumbers.toRoman(answer);
                case "bruh":
                    return "bruh";
            }

        }
       return "Bruh";
    }

}
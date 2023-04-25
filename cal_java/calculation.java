import java.util.HashMap;
import java.util.Scanner;

public class Calculation {

    public static void main(String[] args) throws ScannerException {
        String[] s = Input();
        if (s.length < 3) {
            throw new ScannerException("static void");
        } else if (s.length > 3) {
            throw new ScannerException("static void2");
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("I", "1");
        map.put("II", "2");
        map.put("III", "3");
        map.put("IV", "4");
        map.put("V", "5");
        map.put("VI", "6");
        map.put("VII", "7");
        map.put("VIII", "8");
        map.put("IX", "9");
        map.put("X", "10");
        map.put("XX", "20");
        map.put("XXX", "30");
        map.put("XL", "40");
        map.put("L", "50");
        map.put("LX", "60");
        map.put("LXX", "80");
        map.put("CX", "90");
        map.put("C", "100");
        String ostatok1;
        int celoe;
        int ostatok;
        int count1 = 0;
        int count2 = 0;
        String firstNum1 = s[0];
        String secondNum1 = s[2];
        for (String itVar : map.keySet()){
            if (firstNum1.equals(itVar)){
                firstNum1 = map.get(itVar);
                count1 = 1;
            }
            if (secondNum1.equals(itVar)) {
                secondNum1 = map.get(itVar);
                count2 = 1;
            }
        }
        if (count1 != count2){
            throw new ScannerException("throws Exception //т.к. используются одновременно разные системы счисления");
        }
        int result;
        String sign = s[1];
        int firstNum = Integer.parseInt(firstNum1);
        int secondNum = Integer.parseInt(secondNum1);
        switch (sign) {
            case "+":
                if (count1 == 1 && count2 == 1) {
                    result = firstNum + secondNum;
                     celoe = result / 10;
                     ostatok = result % 10;
                    if (celoe == 0) {
                         ostatok1 = Integer.toString(ostatok);
                        for (String itVar : map.keySet()){
                            if (map.get(itVar).equals(ostatok1)){
                                ostatok1 = itVar;
                            };
                        }
                        System.out.println(ostatok1);
                        break;
                    }else {
                        String celoe1 = "X";
                         ostatok1 = " ";
                        if (ostatok==0){
                            ostatok1 = "X";
                        }
                        for (String itVar : map.keySet()){
                            String value = map.get(itVar);
                            if (ostatok == Integer.parseInt(value)){
                                ostatok1 = itVar;
                            }
                        }
                        System.out.println(celoe1+ostatok1);
                        break;
                    }
                }else {
                    System.out.println(firstNum + secondNum);
                    break;
                }
            case "-":
                if (count1 == 1 && count2 == 1 && (firstNum - secondNum < 0)) {
                    throw new ScannerException("throws Exception //т.к. в римской системе нет отрицательных чисел");
                }
                if (count1 == 1 && count2 == 1){
                    result = firstNum - secondNum;
                    ostatok1 = " ";
                    if (result == 0){
                        throw new ScannerException("нет нуля.");
                    }
                    for (String itVar : map.keySet()){
                        String value = map.get(itVar);
                        if (result == Integer.parseInt(value)){
                            ostatok1 = itVar;
                        }
                    }
                    System.out.println(ostatok1);
                    break;
                }else {
                    System.out.println(firstNum - secondNum);
                    break;
                }
           case "/":
                if (count1 == 1 && count2 == 1){
                    ostatok1 = " ";
                    result = firstNum / secondNum;
                    if (result < 1){
                        throw new ScannerException("result < 1");
                    }
                    for (String itVar : map.keySet()){
                        String value = map.get(itVar);
                        if (result == Integer.parseInt(value)){
                            ostatok1 = itVar;
                        }
                    }
                    System.out.println(ostatok1);
                    break;
                }else {
                    System.out.println(firstNum / secondNum);
                    break;
                }
            case "*":
                if (count1 == 1 && count2 == 1){
                    result = firstNum * secondNum;
                    celoe = result / 10;
                    ostatok = result % 10;
                    if (celoe == 0){
                        ostatok1 = " ";
                        for (String itVar : map.keySet()){
                            String value = map.get(itVar);
                            if (ostatok == Integer.parseInt(value)){
                                ostatok1 = itVar;
                            }
                        }
                        System.out.println(ostatok1);
                        break;
                    }
                    if (ostatok == 0){
                        String celoe1 = " ";
                        for (String itVar : map.keySet()){
                            String value = map.get(itVar);
                            if (result == Integer.parseInt(value)){
                                celoe1 = itVar;
                            }
                        }
                        System.out.println(celoe1);
                        break;
                    }
                    if (celoe !=0 && ostatok !=0){
                        ostatok1 = " ";
                        String celoe1 = " ";
                        for (String itVar : map.keySet()){
                            String value = map.get(itVar);
                            if (ostatok == Integer.parseInt(value)){
                                ostatok1 = itVar;
                            }
                            if (celoe * 10 == Integer.parseInt(value)){
                                celoe1 = itVar;
                            }
                        }
                        System.out.println(celoe1 + ostatok1);
                        break;
                    }else {
                        result = firstNum * secondNum;
                        System.out.println(result);
                        break;
                    }
                }
        }
    }

    public static String[] Input() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        return parts;
    }
}

class ScannerException extends Exception {
    public ScannerException(String description){
        super(description);
    }
}
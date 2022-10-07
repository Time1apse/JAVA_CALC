import java.util.TreeMap;

class RomanArabNumbers {
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public final static String toRoman(int number) {
        int l = map.floorKey(number);
        if (number==l){
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }

    public final static int toArab(String roman){
        switch (roman){
            case "X":
                return 10;
            case "IX":
                return 9;
            case "VIII":
                return 8;
            case "VII":
                return 7;
            case "VI":
                return 6;
            case "V":
                return 5;
            case "IV":
                return 4;
            case "III":
                return 3;
            case "II":
                return 2;
            case "I":
                return 1;
            default:
                return -1;
        }
    }
}

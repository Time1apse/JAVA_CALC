class LetterException extends Exception{
    public LetterException(){
        System.out.println("Вы ввели недопустимые символы");
    }
}

class NotMatchException extends Exception{
    public NotMatchException(){
        System.out.println("Вы ввели недопустимое выражение");
    }
}

class NumberOverflow extends Exception{
    public NumberOverflow(){
        System.out.println("Вы ввели слишком большое или неподходящее число");
    }
}

class OperationOverflow extends Exception{
    public OperationOverflow(){
        System.out.println("Вы хотите выполнить слишком много операций");
    }
}

class CombineProhibit extends Exception{
    public CombineProhibit(){
        System.out.println("Нельзя выполнять операции с разными числовыми системами");
    }
}

class ZeroRomanAnswerException extends Exception{
    public ZeroRomanAnswerException(){
        System.out.println("Вы ввели уравнение, которое дает ноль или меньше в ответе");
    }
}


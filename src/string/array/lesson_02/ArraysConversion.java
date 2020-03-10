package string.array.lesson_02;

import javax.swing.text.NumberFormatter;

class ExeptionLengthArray extends Exception{
    int length;
    int size = 4;
    ExeptionLengthArray(int length){
        this.length = length;
    }

    public String toString(){
        return "Длинна массива:  " + length + " не соответствует " + size;
    }
}

class ElementsParseInt extends NumberFormatException{

    public String toString(){
        return "По меньшей мере один из элементов не является числом: ";
    }

}

public class ArraysConversion {

    private final static int SIZE = 4;

    private static String[][] conversion(String str) throws ExeptionLengthArray {
        String[] initialString = str.split("\n");
        String[][] updateString;
        updateString = reverse(initialString);

        return updateString;
    }

    private static String[][] reverse(String[] reverseString) throws ExeptionLengthArray{
        // как создать массив одинаковой длинный с тем что подается?
        String[][] returnedString = new String[reverseString.length][reverseString.length];


        for (int i = 0; i < SIZE; i++) {
            String[] init = reverseString[i].split(" ");
            System.arraycopy(init, 0, returnedString[i], 0, SIZE);
            if(returnedString.length != SIZE || returnedString[0].length != SIZE){
                throw new ExeptionLengthArray(returnedString.length);
            }
        }


        return returnedString;
    }

    private static void printArray(String[][] stri) {
        for (String[] strings : stri) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private static void printArray(int[][] intArray) {
        for (int[] ints : intArray) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int[][] converseStringForInt(String[][] str) {
        int[][] converseInt = new int[str.length][str.length];

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length; j++) {
                try {
                    converseInt[i][j] = Integer.parseInt(str[i][j]);
                } catch (ElementsParseInt e) {
                    System.out.println("Перехвачено исключение: " + e);
                }
            }
        }

        return converseInt;
    }

    private static String halfSummArray(int[][] array) {
        int summ = 0;

        for (int[] ints : array) {
            for (int value : ints) {
                summ += value;
            }
        }

        return "Половина суммы элементов массива:  " +summ / 2;
    }

    public static void main(String[] args) {
        String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

        String[][] stri = new String[SIZE][SIZE];

        //нормальная ли длинная
        try {
            stri = conversion(str);
        } catch (ExeptionLengthArray e){
            System.out.println("Перехвачено исключение: " + e);
        }

        int[][] int1 = new int[SIZE][SIZE];

        //проверка на то является ли числом элементы
        try {
            int1 = converseStringForInt(stri);
        } catch (NumberFormatException e) {
            try {
                throw new ElementsParseInt();
            } catch (ElementsParseInt elementsParseInt) {
                System.out.println(elementsParseInt);
            }
        }


        printArray(int1);
        System.out.println(halfSummArray(int1));

    }
}

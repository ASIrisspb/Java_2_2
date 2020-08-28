package ASIris;

import javafx.util.Pair;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //массив для обработки
        String[][] strings = new String[][]
                {   {"1", "2", "3", "4в"},
                    {"1", "2", "3в", "4"},
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"}   };

        //рабочий метод
        myArrayMethod(strings);

    }

    //метод принимающий на вход массив
    private static void myArrayMethod(String[][] myArray) {
        //проверяем размерность переданного массива
        try {
            if (myArray.length != 4) {
                throw new MyArraySizeException();
            } else {
                for (String[] strings : myArray) {
                    if (strings.length != 4) {
                        throw new MyArraySizeException();
                    }
                }
            }
            //если исключение MyArraySizeException не возникло, то идем дальше
            //переменная для хранения суммы
            int sum = 0;
            //переменная для хранения результата перевода из строки в число
            int numberOfSting = 0;
            //проходим по всем элементам массива
            for (int i = 0; i < myArray.length; i++) {
                for (int j = 0; j < myArray[i].length; j++) {
                    //обнуляем, чтобы не получилось ложной суммы
                    numberOfSting = 0;
                    try {
                        numberOfSting = Integer.parseInt(myArray[i][j]);
                    } catch (NumberFormatException e) {
                        Pair<Integer, Integer> indexOfMistake = new Pair<>(i,j);
                        MyArrayDataException.indexOfMistake.add(indexOfMistake);
                    }
                    sum += numberOfSting;
                }
            }
            if (MyArrayDataException.indexOfMistake.size() != 0) {
                MyArrayDataException.printMistake();
            }
            System.out.println("Сумма распознанных элементов массива: " + sum);
        //если размерность неправильная, то выводим сообщение
        } catch (MyArraySizeException e) {
            e.printMistake();
        }

    }
}
//класс обнаружения ошибки размерности массива
    class MyArraySizeException extends Exception {
        public void printMistake() {
            System.out.println("Передан массив неправильного размера!");
        }
    }

//класс обнаружения и фиксации ошибки "нечислового" элемента массива
    class MyArrayDataException extends Exception {
        static ArrayList<Pair<Integer,Integer>> indexOfMistake = new ArrayList<>();

        static public void printMistake() {
            System.out.println("В массиве обнаружены ошибки (вместо чисел стоят недопустимые символы) " +
                    "- их индексы приведены ниже:");
            System.out.println(MyArrayDataException.indexOfMistake);
        }
    }




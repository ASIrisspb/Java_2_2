package ASIris;

import javafx.util.Pair;

import java.util.ArrayList;

public class MyArrayDataException extends ArithmeticException {

    public MyArrayDataException(String message) {
        super(message);
    }

    public void printMistake() {
        System.out.println("В массиве обнаружены ошибки (вместо чисел стоят недопустимые символы) " +
                "- их индексы приведены ниже:");
    }
}

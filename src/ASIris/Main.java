package ASIris;

public class Main {

    public static void main(String[] args) {

        //массив для обработки
        String[][] arrayOfNumbers = new String[][]
                {   {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
                    {"1а", "2", "3", "4"}   };
        //рабочий метод
        myArrayMethod(arrayOfNumbers);
    }

    //метод принимающий на вход массив
    private static void myArrayMethod(String[][] myArray) {
        //проверяем размерность переданного массива
        try {
            if (myArray.length != 4) {
                throw new MyArraySizeException("Количество строк в массиве не равно 4");
            } else {
                for (int i = 0; i < myArray.length; i++) {
                    if (myArray[i].length != 4) {
                        String s = String.valueOf(i);
                        throw new MyArraySizeException(s + "-я строка в массиве имеет длину не равную 4-ём");
                    }
                }
            }
            //если исключение MyArraySizeException не возникло, то идем дальше
            //переменная для хранения суммы
            int sum = 0;
            //переменная для хранения результата перевода из строки в число
            int numberOfSting;
            //проходим по всем элементам массива
            for (int i = 0; i < myArray.length; i++) {
                for (int j = 0; j < myArray[i].length; j++) {
                    //обнуляем, чтобы не получилось ложной суммы
                    numberOfSting = 0;
                    try {
                        try {
                            numberOfSting = Integer.parseInt(myArray[i][j]);
                        } catch (NumberFormatException e) {
                            String line = String.valueOf(i+1);
                            String column = String.valueOf(j+1);
                            throw new MyArrayDataException("В ячейке (" + line +
                                    " - строка, " + column + " - столбец) НЕ ЧИСЛО!");
                        }
                    } catch (MyArrayDataException e) {
                        System.out.println(e.getMessage());
                    }
                    sum += numberOfSting;
                }
            }
            System.out.println("Сумма распознанных элементов массива: " + sum);
        //если размерность неправильная, то выводим сообщение
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }

    }
}




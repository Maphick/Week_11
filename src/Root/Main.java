package Root;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {

    public static void main(String[] args)  {
            CopyFileUsingStream();
    }


    public static void prediction() throws IOException {
        List<String> lines =
                Files.readAllLines(Paths.get("src/Root/borodino.txt"), UTF_8);
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number in range 1.." + lines.size());
        int n = in.nextInt();
        try {
            System.out.println("Вот предсказание для вас:\n" + lines.get(n));
        }
        catch (Exception e) {
            System.out.println("Вы ввели недопустимый номер..." );
        }

    }



    // Выполнение арифметических операций (например, деление на ноль).
    public static void ArithmeticException()
    {
       int a=  10/0;
    }

    // Индекс массива выходит за допустимые границы.
    public static void  ArrayIndexOutOfBoundsException()
    {
        int[] array = new int[]{1,2,3};
        for (int i =0; i<=array.length; i++)
            System.out.println(array[i]);
    }

    // Присвоение элементу массива значения несовместимого типа.
    public static void  ArrayStoreException()
    {
        Object x[] = new String[3];
        x[0] = Integer.valueOf(0);
    }


    // Попытка выполнить приведение несовместимых типов.
    // Выбрасывается, чтобы указать, что код попытался привести объект к подклассу, экземпляром которого он не является.
    public static void  ClassCastException()
    {

        abstract class animal {
            String name;

            abstract void voice();
        }
        class Dog extends animal{

            @Override
            void voice() {
                System.out.println("Woof!");
            }
        }

        class Cat extends animal{

            public Cat(String name)
            {
                this.name = name;
            }
            @Override
            void voice() {
                System.out.println("Meow!");
            }
        }

        //Object i = Integer.valueOf(42);
        //String s = (String)i;
        //int k = (int)i;
        Object cat = new Cat("Musja");
        //Cat cat = (Cat)cat;
        Dog dog = (Dog)cat;

    }

    public static void  NegativeArraySizeException()
    {
        int[] array = new int[-2];
    }

    public static void  NullPointerException()
    {
        class cat {
            String catName;
        }
        cat cat = null;
        System.out.println(cat.catName);

    }


    // Преобразование строки к числовому значению (когда в число преобразуется строка,
    // содержащая некорректное текстовое представление числа).
    public static void  NumberFormatException()
    {
        String s = "dsvaf";
        int a = Integer.parseInt(s);
    }

    public static void  StringIndexOutOfBoundsException()
    {
       String s = "012";
        System.out.println(s.charAt(3));
    }


    class A{
        public void f() throws IOException {}
    }
    class B extends A{
        public void f() throws  FileNotFoundException, InternalError {}
    }

    public static void numberFormat() {
        try {
            NumberFormat nf = NumberFormat.getInstance();
            //специально создаем ситуацию, которая приведет к исключению
            System.out.println(nf.parse("NOT A NUMBER"));
        }
        catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Конец программы!");
    }

    public static void indexOfBounds() {
        String string = "123";
        try
        {
            char chr = string.charAt(10);
        }
        catch(StringIndexOutOfBoundsException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("Конец программы!");
    }

    public static void doAction() {
        try {
            int a = (int)(Math.random() * 2);
            System.out.println("a = " + a);
            int c[] = { 1/a }; // опасное место #1
            c[a] = 71; // опасное место #2
        } catch(ArithmeticException e) {
            System.err.println("деление на 0" + e);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.err.println("out of bound: " + e);
        } // окончание try-catch блока
        System.out.println("after try-catch");
    }

    public static void CopyFileUsingStream() {
        try {
            copyFileUsingStream("src/Root/utf-8.txt", "UTF-8", "src/Root/win1251.txt", "WINDOWS-1251");
            System.out.println("Перекодировка прошла успешно");
            }
        catch (ConvertExeption e) {
            System.err.println(e.getMessage());
        }
    }



    // Если ф-я выбрасывает исключение, то не возвращает значение
    private static void copyFileUsingStream(String source, String sourceEnc, String dest, String descEnc) throws ConvertExeption  {
        try (
                Reader fis = new InputStreamReader(new FileInputStream(source) , Charset.forName(sourceEnc));
                Writer fos = new OutputStreamWriter(new FileOutputStream(dest), Charset.forName(descEnc));
                )
        {
            char[] buffer = new char[1024];
            int length;
                while ((length = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
        }
        catch (FileNotFoundException e) {
            throw new ConvertExeption("Проблемы с файлами: " + e.getMessage());
        }
        catch (UnsupportedCharsetException e) {
            throw new ConvertExeption("Проблема с кодировкой файла: " + e.getMessage() );
        }
        catch (IOException e)
        {
            throw new ConvertExeption("Проблемы при копировании");
        }
    }

    public class MyException extends Exception {
        private int detail;
        public MyException(int detail, String message) {
            super(message);
            this.detail = detail;
        }
        @Override
        public String toString() {
            return "MyException{"
                    + "detail=" + detail
                    + ", message=" + getMessage()
                    + "} ";
        }
    }

    public static void devidionByZero() {
        int number1 = 10;
        int number2 = 0;
        try {
            if (number2 == 0) {
                throw new DevisionByZeroExeption("Нельзя делить на ноль");
            }
            System.out.println(number1 / number2);
        }
        catch (DevisionByZeroExeption e) {
            System.out.println("Произошла ошибка " + e.getMessage());        }
        finally {
            System.out.println();
        }
    }

    public class Quest {
        private int qQ;
        public Quest(int q) {
            qQ = 12 / q;//1
        }
        public int getQQ() {
            return qQ;//2
        }
        public void main(String[] args) {
            Quest quest = null;
            try {
                quest = new Quest(0);//3
            } catch (Exception e) {//4
            }
            System.out.println(quest.getQQ());//5
        }
    }

}

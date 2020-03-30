public class Main {
    public static void main(String[] args) {

        Input in = new Input();
        String [][] arrayStr = in.inputArray();
        Array array = new Array();

        for (String[] strings : arrayStr) {
            System.out.println();
            for (int j = 0; j < arrayStr.length; j++) {
                System.out.print(strings[j] + " ");
            }
        }

        System.out.println();
        try{
            System.out.println("Сумма массива = " + array.arrayAmount(arrayStr));
        } catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
        }

    }
}

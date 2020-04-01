import java.util.Scanner;

public class Input {
    public String [][] inputArray(){
        int size = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите размер массива - ");
        boolean etc = true;
        while (etc){
            try {
                size = Integer.parseInt(scan.next());
                etc = false;
            } catch (Exception e) {
                System.out.println("Некорректный ввод");
            }
        }

        String [][] array = new String[size][size];

        System.out.println("Введите массив");
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                array[i][j] = scan.next();
            }
        }
        return array;
    }
}

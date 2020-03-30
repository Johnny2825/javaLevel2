public class Array{
    public int arrayAmount (String [][] arrayStr) throws MyArraySizeException, MyArrayDataException {
        int amount = 0;

        if((arrayStr.length != 4) || (arrayStr[0].length != 4)){
            throw new MyArraySizeException("Size isn't equal");
        }

        for(int i = 0; i < arrayStr.length; i++){
            for(int j = 0; j < arrayStr.length; j++){
                try{
                    amount += Integer.parseInt(arrayStr[i][j]);
              } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Format isn't correct in cell ", i, j);
                }
            }
        }
        return amount;
    }
}

class MyArrayDataException extends Exception{
    public MyArrayDataException(String s, int i, int j){
        System.out.print(s + i + ", " + j + " ");
    }

}

class MyArraySizeException extends Exception{
    public MyArraySizeException(String s) {
        System.out.print(s + " ");
    }
}

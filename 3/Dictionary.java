import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    public static void main(String[] args) {
       firstTask();
       secondTask();
    }

    public static void  firstTask(){
        ArrayList<String> dic = new ArrayList<>();
        dic.add("A");
        dic.add("B");
        dic.add("C");
        dic.add("B");
        dic.add("D");
        dic.add("F");
        dic.add("A");
        dic.add("C");
        dic.add("E");
        dic.add("E");
        dic.add("G");
        dic.add("A");
        dic.add("H");
        dic.add("B");
        dic.add("H");
        dic.add("A");
        System.out.println(dic);
        HashMap<String, Integer> hM = new HashMap<String, Integer>();

        for(String i : dic){
            if(!hM.containsKey(i)){
                hM.put(i, 1);
            } else {
                hM.put(i, hM.get(i) + 1);
            }
        }
        System.out.println(hM);
    }

    public static void secondTask(){
        TelephoneDirectory secTask = new TelephoneDirectory();
        secTask.add(234231, "Petrov");
        secTask.add(234253, "Ivanov");
        secTask.add(777455, "Serov");
        secTask.add(432666, "Petrov");
        secTask.add(211797, "Suchkov");
        secTask.add(435765, "Petrov");
        secTask.add(777777, "Ivanov");

        System.out.println(secTask.getTelDic());

        secTask.get("Ivanov");
    }
}

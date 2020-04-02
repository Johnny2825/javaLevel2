import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

public class TelephoneDirectory {
    private LinkedHashMap<Integer, String> telDic = new LinkedHashMap<>();

    public LinkedHashMap<Integer, String> getTelDic() {
        return this.telDic;
    }

    public void add(Integer number, String surname) {
        telDic.put(number, surname);
    }

    public void get(String surname) {
        ArrayList<Integer> number = new ArrayList<>();
        ArrayList<Integer> keys = new ArrayList<>(telDic.keySet());
        for(Integer i : keys) {
            if (telDic.get(i).equals(surname)) {
                number.add(i);
            }
        }
        for(Integer i : number){
            System.out.println(surname + " - " + i + ";");
        }

    }
}

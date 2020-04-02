import java.util.*;

public class TelephoneDirectory {
    private Map<String, String> telDic = new HashMap<>();

    public Map<String, String> getTelDic() {
        return telDic;
    }


    public void add(String number, String surname) {
        if(telDic.get(surname) != null){
            telDic.put(surname, telDic.get(surname) + ", " + number);
        } else {
            telDic.put(surname, number);
        }

    }

    public void get(String surname) {
        System.out.println(surname + " - " + telDic.get(surname));
    }
}

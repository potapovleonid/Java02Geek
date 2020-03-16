package lists;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class SetWords {
    String[] str;

    SetWords(String[] str) {
            this.str = str;
    }

    public void noDublicate(){
        LinkedHashSet<String> list = hashSet();
        System.out.println(list);
    }

    public LinkedHashSet<String> hashSet (){
        LinkedHashSet<String> list = new LinkedHashSet<>();
        for (int i = 0; i < str.length; i++) {
            list.add(str[i]);
        }
        return list;
    }

    public void numberOfRepetitions(){
        LinkedHashSet<String> list = hashSet();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        for (String st: list) {
            int value = 0;
            for (String word: str) {
                if (st.equals(word)){
                    value++;
                };
                map.put(st, value);
            }
        }

        System.out.println(map);



    }

}

package lists;

import java.util.LinkedList;

public class Testing {
    public static void main(String[] args) {
        String text = "пирожок оладьи сок съем оладьи выпил сок украду я твой носок съел оладьи выпил сок и остался тут пельмень он один а я тюлень";

        SetWords setWords = new SetWords(text.split(" "));
        setWords.noDublicate();
        setWords.numberOfRepetitions();

    }
}

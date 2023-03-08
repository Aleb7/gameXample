package it.gameXample.assets.actions;

import java.util.HashMap;
import java.util.Map;

public class Action {

    protected String question;
    protected HashMap<Integer, Option> options;

    public Action(String question, HashMap<Integer, Option> options) {
        this.question = question;
        this.options = options;
    }

    public String getAnswer(int choice) throws Exception {
        Option o = options.get(choice);
        if(o == null) {
            throw new Exception(String.format("Il comando [%s] non è valido", choice));
        }
        return o.getAnswer();
    }

    public String toString() {
        StringBuilder result = new StringBuilder(question +"\n");
        options.forEach((key, option) -> {                                          // Per ogni coppia chiave-opzione
            String strOption = String.format("[%s] - %s", key, option.toString());  // Creo la stringa dell'opzione
            result.append(strOption).append("\n");                                  // La concateno allo StringBuilder (result)
        });

        result.append("Risposta: ");
        return result.toString();
    }
}

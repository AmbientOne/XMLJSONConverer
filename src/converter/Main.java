package converter;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String in = input.nextLine().trim();
        boolean xml = false, json = false;
        String[] values;

        String value1;
        String value2 = " ";
        String value2xml = " ";
        String newWord = in.replaceAll("[^a-zA-Z0-9.]", " ");
        newWord = newWord.replaceAll("\\s+", " ").trim();

        values = newWord.split(" ");
        value1= values[0];

        for(int i =0; i<values.length; i++) {
            if (!values[i].equals(value1)) {
                if(!values[i].contains(" ") && !values[i].equals("null")) {
                    value2 = values[i];
                    value2xml = values[i];
                    break;
                }
            }
        }



        if(in.startsWith("<")) xml = true;
        else json = true;


        if(xml) {
            String jsonStatic = value2.equals(" ") ? "{\"" + value1 + "\": null"  + "}"
                    : "{\"" + value1 + "\":\"" + value2 + "\"}" ;
          System.out.println(jsonStatic);
        }
        else {
        String xmlStatic = value2xml.contains(" ") ? "<" + value1 + "/>" : "<" + value1 + ">" + value2xml + "</" + value1 + ">";
           System.out.println(xmlStatic);
        }









    }


}

package pl.strojecki;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static pl.strojecki.LandRegisterConst.*;


public class LandRegister {
    private static final Map<Character, Integer> CONWERSIONMAP = createConversionMap();
    private static final List<Integer> WEIGHT = createWeightList();
    private static final Map<String, String> COURTS = createCourts();

    private String court;
    private String number;
    private int sum;


    public LandRegister(String court, String number, int sum) {
        this.court = court.toUpperCase();
        this.number = String.format("%08d", Integer.parseInt(number));
        this.sum = sum;
    }

    public LandRegister(String court, String number) {
        this.court = court.toUpperCase();
        this.number = String.format("%08d", Integer.parseInt(number));
        validate();
    }

    public LandRegister(String string) {
        Pattern pattern = Pattern.compile("([A-Za-z]{2}[0-9][A-Za-z])/([0-9]{1,8})/([0-9])");
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()) {
            court = matcher.group(1).toUpperCase();
            number = String.format("%08d", Integer.parseInt(matcher.group(2)));
            sum = Integer.parseInt(matcher.group(3));
        }
    }

    public boolean isValid() {
        if (!COURTS.containsKey(court)) {
            System.out.println("Wrong court " + court + " number");
            return false;
        }

        return sum == calculateSum(court, number);
    }


    public LandRegister validate() {
        sum = calculateSum(court, number);
        return this;
    }


    private int calculateSum(String court, String number) {

        String allSigns = court + number;
        int result = 0;

        for (int i = 0; i < allSigns.length(); i++) {
            result += CONWERSIONMAP.get(allSigns.charAt(i)) * WEIGHT.get(i);
        }
        result %= 10;

        return result;
    }

    @Override
    public String toString() {
        return court + '/' + number + '/' + sum;
    }
}
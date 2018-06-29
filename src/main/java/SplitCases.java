import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SplitCases extends RegexMapper{

    public static void splitAddress(String address) {
        String expectedStreetNumber = "";
        String expectedStreet = "";

        //Get list of all substrings to address separated by white space
        List<String> substrings_seperated_by_spaces = new ArrayList<>(Arrays.asList(address.split(AFTER_WHITESPACE)));
        try {
            /*--------Check if address has only 2 substring OR address starts with a digit------*/
            if (substrings_seperated_by_spaces.size() == 2 || address.substring(0, 1).matches(START_WITH_DIGIT)) {
                // Regex pattern to match starting with digits
                Pattern pattern = Pattern.compile(START_WITH_DIGIT);
                for (String addressFields : substrings_seperated_by_spaces.stream().filter(element -> pattern.matcher(element).matches()).collect(Collectors.toList())) {
                    List<String> streetNumber = new ArrayList<>();
                    streetNumber.add(addressFields);                   //Fields with digits belong to street number
                    substrings_seperated_by_spaces.remove(addressFields);
                    List<String> street = new ArrayList<>(substrings_seperated_by_spaces);
                    expectedStreet = formattedString(street.toString());
                    expectedStreetNumber = formattedString(streetNumber.toString());
                }
            }
            /*--------Cases where address has > 2 substrings (in complicated/bonus case)--------*/
            else {
                String[] AddressParts = address.split(NUMBER_AFTER_SPACE);
                // See if we get only 2 parts after splitting with digits
                if (AddressParts.length == 2) {
                    expectedStreet = AddressParts[0];
                    expectedStreetNumber = AddressParts[1];
                } else {
                    String[] abdd = AddressParts[1].split(CHARACTER_AFTER_SPACE);
                    expectedStreet = AddressParts[0] + abdd[0];
                    expectedStreetNumber = abdd[1] + AddressParts[2];
                }
            }
            System.out.println("\"" +address +"\"" +" -> " + "\"" + expectedStreet +"\"" +" " + "\"" +expectedStreetNumber + "\"");
        }
       /*--------Cases where address has only 1 fields(wrong value by provider)--------*/
       catch (StringIndexOutOfBoundsException e) {
            org.testng.Assert.fail("Address format is incorrect");
        }
    }
    private static String formattedString(String apartment) {
        return apartment.toString()
                .replace("[", "")  //remove the right bracket
                .replace("]", "")
                .replace(",", "")  //remove the left bracket
                .trim();
    }
}

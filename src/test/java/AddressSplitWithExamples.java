import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddressSplitWithExamples {

    @DataProvider(name = "getSampleAddresses")
    public Object[][] getSampleAddresses() {
        return new Object[][]{
                {"Winterallee 3"},
                {"Musterstrasse 45"},
                {"Blaufeldweg 123B"},
                {"Am Bächle 23" ,},
                {"Auf der Vogelwiese 23 b"},
                {"4, rue de la revolution"},
                {"200 Broadway Av"},
                {"Calle Aduana, 29"},
                {"Calle 39 No 1540"}
        };
    }

    @Test(dataProvider = "getSampleAddresses")
    public void splitGivenAddress(String address) {
            SplitCases.splitAddress(address);
        }
    }

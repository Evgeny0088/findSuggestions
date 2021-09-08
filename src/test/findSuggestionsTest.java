package test;

import com.suggestions.trainee.CompanyNames;
import com.suggestions.trainee.SuggestService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;
import java.text.ParseException;

@RunWith(Parameterized.class)
public class findSuggestionsTest {

    @Parameterized.Parameter(0)
    public String input;
    @Parameterized.Parameter(1)
    public Set<String> expected;

    @Parameterized.Parameters
    public static List<Object[]> data(){
        Object[][] data = {
                {"  ", Collections.emptySet()},
                {"fsjkfsk", Collections.emptySet()},
                {"427381319", Collections.emptySet()},
                {"))))",Collections.emptySet()},
                {"&&$$$", Collections.emptySet()},
                {"G", Set.of("Google")},
                {"",Collections.emptySet()},
                {"--", Collections.emptySet()},
                {"   y",Set.of("YANDEX","YAHOO")},
                {"ap",Set.of("apple")},
                {"a",Set.of("apple","  ALFA")},
                {"c", Set.of("C=OM-p_A-N$Y")},
                {"00",Set.of("000XXXS0VDSD0__")},
                {"s",Set.of("__   some-Company$$Name")},
                {"1.",Set.of("1.3.2.-4.5")}
        };
        return Arrays.asList(data);
    }

    @Test
    public void suggestTest() throws ParseException {
        SuggestService suggestService = new SuggestService(CompanyNames.getCompanies());
        System.out.println("results: ");
        Set<String> companiesTest = suggestService.suggest(input);
        companiesTest.forEach(System.out::println);
        Assertions.assertEquals(expected,companiesTest);
    }
}

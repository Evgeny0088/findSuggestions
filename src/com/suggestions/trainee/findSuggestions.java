package com.suggestions.trainee;

import java.text.ParseException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class findSuggestions {
    public static void main(String[] args) throws ParseException {
        SuggestService suggestService = new SuggestService(CompanyNames.getCompanies());
        System.out.println("###Available companies:###");
        CompanyNames.getCompanies().forEach(System.out::println);
        System.out.println("###enter 'exit' if you want to quit###");
        while (true){
            System.out.println("\n###search company name:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (Objects.equals(input, "exit")){
                System.out.println("bye!");
                System.exit(0);
            }
            Set<String> foundCompanies = suggestService.suggest(input);
            if (foundCompanies.isEmpty()){
                System.out.println("no such company in the list!");
            }else {
                System.out.println("Found Companies:");
                foundCompanies.forEach(System.out::println);
            }
        }
    }
}

package com.suggestions.trainee;

import java.text.ParseException;
import java.util.Collections;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class SuggestService {

    private final Set<String> CompanyNames;

    public SuggestService(Set<String> Companies){
        this.CompanyNames = Companies;
    }

    public Set<String> suggest(String input) throws ParseException {
        try{
            String regex = "[^a-zA-Z0-9]";
            String input_refined = input.replaceAll(regex,"").toLowerCase();
            if (input_refined.isEmpty()){
                return Collections.emptySet();
            }
            Pattern pattern = Pattern.compile(input_refined + ".*");
            return CompanyNames.stream().filter(company->{
                String companyNameStripped = company.replaceAll(regex,"");
                int last_index = Math.min(input_refined.length(), companyNameStripped.length());
                Matcher matcher = pattern.matcher(companyNameStripped.toLowerCase().substring(0,last_index));
                return matcher.find();}).collect(Collectors.toSet());
        }catch (PatternSyntaxException e){
            throw new ParseException("that symbol is not allowed, please try again",e.getIndex());
        }
    }
}

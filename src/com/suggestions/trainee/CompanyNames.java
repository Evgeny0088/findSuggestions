package com.suggestions.trainee;

import java.util.Set;

public class CompanyNames {
    private static final Set<String> Companies = Set.of(
            "YANDEX","Google","apple","fsdkjfsdkfjksld",
            "000XXXS0VDSD0__","XXXXXXXXXX_AAAAAAA","new Company Name",
            "C=OM-p_A-N$Y", "YAHOO", "  ALFA", "Johnson&Johnson","1.3.2.-4.5",
            "mmm_aaa...","__   some-Company$$Name", "(undefined)",
            "user_(company)","...\\\\"
    );

    public static Set<String> getCompanies() {
        return Companies;
    }
}

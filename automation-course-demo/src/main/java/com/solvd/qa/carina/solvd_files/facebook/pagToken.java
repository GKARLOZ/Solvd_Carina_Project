package com.solvd.qa.carina.solvd_files.facebook;

public class pagToken {

    private final String A = "EAAYKMfI5fVYBAHp2U8ElIKjYogunXs1GFyYbBCWnbDvzQl3";
    private final String B = "GUSw8M7RpeBCTYbME5NuCl6RgBgZB96JimZAYtVGdHYguGipg";
    private final String C = "RA3BBIHH5Y24z2tdVyqBo0aq2JsgFHROdtQQ8LQb9pdDbvJ256";
    private final String D = "302mZCfeRO8WAZBvLpqXf9AWjhA47SLxHsfE7RiwXj1csZD";

    public pagToken(){
    }

    public String getToken(){
        String t = A+B+C+D;
        return t;
    }


}

package com.ancestry.cemetery.Utils;

import com.ancestry.cemetery.Presenter.Model.Memorial;

/**
 * Created by adarsh on 4/5/2017.
 */

public class DateHelperClass {

    public static StringBuilder getDateOfDeath(Memorial memorial) {
        StringBuilder dateOfDeath = new StringBuilder();
        if(memorial.getDeathDay()!=null && memorial.getDeathMonth()!=null &&
                memorial.getDeathYear()!=null){
            dateOfDeath.append(memorial.getDeathMonth());
            dateOfDeath.append("/");
            dateOfDeath.append(memorial.getDeathDay());
            dateOfDeath.append("/");
            dateOfDeath.append(memorial.getDeathYear());
        }
        return dateOfDeath;
    }

    public static StringBuilder getDateOfBirth(Memorial memorial) {
        StringBuilder dateOfBirth = new StringBuilder();
        if(memorial.getBirthDay()!=null && memorial.getBirthMonth()!=null &&
                memorial.getBirthYear()!=null){
            dateOfBirth.append(memorial.getBirthMonth());
            dateOfBirth.append("/");
            dateOfBirth.append(memorial.getBirthDay());
            dateOfBirth.append("/");
            dateOfBirth.append(memorial.getBirthYear());
        }
        return dateOfBirth;
    }
}

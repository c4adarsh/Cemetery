package com.ancestry.cemetery.Presenter.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by adarsh on 4/4/2017.
 */

public class Memorial implements Parcelable {

    String memorialId;

    String firstName;

    String lastName;

    String maidenName;

    String birthMonth;

    String birthDay;

    String birthYear;

    String deathMonth;

    String deathDay;

    String deathYear;

    String cemeteryId;

    String cemeteryName;

    String cemeteryCountyName;

    String thumbnailUrl;

    public Memorial(String memorialId, String firstName, String lastName, String maidenName, String birthMonth, String birthDay, String birthYear, String deathMonth, String deathDay, String deathYear, String cemeteryId, String cemeteryName, String cemeteryCountyName, String thumbnailUrl) {
        this.memorialId = memorialId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.maidenName = maidenName;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthYear = birthYear;
        this.deathMonth = deathMonth;
        this.deathDay = deathDay;
        this.deathYear = deathYear;
        this.cemeteryId = cemeteryId;
        this.cemeteryName = cemeteryName;
        this.cemeteryCountyName = cemeteryCountyName;
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getMemorialId() {
        return memorialId;
    }

    public void setMemorialId(String memorialId) {
        this.memorialId = memorialId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getDeathMonth() {
        return deathMonth;
    }

    public void setDeathMonth(String deathMonth) {
        this.deathMonth = deathMonth;
    }

    public String getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(String deathDay) {
        this.deathDay = deathDay;
    }

    public String getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(String deathYear) {
        this.deathYear = deathYear;
    }

    public String getCemeteryId() {
        return cemeteryId;
    }

    public void setCemeteryId(String cemeteryId) {
        this.cemeteryId = cemeteryId;
    }

    public String getCemeteryName() {
        return cemeteryName;
    }

    public void setCemeteryName(String cemeteryName) {
        this.cemeteryName = cemeteryName;
    }

    public String getCemeteryCountyName() {
        return cemeteryCountyName;
    }

    public void setCemeteryCountyName(String cemeteryCountyName) {
        this.cemeteryCountyName = cemeteryCountyName;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.memorialId);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.maidenName);
        dest.writeString(this.birthMonth);
        dest.writeString(this.birthDay);
        dest.writeString(this.birthYear);
        dest.writeString(this.deathMonth);
        dest.writeString(this.deathDay);
        dest.writeString(this.deathYear);
        dest.writeString(this.cemeteryId);
        dest.writeString(this.cemeteryName);
        dest.writeString(this.cemeteryCountyName);
        dest.writeString(this.thumbnailUrl);
    }

    protected Memorial(Parcel in) {
        this.memorialId = in.readString();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.maidenName = in.readString();
        this.birthMonth = in.readString();
        this.birthDay = in.readString();
        this.birthYear = in.readString();
        this.deathMonth = in.readString();
        this.deathDay = in.readString();
        this.deathYear = in.readString();
        this.cemeteryId = in.readString();
        this.cemeteryName = in.readString();
        this.cemeteryCountyName = in.readString();
        this.thumbnailUrl = in.readString();
    }

    public static final Parcelable.Creator<Memorial> CREATOR = new Parcelable.Creator<Memorial>() {
        @Override
        public Memorial createFromParcel(Parcel source) {
            return new Memorial(source);
        }

        @Override
        public Memorial[] newArray(int size) {
            return new Memorial[size];
        }
    };
}

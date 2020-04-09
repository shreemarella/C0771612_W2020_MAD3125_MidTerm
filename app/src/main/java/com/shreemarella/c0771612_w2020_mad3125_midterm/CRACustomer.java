package com.shreemarella.c0771612_w2020_mad3125_midterm;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.DatePicker;
import android.widget.TextView;

public class CRACustomer implements Parcelable
{
    private String currentDate;
    private String sinNo;
    private String firstName;
    private String lastName;
    private String Birthdate;
    private String age;
    private String Gender;
    private Double GrossIncome;
    private Double RRSP;

    protected CRACustomer(Parcel in) {
        currentDate = in.readString();
        sinNo = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        Birthdate = in.readString();
        age = in.readString();
        Gender = in.readString();
        if (in.readByte() == 0) {
            GrossIncome = null;
        } else {
            GrossIncome = in.readDouble();
        }
        if (in.readByte() == 0) {
            RRSP = null;
        } else {
            RRSP = in.readDouble();
        }
    }

    public CRACustomer()
    {

    }

    public CRACustomer(String currentDate, String sinNo, String firstName, String lastName, String birthdate, String age, String gender, Double grossIncome, Double RRSP) {
        this.currentDate = currentDate;
        this.sinNo = sinNo;
        this.firstName = firstName;
        this.lastName = lastName;
        Birthdate = birthdate;
        this.age = age;
        Gender = gender;
        GrossIncome = grossIncome;
        this.RRSP = RRSP;
    }

//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(currentDate);
//        dest.writeString(sinNo);
//        dest.writeString(firstName);
//        dest.writeString(lastName);
//        dest.writeString(Birthdate);
//        dest.writeString(age);
//        dest.writeString(Gender);
//        if (GrossIncome == null) {
//            dest.writeByte((byte) 0);
//        } else {
//            dest.writeByte((byte) 1);
//            dest.writeDouble(GrossIncome);
//        }
//        if (RRSP == null) {
//            dest.writeByte((byte) 0);
//        } else {
//            dest.writeByte((byte) 1);
//            dest.writeDouble(RRSP);
//        }
//
//    }
//    public static final Creator<CRACustomer> CREATOR = new Creator<CRACustomer>() {
//        @Override
//        public CRACustomer createFromParcel(Parcel in) {
//            return new CRACustomer(in);
//        }
//
//        @Override
//        public CRACustomer[] newArray(int size) {
//            return new CRACustomer[size];
//        }
//    };
//
//    public String getCurrentDate() {
//        return currentDate;
//    }
//
//    public void setCurrentDate(String currentDate) {
//        this.currentDate = currentDate;
//    }
//
//    public String getSinNo() {
//        return sinNo;
//    }
//
//    public void setSinNo(String sinNo) {
//        this.sinNo = sinNo;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getBirthdate() {
//        return Birthdate;
//    }
//
//    public void setBirthdate(String birthdate) {
//        Birthdate = birthdate;
//    }
//
//    public String getAge() {
//        return age;
//    }
//
//    public void setAge(String age) {
//        this.age = age;
//    }
//
//    public String getGender() {
//        return Gender;
//    }
//
//    public void setGender(String gender) {
//        Gender = gender;
//    }
//
//    public Double getGrossIncome() {
//        return GrossIncome;
//    }
//
//    public void setGrossIncome(Double grossIncome) {
//        GrossIncome = grossIncome;
//    }
//
//    public Double getRRSP() {
//        return RRSP;
//    }
//
//    public void setRRSP(Double RRSP) {
//        this.RRSP = RRSP;
//    }
//
//    public static Creator<CRACustomer> getCREATOR() {
//        return CREATOR;
//    }
}

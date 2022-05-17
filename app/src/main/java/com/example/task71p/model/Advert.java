package com.example.task71p.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Date;

public class Advert implements Parcelable {
    private int _advertID;
    private String _type;
    private String _name;
    private String _phoneNo;
    private String _description;
    private String _date;
    private String _location;

    public Advert(String type, String name, String phoneNo, String description, String date, String location) {
        _type = type;
        _name = name;
        _phoneNo = phoneNo;
        _description = description;
        _date = date;
        _location = location;
    }

    //empty constructor
    public Advert() {
    }

    protected Advert(Parcel in) {
        _advertID = in.readInt();
        _type = in.readString();
        _name = in.readString();
        _phoneNo = in.readString();
        _description = in.readString();
        _date = in.readString();
        _location = in.readString();
    }

    public static final Creator<Advert> CREATOR = new Creator<Advert>() {
        @Override
        public Advert createFromParcel(Parcel in) {
            return new Advert(in);
        }

        @Override
        public Advert[] newArray(int size) {
            return new Advert[size];
        }
    };

    @NonNull @Override
    public String toString() {
        String string = _type + ": " + _description;
        return string;
    }

    public int get_advertID() {
        return _advertID;
    }

    public void set_advertID(int _advertID) {
        this._advertID = _advertID;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_phoneNo() {
        return _phoneNo;
    }

    public void set_phoneNo(String _phoneNo) {
        this._phoneNo = _phoneNo;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public String get_date() {
        return _date;
    }

    public void set_date(String _date) {
        this._date = _date;
    }

    public String get_location() {
        return _location;
    }

    public void set_location(String _location) {
        this._location = _location;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(_advertID);
        parcel.writeString(_type);
        parcel.writeString(_name);
        parcel.writeString(_phoneNo);
        parcel.writeString(_description);
        parcel.writeString(_date);
        parcel.writeString(_location);
    }
}

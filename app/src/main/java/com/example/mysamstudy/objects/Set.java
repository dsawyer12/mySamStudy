package com.example.mysamstudy.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;

public class Set implements Parcelable{
    private String setName;
    private int setId, FK;
    private int setSize = 0;
    private boolean share;
    private ArrayList<Card> cards;
    private boolean isSelected;

    public Set() {}

    public Set(String setName, int FK) {
        this.setName = setName;
        this.FK = FK;
        cards = null;
    }

    public Set(int id, String setName, int setSize, int FK) {
        this.setId = id;
        this.setName = setName;
        this.setSize = setSize;
        this.FK = FK;
    }


    public Set(int id, String setName, int setSize, boolean share, int FK) {
        this.setId = id;
        this.setName = setName;
        this.setSize = setSize;
        this.share = share;
        this.FK = FK;
    }

    protected Set(Parcel in) {
        setName = in.readString();
        setId = in.readInt();
        FK = in.readInt();
        setSize = in.readInt();
        share = in.readByte() != 0;
        cards = in.createTypedArrayList(Card.CREATOR);
        isSelected = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(setName);
        dest.writeInt(setId);
        dest.writeInt(FK);
        dest.writeInt(setSize);
        dest.writeByte((byte) (share ? 1 : 0));
        dest.writeTypedList(cards);
        dest.writeByte((byte) (isSelected ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Set> CREATOR = new Creator<Set>() {
        @Override
        public Set createFromParcel(Parcel in) {
            return new Set(in);
        }

        @Override
        public Set[] newArray(int size) {
            return new Set[size];
        }
    };

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getFK() {
        return FK;
    }

    public void setFK(int FK) {
        this.FK = FK;
    }

    public boolean isShare() {
        return share;
    }

    public void setShare(boolean share) {
        this.share = share;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public int getSetId() {
        return setId;
    }

    public void setSetId(int setId) {
        this.setId = setId;
    }

    public int getSetSize() {
        return setSize;
    }

    public void setSetSize(int setSize) {
        this.setSize = setSize;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

}

package com.example.mysamstudy.objects;

import android.os.Parcel;
import android.os.Parcelable;

public class Card implements Parcelable {
    private int cardID, FK;
    private String cardQuestion, cardAnswer;
    private boolean isSelected;

    public Card(){}

    public Card(int cardId, String cardQuestion, String cardAnswer, int FK) {
        this.cardID = cardId;
        this.cardQuestion = cardQuestion;
        this.cardAnswer = cardAnswer;
        this.FK = FK;
    }

    public Card(String cardQuestion, String cardAnswer, int FK) {
        this.cardQuestion = cardQuestion;
        this.cardAnswer = cardAnswer;
        this.FK = FK;
    }

    protected Card(Parcel in) {
        cardID = in.readInt();
        cardQuestion = in.readString();
        cardAnswer = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(cardID);
        dest.writeInt(FK);
        dest.writeString(cardQuestion);
        dest.writeString(cardAnswer);
        dest.writeByte((byte) (isSelected ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Card> CREATOR = new Creator<Card>() {
        @Override
        public Card createFromParcel(Parcel in) {
            return new Card(in);
        }

        @Override
        public Card[] newArray(int size) {
            return new Card[size];
        }
    };

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public int getFK() {
        return FK;
    }

    public void setFK(int FK) {
        this.FK = FK;
    }

    public String getCardQuestion() {
        return cardQuestion;
    }

    public void setCardQuestion(String cardQuestion) {
        this.cardQuestion = cardQuestion;
    }

    public String getCardAnswer() {
        return cardAnswer;
    }

    public void setCardAnswer(String cardAnswer) {
        this.cardAnswer = cardAnswer;
    }
}

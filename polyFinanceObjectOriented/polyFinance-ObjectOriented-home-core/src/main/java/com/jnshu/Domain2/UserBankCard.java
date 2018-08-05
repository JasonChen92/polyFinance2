package com.jnshu.Domain2;

public class UserBankCard {
    private Long userId;
    private Long cardId;
    private String bankCard;
    private String bankName;

    public UserBankCard() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "UserBankCard{" +
                "userId=" + userId +
                ", cardId=" + cardId +
                ", bankCard='" + bankCard + '\'' +
                ", bankName='" + bankName + '\'' +
                '}' +"\n";
    }
}

package com.example.Walletpart2.Walletpart2.Model;

public class History {
    private String historyId ;
    private String accountId ;
    private String transactionId ;
    private Double solde ;

    public History(String historyId, String accountId, String transactionId, Double solde) {
        this.historyId = historyId;
        this.accountId = accountId;
        this.transactionId = transactionId;
        this.solde = solde;
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "SoldeHistorique{" +
                "historyId='" + historyId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", solde=" + solde +
                '}';
    }
}

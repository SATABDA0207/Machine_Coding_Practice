package com.splitwiseApplication.models;

import lombok.Builder;
import lombok.Data;

import java.util.*;

@Builder
@Data
public class User {
    private String userId;
    private Map<String, Integer> expenseMap;
    private Integer totalBalance;

    public void addUser(String userId){
        this.expenseMap.put(userId, 0);
    }

    public void addExpenseForLender(Integer lendingAmount, Integer borrowerAmount){
        totalBalance += lendingAmount;
        for(Map.Entry<String, Integer> entry : expenseMap.entrySet()){
//            if(entry.getValue() > 0){
//                entry.setValue(entry.getValue() - borrowerAmount);
//            }else{
//                entry.setValue(borrowerAmount - entry.getValue());
//            }
            Integer i = entry.getValue() >= 0 ? entry.setValue(entry.getValue() - borrowerAmount)
                    : entry.setValue(borrowerAmount - entry.getValue());
        }
    }

    public void addExpenseForBorrower(Integer borrowerAmount, String lenderUserId){
        totalBalance -= borrowerAmount;
        expenseMap.put(lenderUserId, expenseMap.get(lenderUserId) - borrowerAmount);
    }

    public void printUser(){
        System.out.println("**** User Details ****");
        System.out.println("User ID: " + userId);
        System.out.println("Expenses: " + expenseMap);
    }
}

package com.splitwiseApplication.models;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class UserList {
    private List<User> userList;

    public void addUser(String userId){
        Map<String, Integer> userMap = new HashMap<>();
        for (User value : userList) {
            userMap.put(value.getUserId(), 0);
        }

        User user = User.builder().totalBalance(0).userId(userId).expenseMap(userMap).build();

        for (User value : userList) {
            value.addUser(userId);
        }

        userList.add(user);
    }

    public void addExpanse(String userId, Integer amount, ExpenseType expenseType){
        if(expenseType.equals(ExpenseType.EQUAL)){
            Integer lenderAmount = amount - (amount/ userList.size());
            Integer borrowerAmount = amount/ userList.size();
            for(User user : userList){
                if(user.getUserId().equals(userId)){
                    user.addExpenseForLender(lenderAmount, borrowerAmount);
                }else{
                    user.addExpenseForBorrower(borrowerAmount, userId);
                }
            }
        }
    }

    public void printUserList(){
        System.out.println(userList);
    }
}

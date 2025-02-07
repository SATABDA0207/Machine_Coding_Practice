import com.splitwiseApplication.models.ExpenseType;
import com.splitwiseApplication.models.User;
import com.splitwiseApplication.models.UserList;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class SplitwiseApplication {
    private UserList userList;

    public void createUserList(){
        this.userList = UserList.builder()
                .userList(new ArrayList<>())
                .build();
    }

    public void addUser(String userId){
        userList.addUser(userId);
    }

    public void printUsers(){
        userList.printUserList();
    }

    public void addExpanse(String userId, Integer amount, ExpenseType expenseType){
        userList.addExpanse(userId, amount, expenseType);
    }
}

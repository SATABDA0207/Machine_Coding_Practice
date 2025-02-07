import com.splitwiseApplication.models.ExpenseType;
import com.splitwiseApplication.models.User;
import com.splitwiseApplication.models.UserList;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static SplitwiseApplication splitwiseApplication = new SplitwiseApplication();

    public static void main(String[] args) {
        splitwiseApplication.createUserList();
        splitwiseApplication.addUser("u1");
        splitwiseApplication.addUser("u2");
        splitwiseApplication.addUser("u3");
        splitwiseApplication.addUser("u4");
        splitwiseApplication.addExpanse("u1", 1000, ExpenseType.EQUAL);
        splitwiseApplication.printUsers();
        splitwiseApplication.addExpanse("u1", 500, ExpenseType.EQUAL);
        splitwiseApplication.printUsers();
        splitwiseApplication.addExpanse("u2", 1200, ExpenseType.EQUAL);
        splitwiseApplication.printUsers();
    }

}
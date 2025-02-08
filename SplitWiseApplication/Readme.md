
Design and implement an In Memory Expense sharing application
where users should be able to add expenses and split it among users. Ex - Splitwise

1. Expose function to add user
2. User should be able to add expense which could be divided equally.
3. Expose a function to get balance of a user
   [this should give final balance of user and simplified balance with each user].
4. For interview we need only equal split to be implemented but solution should be extensible
   for other type of expense like unequal split or percentage split.
   
   
   -1000

   1. u1->u2 500
   2. u1->u3 500
   3. u4->u1 500
   4. u1->u5 500
   5. E1 u1->u2 700
   6. E2 u2->u1 200
   7. == u1->u2 500

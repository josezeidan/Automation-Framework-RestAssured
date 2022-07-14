package utils;

import pojo.Expense;

public class MealBUtils {

  //private static Expense exp;

    public static Expense expBuilder(String name, double amount, String expenseDateTime,
                                     String expenseType, Integer otherExpenseNameId){

        return  new Expense(name,amount,expenseDateTime,expenseType,otherExpenseNameId);

    }

    public static Expense expBuilder(String name, double amount, String expenseDateTime,
                                     String expenseType){

        return  new Expense(name,amount,expenseDateTime,expenseType);

    }

}

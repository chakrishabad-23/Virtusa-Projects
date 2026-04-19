from expense import Expense
from expense_manager import ExpenseManager
class main:
    while True:
        print("\nExpense Tracker")
        print("1. Add Expense")
        print("2. View Expenses")
        print("3.Summarize")
        print("4. Exit")
        option = input("Choose an option:  ")
        if option == '1':
            date = input("Enter date (YYYY-MM-DD): ")
            category = input("Enter category: ")
            amount = input("Enter amount: ")
            description = input("Enter description: ")
            expense = Expense(date, category, amount, description)
            with open('expenses.csv', 'a') as file:
                file.write(f"{expense.date},{expense.category},{expense.amount},{expense.description}\n")
            print("Expense added successfully!")
        elif option == '2':
            exp_man = ExpenseManager()
            exp_man.view_expense()
        elif option == '3':
            exp_man = ExpenseManager()
            exp_man.summarize_expenses()
        elif option == '4':
            print("Exiting the program.")
            break
        else:
            print("Invalid option. Please try again.")

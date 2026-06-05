from expense import Expense
from expense_manager import ExpenseManager

while True:

    print("\nExpense Tracker")

    print("1. Add Expense")
    print("2. View Expenses")
    print("3. Total Summary")
    print("4. Monthly Summary")
    print("5. Category Summary")
    print("6. Highest Spending Category")
    print("7. Expense Pie Chart")
    print("8. Spending Suggestion")
    print("9. Exit")

    option = input("Choose Option: ")

    if option == '1':

        date = input("Enter Date (YYYY-MM-DD): ")
        category = input("Enter Category: ")
        amount = input("Enter Amount: ")
        description = input("Enter Description: ")

        expense = Expense(
            date,
            category,
            amount,
            description
        )

        with open('expenses.csv', 'a') as file:
            file.write(
                f"{expense.date},{expense.category},{expense.amount},{expense.description}\n"
            )

        print("Expense Added Successfully")

    elif option == '2':

        ExpenseManager().view_expense()

    elif option == '3':

        ExpenseManager().summarize_expenses()

    elif option == '4':

        ExpenseManager().monthly_summary()

    elif option == '5':

        ExpenseManager().category_summary()

    elif option == '6':

        ExpenseManager().highest_spending_category()

    elif option == '7':

        ExpenseManager().pie_chart()

    elif option == '8':

        ExpenseManager().spending_suggestion()

    elif option == '9':

        print("Exiting...")
        break

    else:

        print("Invalid Option")

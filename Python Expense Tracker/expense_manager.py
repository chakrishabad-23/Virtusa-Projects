import pandas as pd
import matplotlib.pyplot as plt

class ExpenseManager:

    def view_expense(self):
        df = pd.read_csv('expenses.csv')
        print(df)

    def summarize_expenses(self):
        df = pd.read_csv('expenses.csv')

        df['amount'] = pd.to_numeric(df['amount'])

        print("\nTotal Expense:", df['amount'].sum())

    def monthly_summary(self):
        df = pd.read_csv('expenses.csv')

        df['date'] = pd.to_datetime(df['date'])

        df['month'] = df['date'].dt.month

        monthly = df.groupby('month')['amount'].sum()

        print("\nMonthly Summary")
        print(monthly)

    def category_summary(self):
        df = pd.read_csv('expenses.csv')

        category = df.groupby('category')['amount'].sum()

        print("\nCategory Wise Expenses")
        print(category)

    def highest_spending_category(self):
        df = pd.read_csv('expenses.csv')

        category = df.groupby('category')['amount'].sum()

        highest = category.idxmax()

        print("\nHighest Spending Category:", highest)
        print("Amount:", category.max())

    def spending_suggestion(self):
        df = pd.read_csv('expenses.csv')

        category = df.groupby('category')['amount'].sum()

        highest = category.idxmax()

        print("\nSuggestion")
        print(f"You are spending most on {highest}.")
        print("Consider reducing expenses in this category.")

    def pie_chart(self):
        df = pd.read_csv('expenses.csv')

        category = df.groupby('category')['amount'].sum()

        plt.figure(figsize=(7,7))
        plt.pie(
            category,
            labels=category.index,
            
        )

        plt.title("Category Wise Expense Distribution")
        plt.show()

import pandas as pd
import matplotlib.pyplot as plt
class ExpenseManager:

    def view_expense(self):
        df=pd.read_csv('expenses.csv')
        print(df)
    def summarize_expenses(self):
        df=pd.read_csv('expenses.csv')
        df['amount'] = pd.to_numeric(df['amount'], errors='coerce')
        print(df['amount'].sum())

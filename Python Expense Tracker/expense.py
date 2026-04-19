
class Expense:
    def __init__(self, date, category, amount, description):
        self.date = date
        self.category = category.strip()
        self.amount = float(amount)
        self.description = description.strip()

   

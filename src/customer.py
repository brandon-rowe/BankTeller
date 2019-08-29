# customer.py
# simulation of a bank teller
class Customer:
    def __init__(self, name, uname, pword, balance):
        self.name = name
        self.uname = uname
        self.pword = pword
        self.balance = balance

    def withdraw(self, witAmt):
        self.balance -= witAmt
        print("Your balance is ", self.balance, " after withdraw.")
    def deposit(self, depAmt):
        self.balance += depAmt
        print("Your balance is ", self.balance, " after deposit.")
    def checkBalance(self):
        print("Your balance is ", self.balance)
    def toString(obj):
        print("Hello " + obj.name)
        print("Your username is " + obj.uname)
        print("Your password is " + obj.pword)
        print("Your balance is " + obj.balance)

def main():
    customer1 = Customer("Brandon", "bhrowe", "pword", 1000.00)
    customer1.deposit(100)
    customer1.withdraw(150)
    customer2 = Customer("Conner", "conmur", "pword1", 2000.00)
    customer2.deposit(100)
    customer2.withdraw(150)
    customer3 = Customer("Josh", "jhow", "pword2", 3000.00)
    customer3.deposit(100)
    customer3.withdraw(150)

if __name__ == "__main__":
    main()

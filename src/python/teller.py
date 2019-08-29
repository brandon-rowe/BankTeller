# teller.py
# simulation of a bank teller

def main():
    printIntro()

def printIntro():
    print()
    print("Hello, welcome to your bank teller. ")
    print()
    x = input("Are you a current customer? (Y/N or y/n) ")
    if x == "Y" or x == "y":
        login()
    else:
        newCustomer()

def login():
    uname = input("Please enter your username. ")
    print()
    pword = input("Please enter your password. ")
    print()
    credCheck(uname, pword)
    accountFunc(uname, pword)

def newCustomer():
    uname = input("Please enter a new username. ")
    print()
    pword = input("Please enter a new password. ")
    print()
    newCredCheck(uname, pword)
    accountFunc(uname, pword)

def credCheck(uname, pword):
    #This is where we would have some kind of database check for the credentials.
    if uname == uname:
        if pword == pword:
            print("Success")


def newCredCheck(uname, pword):
    #This is where we would have some kind of database check for the credentials.
    if uname == uname:
        if pword == pword:
            print("Success")

def accountFunc(uname, pword):
    balance = 0.00
    print("Hello ", uname)
    command = input("What would you like to do today? (Deposit(D/d), Withdraw(W/w), or Check Balance(C/c)) ")
    if command == "D" or command == "d":
        depAmt = float(input("How much would you like to deposit? "))
        balance = deposit(depAmt, balance)
        print("Your balance after deposit is: ", balance)
    elif command == "W" or command == "w":
        witAmt = float(input("How much would you like to withdraw? "))
        balance = withdraw(witAmt, balance)
        print("Your balance after withdraw is: ", balance)
    else:
        checkBalance(balance)

def withdraw(witAmt, balance):
    balance -= witAmt
    return balance
def deposit(depAmt, balance):
    balance += depAmt
    return balance
def checkBalance(balance):
    print("Your balance is ", balance)


if __name__ == '__main__': main()

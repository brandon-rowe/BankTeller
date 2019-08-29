# teller.py
# simulation of a bank teller

def main():
    printIntro()

def printIntro():
    print()
    print("Hello, welcome to your bank teller. ")
    print()
    x = input("Are you a current customer? ")
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

def newCustomer():
    uname = input("Please enter a new username. ")
    print()
    pword = input("Please enter a new password. ")
    print()
    newCredCheck(uname, pword)

def credCheck(uname, pword):


def newCredCheck(uname, pword):


if __name__ == '__main__': main()

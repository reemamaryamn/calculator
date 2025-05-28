operation= ["Addition","+", "Subtraction", "-", "Multiplication", "*", "Division", "/", "%", "**", "//", "exit"]

try:
    while True:
        num1=int(input("Enter first number: "))
        num2=int(input("Enter second number: "))

        for o in operation:
            print(o)
        
        operator= input("What operations do you wanna use? ")

        if operator.lower()=="exit":
            print("calculator exited")
            break


        result= None

        if operator=="Addition" or operator=="+":
            result=num1+num2
        elif operator=="Subtraction" or operator=="-":
            result=num1-num2
        elif operator=="Multiplication" or operator=="*":
            result=num1*num2
        elif operator=="Division" or operator=="/":
            if (num2!=0):
                result=num1/ num2
            else: print("cannot divide by zero")
        elif operator=="%":
            result=num1%num2
        elif operator=="**":
            result=num1**num2
        elif operator=="//":
            result=num1//num2
        else: print("invalid operation")

        if result is not None:
            print(result)
    
except ValueError:
    print("Please enter valid integers!")



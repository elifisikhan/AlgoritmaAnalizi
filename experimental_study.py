import random
def get_n_random_numbers(n=10,min_=-5,max_=5):
    numbers=[]
    for i in range(n):
        numbers.append(random.randint(min_,max_))
    return numbers

def my_linear_search(my_list,item_search): #O(n)
    found=(-1,-1)
    n=len(my_list)
    for indis in range(n):
        if my_list[indis]==item_search:
            found=(my_list[indis],indis)
            break 
    return found

def my_experimental_study(iterNum=50):
    cost=[]
    x_low=-100
    x_high=+100
    array_size=40
    print("array size : ", array_size)
    for iteration in range(iterNum):
        my_list=get_n_random_numbers(array_size,x_low,x_high)
        my_search_item=get_n_random_numbers(1,x_low,x_high)
        my_search_item=my_search_item[0]

        result=my_linear_search(my_list,my_search_item)
        if (result[1]==-1):
            cost.append(array_size)
        else:
            cost.append(result[1])
        print(result)
    return cost
    
c_s=my_experimental_study()

import matplotlib.pyplot as plt
c_s
plt.plot(c_s)

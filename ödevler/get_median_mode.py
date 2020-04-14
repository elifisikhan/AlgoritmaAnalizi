# Elif Işıkhan 160401060

def get_median_mode(list_1):

    n = len(list_1)

    # bubble sort ----------------
    # Worst time O(N^2)----------
    # Average time O(N^2)--------
    # Best time O(N)
    for i in range(n):             
        for j in range(0, n-i-1):   
            if list_1[j] > list_1[j+1] :
                list_1[j], list_1[j+1] = list_1[j+1], list_1[j]
    
    # median ---------------------
    # Worst time O(1)----------
    # Average time O(1)--------
    # Best time O(1)
    if n % 2 == 0: 
        med1 = list_1[n//2] 
        med2 = list_1[n//2 - 1] 
        median = (med1 + med2)/2
    else: 
        median = list_1[n//2]
   

    # mode ---------------------
    # Worst time O(n)----------
    # Average time O(n)--------
    # Best time O(n)
    freq={}
    for i in list_1: #O(n)
        if i in freq:
            freq[i]=freq[i]+1
        else:
            freq[i]=1
    max=1
    mode=0
    for i in freq.keys(): #O(n)
        if freq[i]>max:
            max=freq[i]
            mode=i
    if mode == 0:
        print("mode is not found")


    return median, mode
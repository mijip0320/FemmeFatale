from math import factorial

def solution(n, k):
    answer = []
    people = [i for i in range(1, n + 1)]
    k -= 1
    while n != 0:
        a = k // factorial(n - 1)
        answer.append(people[a])
        people.remove(people[a])
        k = k % factorial(n - 1)
        n -= 1

    return answer
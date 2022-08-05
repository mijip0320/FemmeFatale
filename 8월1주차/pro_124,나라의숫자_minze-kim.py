def solution(n):
    answer = ''
    while n:
        if n%3:
            answer = str(n%3) + answer
            n //= 3
        else: 
            answer = '4' + answer
            n //= 3
            n -= 1

    return answer

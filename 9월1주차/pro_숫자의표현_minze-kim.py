def solution(n):
    answer = 1
    for i in range(1, n//2+1):
        num = 0
        for j in range(i, n+1):
            num += j
            if num == n:
                answer += 1
                break
            if num>n:
                break
    return answer
출처: https://hello-i-t.tistory.com/51 [저녁 하늘의 종이 비행기:티스토리]

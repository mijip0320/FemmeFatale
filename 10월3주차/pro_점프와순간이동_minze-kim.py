def solution(n):
    ans = 0
    q = n
    while q > 1:
        if q % 2:
            q -= 1
            ans += 1
        else:
            q /= 2

    return ans + 1
from itertools import permutations
def solution(k, dungeons):
    answer = 0
    for orders in permutations(range(0,len(dungeons)),len(dungeons)):
        now = 0
        now_k = k
        for order in orders:
            if dungeons[order][0] <= now_k:
                now_k -= dungeons[order][1]
                now += 1
            else:
                break
        if now > answer:
            answer = now
    return answer

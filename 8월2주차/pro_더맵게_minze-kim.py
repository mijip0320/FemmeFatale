# 정렬(효율성zero)
#def solution(scoville,K):
#    answer = 0 
#    scoville.sort()
#    while scoville[0] < K and len(scoville) > 1:
#        scoville[1] = scoville[0] + (scoville[1]*2)
#        scoville.pop(0)
#        scoville.sort()
#        answer += 1
#    return answer if scoville[0] >= K else -1

import heapq
def solution(scoville,K):
    answer = 0
    heapq.heapify(scoville)
    while scoville[0] < K and len(scoville) > 1:
        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville) 
        heapq.heappush(scoville, first+(second*2))
        answer += 1
    return answer if scoville[0] >= K else -1

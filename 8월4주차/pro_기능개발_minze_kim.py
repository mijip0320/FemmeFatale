# 이전코드 | 시간복잡도(O(n^2))
# def solution(progresses, speeds):
#     answer = []
#     while progresses:
#         for i in range(len(progresses)):
#             progresses[i] += speeds[i]
#             cnt = 0
#         while progresses and progresses[0] >= 100:
#             progresses.pop(0)
#             speeds.pop(0)
#             cnt += 1
#         if cnt:
#             answer.append(cnt)
#     return answer

def solution(progresses, speeds):
    answer = []
    cnt = 0
    days = 1
    while progresses:
        if progresses[0] + (days*speeds[0]) >= 100:
            cnt += 1
            progresses.pop(0)
            speeds.pop(0)
        else:
            days += 1
            if cnt > 0:
                answer.append(cnt)
                cnt = 0
    answer.append(cnt)
    return answer

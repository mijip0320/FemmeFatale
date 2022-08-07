def solution(clothes):
    answer = 1
    dic = {}
    for cloth in clothes:
        if cloth[1] in dic:
            dic[cloth[1]] += 1
        else:
            dic[cloth[1]] = 1
    for d in dic:
        answer *= (int(dic[d])+1)
        
    return answer-1

def solution(answers):
    result = []
    count = [0,0,0]
    methods = [[1,2,3,4,5],[2,1,2,3,2,4,2,5],[3,3,1,1,2,2,4,4,5,5]]
    for idx, answer in enumerate(answers):
        if answer == methods[0][idx%len(methods[0])]:
            count[0] += 1
        if answer == methods[1][idx%len(methods[1])]:
            count[1] += 1
        if answer == methods[2][idx%len(methods[2])]:
            count[2] += 1
            
    for idx, score in enumerate(count):
        if score == max(count):
            result.append(idx+1)
    return result

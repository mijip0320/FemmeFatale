def solution(arr):
    pre = arr[0]
    answer = [pre]
    for num in arr:
        if num == pre:
            continue
        else:
            answer.append(num)
            pre = num
    return answer

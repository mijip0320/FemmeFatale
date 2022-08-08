def solution(s):
    answer = []
    s = s[2:-2]
    s = s.split('},{')
    s.sort(key=len)
    for nums in s:
        nums = list(map(int,nums.split(',')))
        for num in nums:
            if num not in answer:
                answer.append(num)
    return answer

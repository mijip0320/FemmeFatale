import math
def solution(str1, str2):
    answer = 0
    sum_cnt = 0 #합집합
    inter_cnt = 0 #교집합
    com_str1 = []
    com_str2 = []
    for i in range(len(str1)-1):
        if str1[i].isalpha() and str1[i+1].isalpha():
            com_str1.append((str1[i]+str1[i+1]).lower())
    for i in range(len(str2)-1):
        if str2[i].isalpha() and str2[i+1].isalpha():
            com_str2.append((str2[i]+str2[i+1]).lower())
    for c in com_str1:
        if c in com_str2:
            com_str2.remove(c)
            inter_cnt += 1
    sum_cnt = len(com_str1) + len(com_str2)
    if not len(com_str1) and not len(com_str2):
        return 65536
    return math.trunc((inter_cnt/sum_cnt)*65536)

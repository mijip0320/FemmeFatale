def solution(s):
    answer = ""
    s = list(map(int,s.split(' ')))
    s.sort()
    return "{} {}".format(s[0],s[-1])

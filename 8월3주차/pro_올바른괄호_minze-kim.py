def solution(s):
    answer = True
    q = []
    for check in s:
        if check == '(':
            q.append('(')
        else:
            if q and (q[-1] == '('):
                q.pop(-1)
            else:
                return False
    if len(q) == 0:
        return True
    else:
        return False

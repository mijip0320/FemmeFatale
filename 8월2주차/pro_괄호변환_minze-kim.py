# uv분리
def divide_uv(str):
    correct = True
    left, right = 0,0
    stack = []
    
    for i in range(len(str)):
        if str[i] == '(':
            left += 1
            stack.append('(')
        else:
            right += 1
            if len(stack) == 0:
                correct = False
            else:
                stack.pop()
        if left == right:
            return i+1 , correct

    
def solution(p):
    if len(p) == 0:
        return p
    i, correct = divide_uv(p)
    u = p[:i]
    v = p[i:]
    if correct:
        return u + solution(v)
    answer = '(' + solution(v) + ')'
    for i in range(1, len(u)-1):
        if u[i] == '(':
            answer += ')'
        else:
            answer += '('
    return answer

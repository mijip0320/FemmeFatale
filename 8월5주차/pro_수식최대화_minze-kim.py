from itertools import permutations

def solution(expression):
    oper = ['+', '-', '*']
    oper = list(permutations(oper, 3))
    answer = []

    for op in oper:
        a = op[0]
        b = op[1]
        temp_list = []

        for e in expression.split(a):
            temp = [f'({i})' for i in e.split(b)]
            temp_list.append(f'({b.join(temp)})')

        answer.append(abs(eval(a.join(temp_list))))

    return max(answer)

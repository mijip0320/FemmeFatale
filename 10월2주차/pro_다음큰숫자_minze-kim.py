# 2진수 변환, 1개수 count
def solution(n):
    b = format(n, 'b')
    while True:
        n += 1
        if b.count('1') == format(n,'b').count('1'):
            return n

# 2진수 직접 변환
def binary(n):
    answer = ''
    while n > 1:
        answer += str(n % 2)
        n //= 2
    answer += '1'
    return answer[::-1]

def one_count(bin_num):
    cnt = 0
    for n in bin_num:
        if n == '1':
            cnt += 1
    return cnt
    
    
def solution(n):
    n_cnt = one_count(binary(n))
    while True:
        n += 1
        if n_cnt == one_count(binary(n)):
            return n

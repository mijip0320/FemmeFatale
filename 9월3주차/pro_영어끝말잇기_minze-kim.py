def solution(n, words):
    answer = [0,0]

    cnt = 0
    check = []
    check.append(words[0])
    for i in range(1, len(words)):
        cnt += 1
        if words[i] not in check and list(words[i-1])[-1] == list(words[i])[0]:
            check.append(words[i])
        else:
            answer[0] = cnt%n + 1
            answer[1] = cnt//n + 1
            break

    return answer
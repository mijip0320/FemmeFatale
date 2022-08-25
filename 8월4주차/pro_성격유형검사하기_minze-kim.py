def solution(survey, choices):
    answer = ''
    character = {'R':0,'T':0,'C':0,'F':0,'J':0,'M':0,'A':0,'N':0}
    for idx, choice in enumerate(choices):
        if choice - 4 > 0:
            character[survey[idx][1]] += choice - 4
        else:
            character[survey[idx][0]] += 4 - choice
    
    if character['R'] >= character['T']:
        answer += 'R'
    if character['R'] < character['T']:
        answer += 'T'
    if character['C'] >= character['F']:
        answer += 'C'
    if character['C'] < character['F']:
        answer += 'F'
    if character['J'] >= character['M']:
        answer += 'J'
    if character['J'] < character['M']:
        answer += 'M'
    if character['A'] >= character['N']:
        answer += 'A'
    if character['A'] < character['N']:
        answer += 'N'
 
    return answer

def solution(numbers, hand):
    answer = ''
    keypad = {1:[0,0],2:[0,1],3:[0,2],
             4:[1,0],5:[1,1],6:[1,2],
             7:[2,0],8:[2,1],9:[2,2],
             '*':[3,0],0:[3,1],'#':[3,2]}
    right_hand = keypad['*']
    left_hand = keypad['#']
    for number in numbers:
        if number in [1,4,7]:
            left_hand = keypad[number]
            answer += 'L'
        elif number in [3,6,9]:
            right_hand = keypad[number]
            answer += 'R'
        else:
            left_distance = abs(keypad[number][0]-left_hand[0])+abs(keypad[number][1]-left_hand[1])
            right_distance = abs(keypad[number][0]-right_hand[0])+abs(keypad[number][1]-right_hand[1])
            if left_distance == right_distance:
                if hand == 'right':
                    answer += 'R'
                    right_hand = keypad[number]
                else:
                    answer += 'L'
                    left_hand = keypad[number]
            else:
                if left_distance < right_distance:
                    answer += 'L'
                    left_hand = keypad[number]

                else:
                    answer += 'R'
                    right_hand = keypad[number]
    return answer

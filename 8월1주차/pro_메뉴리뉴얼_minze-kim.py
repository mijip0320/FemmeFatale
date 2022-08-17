from itertools import combinations
from collections import Counter

def solution(orders, course):
    answer = []
    for menu_num in course:
        menu_list = []
        for order in orders:
            for combi in combinations(order,menu_num):
                menu_combi = ''.join(sorted(combi))
                menu_list.append(menu_combi)
                menu_combination_cnt = Counter(menu_list)
        max_menu_combi = max(list(menu_combination_cnt.values()))
        for key in list(menu_combination_cnt.keys()):
            if menu_combination_cnt[key] == max_menu_combi and menu_combination_cnt[key] > 1:
                answer.append(key)
        answer.sort()
    return answer

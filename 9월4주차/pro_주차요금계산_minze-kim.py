import math

def solution(fees, records):
    time_record = dict()
    remain_time = dict()
    answer = []

    for record in records:
        time, car, Dir = record.split()
        time_list = list(map(int, time.split(':')))
        time_to_min = time_list[0] * 60 + time_list[1]

        if time_record.get(car):
            if Dir == 'IN':
                time_record[car].append(time_to_min)
            elif Dir == 'OUT':
                if remain_time.get(car):
                    remain_time[car] += time_to_min - (time_record[car].pop())
                else:
                    remain_time[car] = time_to_min - (time_record[car].pop())
        else:
            time_record[car] = [time_to_min]

    for key, value in time_record.items():
        if value:
            if remain_time.get(key):
                remain_time[key] += (1439 - value[0])
            else:
                remain_time[key] = (1439 - value[0])

    for key, value in sorted(remain_time.items()):
        if value > fees[0]:
            answer.append(fees[1] + math.ceil((value - fees[0]) / fees[2]) * fees[3])
        else:
            answer.append(fees[1])

    return answer
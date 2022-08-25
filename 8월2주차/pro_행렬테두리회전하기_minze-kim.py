def solution(rows, columns, queries):
    answer = []
    maps = [[0]*columns for _ in range(rows)]
    num = 1
    for i in range(rows):
        for j in range(columns):
            maps[i][j] = num
            num += 1
    for x1,y1,x2,y2 in queries:
        x1,y1,x2,y2 = x1-1,y1-1,x2-1,y2-1
        start = maps[x1][y1]
        min_num = maps[x1][y1]
        for x in range(x1,x2):
            maps[x][y1] = maps[x+1][y1]
            min_num = min(maps[x][y1],min_num)
        for y in range(y1,y2):
            maps[x2][y] = maps[x2][y+1]
            min_num = min(maps[x2][y],min_num)
        for x in range(x2,x1,-1):
            maps[x][y2] = maps[x-1][y2]
            min_num = min(maps[x][y2],min_num)
        for y in range(y2,y1,-1):
            maps[x1][y] = maps[x1][y-1]
            min_num = min(maps[x1][y],min_num)
        maps[x1][y1+1] = start
        answer.append(min_num)
    return answer

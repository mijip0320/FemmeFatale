from collections import deque

# 상하좌우
dx = [0,0,-1,1]
dy = [-1,1,0,0]

def solution(m,n,picture):
    answer = [0,0]
    Visited = [[False]*n for _ in range(m)]

    def bfs(y,x):
        cnt = 1
        q = deque()
        q.append((y,x))
        Visited[y][x] = True
        now_color = picture[y][x]
        while q:
            y,x = q.popleft()
            #상하좌우로 이동하면서 확인
            for dir in range(4):
                ny, nx = x+dy[dir], y+dx[dir]
                if 0 <= ny < m and 0 <= nx < n:
                    if not Visited[ny][nx] and picture[ny][nx] == now_color:
                        q.append((ny,nx))
                        Visited[ny][nx] = True
                        cnt += 1

        answer[0] += 1
        answer[1] = max(answer[1], cnt)

    for y in range(m):
        for x in range(n):
            if not Visited[y][x] and picture[y][x] != 0:
                bfs(y, x)
    return answer


# print(solution(6,4,[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]))

import sys
sys.setrecursionlimit(10000)

N = int(input())
paper = []
for _ in range(N):
    one_line = list(map(int, sys.stdin.readline().split()))
    paper.append(one_line)
# -1, 0, 1 순서
result_list = [0, 0, 0]


def cutting(start_i, start_j, size):
    check = False
    num = -2
    for i in range(start_i, start_i + size):
        for j in range(start_j, start_j + size):
            # 왼쪽 위 모서리 확인
            if i == start_i and j == start_j:
                num = paper[i][j]
            else:
                if num != paper[i][j]:
                    check = True
                    break
        if check:
            break
    if check:
        # 재귀 호출
        # 1열
        cutting(start_i, start_j, size // 3)
        cutting(start_i, start_j + size // 3, size // 3)
        cutting(start_i, start_j + size // 3 * 2, size // 3)
        # 2열
        cutting(start_i + size // 3, start_j, size // 3)
        cutting(start_i + size // 3, start_j + size // 3, size // 3)
        cutting(start_i + size // 3, start_j + size // 3 * 2, size // 3)
        # 3열
        cutting(start_i + size // 3 * 2, start_j, size // 3)
        cutting(start_i + size // 3 * 2, start_j + size // 3, size // 3)
        cutting(start_i + size // 3 * 2, start_j + size // 3 * 2, size // 3)
    else:
        result_list[num + 1] += 1


cutting(0, 0, N)
print(result_list[0])
print(result_list[1])
print(result_list[2])

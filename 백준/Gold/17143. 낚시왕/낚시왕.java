import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Shark {
        int r;
        int c;
        int s; // 속력
        int d; // 방향
        int z; // 크기

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static Shark[][] map;
    static ArrayList<Shark> sharks;

    static int[] dx = {0, 0, 0, 1, -1};
    static int[] dy = {0, -1, 1, 0, 0};

    static int R, C, M, answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R+1][C+1];
        sharks = new ArrayList<>();
        answer = 0;

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map[r][c] = new Shark(r, c, s, d, z);
            sharks.add(map[r][c]);
        }

        move();

        System.out.println(answer);
    }

    private static void move() {

        for (int m=1; m<=C; m++){

            // 맨 위에 있는 상어 잡고 빠지기
            for (int k=1; k<=R; k++){
                if (map[k][m] != null) {
                    answer += map[k][m].z; // 무게 추가
                    sharks.remove(map[k][m]);
                    map[k][m] = null; // 빈칸 만들기
                    break;
                }
            }

            if (m == C)
                break;

            Shark[][] moveMap = new Shark[R+1][C+1];
            ArrayList<Shark> movedSharks = new ArrayList<>(); // 이동한 상어들을 저장할 리스트

            for (Shark shark : sharks){

                int speed = shark.s;
                int dir = shark.d;
                int nx = shark.r;
                int ny = shark.c;

                if(dir == 1 || dir == 2) { // 상하로 움직이는 경우
                    speed %= (R - 1) * 2; // 한 바퀴 도는데 필요한 속력으로 나머지 계산
                    for(int i = 0; i < speed; i++) {
                        if(nx == 1)
                            dir = 2;

                        if(nx == R)
                            dir = 1;

                        nx += dy[dir];
                    }
                } else { // 좌우로 움직이는 경우
                    speed %= (C - 1) * 2; // 한 바퀴 도는데 필요한 속력으로 나머지 계산

                    for(int i = 0; i < speed; i++) {
                        if(ny == 1)
                            dir = 3;

                        if(ny == C)
                            dir = 4;

                        ny += dx[dir];
                    }
                }

                shark.r = nx;
                shark.c = ny;
                shark.d = dir;

                // 만약 그 칸에 다른 상어가 있다면,
                if (moveMap[shark.r][shark.c] != null){

                    Shark in = moveMap[shark.r][shark.c];

                    // 이미 있는 놈이 더 큰놈
                    if (in.z < shark.z) {
                        movedSharks.remove(in); // 이동한 상어 리스트에서 작은 상어 제거
                        moveMap[shark.r][shark.c] = shark;
                        movedSharks.add(shark); // 이동한 상어 리스트에 큰 상어 추가
                    }
                } else {
                    moveMap[shark.r][shark.c] = shark;
                    movedSharks.add(shark); // 이동한 상어 리스트에 상어 추가
                }
            }

            map = moveMap;
            sharks = movedSharks; // 상어 리스트 업데이트
        }
    }
}
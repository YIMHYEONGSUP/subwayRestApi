package iwillbe.exam.domain.algorithem;

import java.util.*;


class Element implements Comparable<Element> {
    int station;
    int time;

    public Element(int station, int time) {
        this.station = station;
        this.time = time;
    }

    @Override
    public int compareTo(Element o) {
        return this.time - o.time;
    }
}


public class Dijkstra {

        static  String[] stations = {"강남", "역삼", "삼성", "잠실", "송파", "복정", "성남", "판교", "청계산", "양재", "대치"};
    static  String[][] lines = {
            {"강남","역삼","5"},{"강남","양재","10"},{"강남","대치","6"},
            {"역삼","삼성","6"},{"역삼","강남","5"},{"역삼","대치","7"},
            {"삼성","잠실","6"},{"삼성","역삼","6"},
            {"잠실","송파","5"},{"잠실","삼성","6"},
            {"송파","복정","12"},{"송파","잠실","5"},{"송파","대치","20"},
            {"복정","성남","4"},{"복정","송파","12"},
            {"성남","판교","6"},{"성남","복정","4"},{"성남","대치","27"},
            {"판교","청계산","5"},{"판교","성남","6"},
            {"청계산","양재","9"},{"청계산","판교","5"},
            {"양재","강남","10"},{"양재","청계산","9"},{"양재","대치","5"},
            {"대치","강남","6"},{"대치","역삼","7"},{"대치","송파","20"},{"대치","성남","27"},{"대치","양재","5"}

    };
    static int LENGTH = stations.length;
    static String DEPARTURE = "판교";
    static String GOAL = "삼성";

    static int INF = 987654321;

    static int[][] dijkstra;
    static int[] dist;
    static boolean[] visited;

    static Stack<Integer> route = new Stack<>();

    public static void main(String[] args) {

        Map<String, Integer> stationNumber = new LinkedHashMap<>();

        for (int i = 0; i < LENGTH; i++) {
            stationNumber.put(stations[i], i);
        }

        System.out.println("stationNumber = " + stationNumber);

        // 2차원 배열으로 변환
        dijkstra = new int [LENGTH][LENGTH];
        dist = new int[LENGTH];

        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                if (i != j) {
                    dijkstra[i][j] = INF;
                }
            }
        }

        for (String[] line : lines) {
            Integer start = stationNumber.get(line[0]);
            Integer end = stationNumber.get(line[1]);
            int cost = Integer.parseInt(line[2]);

            dijkstra[start][end] = cost;
        }

        // 출발점 넣기
        dijkstra(stationNumber.get(DEPARTURE));

        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                if (dijkstra[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dijkstra[i][j] + " ");
                }
            }
            System.out.println();
        }

        System.out.println("역 별 최소 거리 = " + Arrays.toString(dist));
        System.out.println("최단 루트 = " + route);
        System.out.println("최소 시간 = " + dist[stationNumber.get(GOAL)]);
        System.out.println("반복 횟수 =" + count);
    }

    static int count = 0;

    private static void dijkstra(int start) {

        PriorityQueue<Element> pq = new PriorityQueue<>();
        Arrays.fill(dist , INF);
        dist[start] = 0;
        pq.offer(new Element(start, dist[start]));

        while (!pq.isEmpty()) {
            count++;

            int now = pq.peek().station;
            int cost = pq.peek().time;
            pq.poll();

            if (cost > dist[now]) {
                continue;
            }

            for (int i = 0; i < LENGTH; i++) {
                if (dijkstra[now][i] != 0 && dist[i] > (dist[now] + dijkstra[now][i])) {
                    dist[i] = dist[now] + dijkstra[now][i];
                    pq.offer(new Element(i, dist[i]));

                    System.out.println(" 현재 " + now + " --> 연결 역" + i + " 현재 비용 :" + dijkstra[now][i]);


                    if(!route.isEmpty() && route.peek() == now){
                        route.pop();
                    }
                    route.add(now);

                }
            }

        }
    }

}

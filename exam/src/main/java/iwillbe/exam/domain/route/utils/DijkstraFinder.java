package iwillbe.exam.domain.route.utils;

import iwillbe.exam.domain.line.entity.persist.Line;
import iwillbe.exam.domain.station.entity.persist.Station;

import java.io.LineNumberReader;
import java.util.*;

class StationInfo implements Comparable<StationInfo> {
    int station;
    int time;

    public StationInfo(int station, int time) {
        this.station = station;
        this.time = time;
    }

    @Override
    public int compareTo(StationInfo o) {
        return this.time - o.time;
    }
}

public class DijkstraFinder {

    static Map<String , Integer> stations = new LinkedHashMap<>();
    static Map<Integer , String> stationNames = new LinkedHashMap<>();
    static Map<Integer, Map<Integer, Long>> lines = new LinkedHashMap<>();

    static int LEN;
    static Integer GOAL;
    static int INF = 987654321;

    static Stack<Integer> routes = new Stack<>();

    static int[][] dijkstra;
    static int[] dist;
    static boolean[] visited;

    public void run(String departure , String goal , List<Station> stationsList , List<Line> lineList) {

        LEN = stationsList.size();

        // stations 세팅
        setStations(stationsList);
        // lines 세팅
        setLines(lineList);

        GOAL = stations.get(goal);

        Integer start = stations.get(departure);
        Stack<Integer> route = new Stack<>();
        Long sum = 0L;
        boolean[] visited = new boolean[LEN];

        // 출발점 넣기
        dijkstra(stations.get(departure));
    }

    static int count;
    private static void dijkstra(int start) {

        PriorityQueue<StationInfo> pq = new PriorityQueue<>();
        Arrays.fill(dist , INF);
        dist[start] = 0;
        pq.offer(new StationInfo(start, dist[start]));

        while (!pq.isEmpty()) {
            count++;

            int now = pq.peek().station;
            int cost = pq.peek().time;
            pq.poll();

            if (cost > dist[now]) {
                continue;
            }

            for (int i = 0; i < LEN; i++) {
                if (dijkstra[now][i] != 0 && dist[i] > (dist[now] + dijkstra[now][i])) {
                    dist[i] = dist[now] + dijkstra[now][i];
                    pq.offer(new StationInfo(i, dist[i]));
                }
            }

        }
    }

    public List<String> getRoute() {

        // 리스트 타입 변환
        List<String> shortestRoute = new ArrayList<>();

        for (Integer val : routes) {
            shortestRoute.add(stationNames.get(val));
        }

        return shortestRoute;
    }

    public Long getTime() {
//        return dist[GOAL];
        return 0L;
    }

    private void setStations(List<Station> stationsList) {
        for (int i = 0; i < stationsList.size(); i++) {
            stations.put(stationsList.get(i).getStationName(), i);
            stationNames.put(i, stationsList.get(i).getStationName());
        }
    }
    private void setLines(List<Line> lineList) {
        for (Line line : lineList) {
            Integer start = stations.get(line.getStart());
            Integer end = stations.get(line.getEnd());
            Long time = line.getTime();

            if(lines.containsKey(start)){
                Map<Integer, Long> temp = lines.get(start);
                temp.put(end, time);
                lines.put(start, temp);
            }else{
                Map<Integer, Long> temp = new LinkedHashMap<>();
                temp.put(end , time);
                lines.put(start, temp);
            }
        }
    }

}

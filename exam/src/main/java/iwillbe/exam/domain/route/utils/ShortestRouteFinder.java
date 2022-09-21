package iwillbe.exam.domain.route.utils;

import iwillbe.exam.domain.line.entity.persist.Line;
import iwillbe.exam.domain.station.entity.persist.Station;

import java.util.*;

public class ShortestRouteFinder {

    static Map<String , Integer> stations = new LinkedHashMap<>();;
    static Map<Integer, Map<Integer, Long>> lines = new LinkedHashMap<>();;

    static int LEN;
    static Integer GOAL;

    // 결과 값
    static Long shortest = 987654321L;
    static Stack<Integer> routes = new Stack<>();

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

        shortest(start, sum, route, visited);
    }
    
    public List<String> getRoute() {

        // 리스트 타입 변환
        List<String> shortestRoute = new ArrayList<>();

        for (Integer val : routes) {
            shortestRoute.add(Integer.toString(val));
        }

        return shortestRoute;
    }

    public Long getTime() {
        return shortest;
    }


    private void shortest(Integer now, Long sum, Stack<Integer> route, boolean[] visited) {

        // 탈출 조건
        if (now == GOAL) {
            if (shortest > sum) {
                shortest = sum;

                routes.clear();

                route.forEach((val)->{
                    routes.add(val);
                });
                routes.add(GOAL);
            }
            return;
        }

       lines.get(now).forEach((next , cost) -> {
           if (!visited[next]) {
               route.add(now);
               visited[now] = true;
               shortest(next, sum + cost, route, visited);
               route.pop();
               visited[now] = false;
           }
       });


    }
    private void setStations(List<Station> stationsList) {
        for (int i = 0; i < stationsList.size(); i++) {
            stations.put(stationsList.get(i).getStationName(), i);
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

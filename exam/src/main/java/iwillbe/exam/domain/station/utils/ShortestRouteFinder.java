package iwillbe.exam.domain.station.utils;

import iwillbe.exam.domain.line.entity.persist.Line;
import iwillbe.exam.domain.station.entity.persist.Station;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ShortestRouteFinder {

    static Map<String , Integer> stations = new LinkedHashMap<>();;
    static Map<Integer, Map<Integer, Long>> lines = new LinkedHashMap<>();;

    static int LEN;
    static Integer GOAL;

    // 결과 값
    static Long shortest = 987654321L;
    static Stack<Integer> routes;

    public Stack<Integer> shortestRoute() {
        return routes;
    }

    public Long shortestTime() {
        return shortest;
    }


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

        shortestRoute(start, sum, route, visited);

    }

    private void shortestRoute(Integer start, Long sum, Stack<Integer> route, boolean[] visited) {

        // 탈출 조건
        if (start == stations.get(GOAL)) {
            if (shortest > sum) {
                shortest = sum;
                routes = route;
            }
            return;
        }

        lines.forEach((nowStation , map)->{
            map.forEach((nextStation , time)->{
                if(!visited[nextStation]){
                    route.add(nowStation);
                    visited[nowStation] = true;
                    shortestRoute(nextStation , sum + time , route , visited);
                    route.pop();
                    visited[nowStation] = false;
                }
            });
        });


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

    private void setStations(List<Station> stationsList) {
        for (int i = 0; i < stationsList.size(); i++) {
            stations.put(stationsList.get(i).getStationName(), i);
        }
    }
}

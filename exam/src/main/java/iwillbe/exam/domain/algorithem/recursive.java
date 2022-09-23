package iwillbe.exam.domain.algorithem;



import java.util.*;

public class recursive {

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

    static Map<Integer, Map<Integer, Long>> lineCost;
    static Map<String, Integer> name;

    static String departure;
    static String goal;

    static Long shortest = 987654321L;
    static List<Integer> copyList = new ArrayList<>();
    static Stack<Integer> result = new Stack<>();

    static int count;

    public static void main(String[] args) {

        departure = "대치";
        goal = "송파";

        // 지하철 역 key , value (index)
        name = new LinkedHashMap<>();
        for (int i = 0; i < stations.length; i++) {
            name.put(stations[i] , i);
        }


        boolean[] visited = new boolean[stations.length];

        // 이중맵
        lineCost = new LinkedHashMap<>();

        for (String[] line : lines) {
            Integer start = name.get(line[0]);
            Integer end = name.get(line[1]);
            Long time = Long.parseLong(line[2]);

            if (lineCost.containsKey(start)) {
                Map<Integer, Long> temp = lineCost.get(start);
                temp.put(end, time);
                lineCost.put(start, temp);
            }else{
                Map<Integer, Long> temp = new LinkedHashMap<>();
                temp.put(end , time);
                lineCost.put(start, temp);
            }
        }

        // 지하철역 , 인덱스 출력
        System.out.println("역 이름 정보 " + name);
        System.out.println(" 라인 정보 " + lineCost);

        // 현재 역 인덱스
        int index = name.get(departure);
        Stack<Integer> stack = new Stack<Integer>();

        // 최단거리,최단시간 탐색
        find(index , 0L , stack , visited);

        System.out.println("최단 시간 : " + shortest);
        System.out.println("최단 루트 : " + result);
        System.out.println("총 탐색 횟수 : " + count);

    }


    private static void find(int station , Long sum , Stack<Integer> stack , boolean[] visited) {
        count++;

        if(station == name.get(goal)){

            if (shortest > sum) {
                shortest = sum;

                result.clear();
                stack.forEach((value)->{
                    result.add(value);
                });
                result.add(name.get(goal));

            }
            return;
        }

        // 2중 map -> key (start) value ( map ( end , cost ) )
        lineCost.get(station).forEach((end , cost)->{
            if(!visited[end] && shortest > sum){ // 최소값과 현재값 비교 탐색횟수 88 -> 27 감소
                stack.add(station);
                visited[station] = true;
                find(end , sum+cost , stack , visited);
                stack.pop();
                visited[station] = false;
            }
        });

    }



}

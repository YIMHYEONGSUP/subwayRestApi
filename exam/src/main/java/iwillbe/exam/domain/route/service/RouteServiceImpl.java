package iwillbe.exam.domain.route.service;

import iwillbe.exam.domain.line.entity.persist.Line;
import iwillbe.exam.domain.route.dto.ShortRouteResponseDTO;
import iwillbe.exam.domain.station.entity.persist.Station;
import iwillbe.exam.domain.route.utils.ShortestRouteFinder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService{


    @Override
    public ShortRouteResponseDTO findShortestRoute(String departure, String goal , List<Station> stations , List<Line> lines) {

        ShortestRouteFinder finder = new ShortestRouteFinder();

        finder.run(departure , goal , stations , lines);

        Long shortestTime = finder.getTime();
        List<String> shortestRoute = finder.getRoute();

        System.out.println("!!! 최단거리 : " + shortestTime);
        System.out.println("최단 루트 !!!! : " + shortestRoute);

        return ShortRouteResponseDTO.builder()
                .shortestTime(shortestTime)
                .shortestRoute(shortestRoute)
                .build();
    }
}

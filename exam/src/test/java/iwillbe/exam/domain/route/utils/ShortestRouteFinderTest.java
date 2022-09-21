package iwillbe.exam.domain.route.utils;

import iwillbe.exam.domain.line.entity.persist.Line;
import iwillbe.exam.domain.line.service.LineService;
import iwillbe.exam.domain.route.service.RouteService;
import iwillbe.exam.domain.station.entity.persist.Station;
import iwillbe.exam.domain.station.service.StationService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShortestRouteFinderTest {

    @Autowired
    LineService lineService;

    @Autowired
    RouteService routeService;

    @Autowired
    StationService stationService;


    @Test
    public void test() {

        String departure = "판교";
        String goal = "삼성";

        List<Line> lines = lineService.findAll();
        List<Station> stations = stationService.findAll();

        ShortestRouteFinder finder = new ShortestRouteFinder();
        finder.run(departure , goal , stations , lines);
        List<String> route = finder.getRoute();
        Long time = finder.getTime();

        System.out.println("route = " + route);
        System.out.println("time = " + time);
    }

}
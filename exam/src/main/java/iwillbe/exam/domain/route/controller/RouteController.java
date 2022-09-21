package iwillbe.exam.domain.route.controller;

import iwillbe.exam.domain.line.entity.persist.Line;
import iwillbe.exam.domain.line.repository.LineRepository;
import iwillbe.exam.domain.route.dto.ShortRouteRequestDTO;
import iwillbe.exam.domain.station.entity.persist.Station;
import iwillbe.exam.domain.station.repository.StationRepository;
import iwillbe.exam.domain.station.utils.ShortestRouteFinder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Slf4j
@RestController
@RequestMapping("/route")
@RequiredArgsConstructor
public class RouteController {

    @Autowired
    StationRepository stationRepository;

    @Autowired
    LineRepository lineRepository;

    @PostMapping // response entity < response >
    public void findShortRoute(@RequestBody ShortRouteRequestDTO request) {

        String departure = request.getStart();
        String goal = request.getEnd();

        List<Station> stations = stationRepository.findAll();
        List<Line> lines = lineRepository.findAll();

        // 자료형 변환

        ShortestRouteFinder finder = new ShortestRouteFinder();

        finder.run(departure , goal , stations , lines);

        Long shortestTime = finder.shortestTime();
        Stack<Integer> shortestRoute = finder.shortestRoute();


    }



}

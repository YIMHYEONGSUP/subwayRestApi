package iwillbe.exam.domain.route.controller;

import io.swagger.annotations.*;
import iwillbe.exam.domain.line.entity.persist.Line;
import iwillbe.exam.domain.line.service.LineService;
import iwillbe.exam.domain.route.dto.ShortRouteRequestDTO;
import iwillbe.exam.domain.route.dto.ShortRouteResponseDTO;
import iwillbe.exam.domain.route.service.RouteService;
import iwillbe.exam.domain.station.entity.persist.Station;
import iwillbe.exam.domain.station.service.StationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@Api("최단 경로 계산 API")
@Slf4j
@RestController
@RequestMapping("/route")
@RequiredArgsConstructor
public class RouteController {

    @Autowired
    RouteService routeService;

    @Autowired
    LineService lineService;

    @Autowired
    StationService stationService;

    @ApiOperation(value = "최단 루트 , 시간 탐색" , notes = "출발역 과 도착역 사이 최단 루트 , 시간 확인")
    @PostMapping
    public ResponseEntity<ShortRouteResponseDTO> findShortRoute(

            @RequestBody ShortRouteRequestDTO request) {

        String departure = request.getStart();
        String goal = request.getEnd();

        List<Station> stations = stationService.findAll();
        List<Line> lines = lineService.findAll();

        URI shortestDistanceURI = URI.create(String.format("/route/%s", departure));
        return ResponseEntity.created(shortestDistanceURI).body(routeService.findShortestRoute(departure, goal, stations, lines));

    }


}

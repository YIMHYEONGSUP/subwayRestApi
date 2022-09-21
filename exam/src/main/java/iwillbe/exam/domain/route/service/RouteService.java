package iwillbe.exam.domain.route.service;

import iwillbe.exam.domain.line.entity.persist.Line;
import iwillbe.exam.domain.route.dto.ShortRouteResponseDTO;
import iwillbe.exam.domain.station.entity.persist.Station;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RouteService {

    ShortRouteResponseDTO findShortestRoute(final String departure, final String goal, final List<Station> stations, final List<Line> lines);
}

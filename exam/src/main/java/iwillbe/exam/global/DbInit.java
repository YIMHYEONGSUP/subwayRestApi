package iwillbe.exam.global;

import iwillbe.exam.domain.line.entity.persist.Line;
import iwillbe.exam.domain.line.repository.LineRepository;
import iwillbe.exam.domain.station.entity.persist.Station;
import iwillbe.exam.domain.station.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DbInit {

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private LineRepository lineRepository;

    @PostConstruct
    private void init() {

        String[] stations = {"강남", "역삼", "삼성", "잠실", "송파", "복정", "성남", "판교", "청계산", "양재", "대치"};
        String[][] lines = {
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
        for (String[] line : lines) {
            String start = line[0];
            String end = line[1];
            long time = Long.parseLong(line[2]);

            Line entity = new Line(start, time, end);
            lineRepository.save(entity);
        }

        for (String station : stations) {
            Station entity = new Station(station);
            stationRepository.save(entity);
        }

    }
}

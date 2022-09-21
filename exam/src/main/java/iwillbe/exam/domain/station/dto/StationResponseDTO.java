package iwillbe.exam.domain.station.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import iwillbe.exam.domain.line.entity.persist.Line;
import iwillbe.exam.domain.station.entity.persist.Station;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StationResponseDTO {

    @JsonIgnore
    private Long id;
    @JsonProperty("station_name")
    private String stationName;

    public static StationResponseDTO create(final Station station) {
        return new StationResponseDTO(station.getId() , station.getStationName());
    }

}

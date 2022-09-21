package iwillbe.exam.domain.station.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import iwillbe.exam.domain.line.entity.persist.Line;
import iwillbe.exam.domain.station.entity.persist.Station;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@JsonTypeName("station")
@AllArgsConstructor
public class StationRegisterResponseDTO {

    @JsonProperty("station_name")
    private String stationName;

    public static StationRegisterResponseDTO from(final Station station) {
        return new StationRegisterResponseDTO(station.getStationName());
    }
}

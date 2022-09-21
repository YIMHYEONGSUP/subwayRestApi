package iwillbe.exam.domain.line.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import iwillbe.exam.domain.line.entity.persist.Line;
import iwillbe.exam.domain.station.entity.persist.Station;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonTypeName("line")
@NoArgsConstructor
@AllArgsConstructor
public class LineRegisterResponseDTO {

    @JsonProperty("line_start")
    private String start;

    @JsonProperty("line_time")
    private Long time;

    @JsonProperty("line_end")
    private String end;

    public static LineRegisterResponseDTO from(final Line line) {
        return new LineRegisterResponseDTO(line.getStart() , line.getTime(), line.getEnd());
    }
}

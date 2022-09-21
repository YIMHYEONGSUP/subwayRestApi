package iwillbe.exam.domain.line.entity.persist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import iwillbe.exam.domain.station.entity.persist.Station;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Line {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "line_id")
    private Long id;

    @Column(name = "line_start")
    private String start;

    @Column(name = "line_time")
    private Long time;

    @Column(name = "line_end")
    private String end;

    @Builder
    public Line(final String start ,final Long time , final String end) {
        this.start = start;
        this.time = time;
        this.end = end;
    }


}

package iwillbe.exam.domain.line.service;

import iwillbe.exam.domain.line.dto.LineRegisterResponseDTO;
import iwillbe.exam.domain.line.entity.persist.Line;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LineService {

    LineRegisterResponseDTO registerLine(Line line);

    List<Line> findAll();
}

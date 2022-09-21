package iwillbe.exam.domain.line.service;

import iwillbe.exam.domain.line.dto.LineRegisterResponseDTO;
import iwillbe.exam.domain.line.entity.persist.Line;
import iwillbe.exam.domain.line.repository.LineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class LineServiceImpl implements LineService{

    @Autowired
    LineRepository lineRepository;

    @Override
    public LineRegisterResponseDTO registerLine(Line line) {
        return LineRegisterResponseDTO.from(lineRepository.save(line));
    }
}

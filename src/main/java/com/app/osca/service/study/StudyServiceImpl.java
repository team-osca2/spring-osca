package com.app.osca.service.study;

import com.app.osca.dao.StudyDAO;
import com.app.osca.domain.StudyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyServiceImpl implements StudyService {
    final private StudyDAO studyDAO;

    @Override
    public void join(StudyVO studyVO) {
        studyDAO.join(studyVO);
    }
}

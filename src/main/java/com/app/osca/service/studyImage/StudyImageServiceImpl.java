package com.app.osca.service.studyImage;

import com.app.osca.dao.StudyImageDAO;
import com.app.osca.domain.StudyImageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyImageServiceImpl implements StudyImageService {
    final private StudyImageDAO studyImageDAO;
    @Override
    public void join(StudyImageVO studyImageVO) {
        studyImageDAO.save(studyImageVO);
    }
}

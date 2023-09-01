package com.app.osca.service.studyScrapService;

import com.app.osca.dao.MypageStudyScrapDAO;
import com.app.osca.domain.dto.StudyScrapDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MypageStudyScrapSercviceImpl implements MypageStudyScrapSercvice {
    private final MypageStudyScrapDAO studyScrapDAO;

    @Override
    public List<StudyScrapDTO> getScrapList(Long memberId) {
        return studyScrapDAO.findByMemberId(memberId);
    }

    @Override
    public void remove(Long id) {
        studyScrapDAO.remove(id);
    }
}
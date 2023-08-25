package com.app.osca.service.memberJob;

import com.app.osca.dao.MypageMemberJobDAO;
import com.app.osca.domain.dto.MemberJobDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MypageMemberJobServiceImpl implements MypageMemberJobService {
    private final MypageMemberJobDAO memberJobDAO;

    @Override
    public Optional<MemberJobDTO> getByMemberId(Long memberId) {
        return memberJobDAO.findByMemberId(memberId);
    }
}

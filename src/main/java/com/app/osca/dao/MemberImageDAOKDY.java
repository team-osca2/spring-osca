package com.app.osca.dao;

import com.app.osca.domain.ImageVO;
import com.app.osca.mapper.MemberImageMapperKDY;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberImageDAOKDY {
    private final MemberImageMapperKDY memberImageMapperKDY;

//    헤더 프로필 이미지 불러오기
    public Optional<ImageVO> findMMemberProfileById(Long id){
        return memberImageMapperKDY.selectMemberProfileImage(id);
    }

}

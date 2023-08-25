package com.app.osca.dao;

import com.app.osca.domain.GeneralVO;
import com.app.osca.mapper.GeneralMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MypageGeneralDAO {
    private final GeneralMapper generalMapper;

    //    일반 회원 정보 추가하기
    public void save(GeneralVO generalVO){generalMapper.insert(generalVO);}

    //    일반 회원 정보 가져오기
    public Optional<GeneralVO> findById(Long memberId){return generalMapper.selectById(memberId);}

    //    일반 회원 정보 수정하기
    public void setMemberInfo(GeneralVO generalVO) {generalMapper.update(generalVO);}
}

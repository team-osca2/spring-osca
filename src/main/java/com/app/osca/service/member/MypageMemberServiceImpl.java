package com.app.osca.service.member;

import com.app.osca.dao.MypageMemberDAO;
import com.app.osca.domain.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MypageMemberServiceImpl implements MypageMemberService {
    private final MypageMemberDAO memberDAO;

    @Override
    public Optional<MemberVO> getMemberInfo(Long id) {
        return memberDAO.findById(id);
    }

    @Override
    public void modify(MemberVO memberVO) {memberDAO.setMemberInfo(memberVO);}

    @Override
    public void remove(Long id) {memberDAO.delete(id);}


    @Override
    public String checkMemberPassword(Long id) {
        return memberDAO.findPassword(id);
    }

    @Override
    public void modifyPassword(String memberPassword) {
        memberDAO.setPassword(memberPassword);
    }
}

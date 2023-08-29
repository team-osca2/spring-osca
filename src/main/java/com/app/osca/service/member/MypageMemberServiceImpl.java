package com.app.osca.service.member;

import com.app.osca.dao.MypageMemberDAO;
import com.app.osca.domain.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public int checkNickname(String memberNickname) {
        return memberDAO.findNickname(memberNickname);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void modifyMemberNickname(String memberNickname, Long id){memberDAO.setMemberNickName(memberNickname, id);}

    @Override
    public void remove(Long id) {memberDAO.delete(id);}

    @Override
    public String checkMemberPassword(Long id) {
        return memberDAO.findPassword(id);
    }

//  비밀번호 수정하기
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void modifyPassword(String memberPassword, Long id) {
        String encryptedPassword = "";
        final int KEY = 3;
        for (int i = 0; i < memberPassword.length(); i++) {
            encryptedPassword += (char)(memberPassword.charAt(i) * KEY);
        }
        memberDAO.setPassword(encryptedPassword,id);
    }

//  휴대폰 번호 수정하기
    public void modifyPhonenumber(String memberPhonenumber, Long id){
        memberDAO.setPhonenumber(memberPhonenumber, id);
    };

}

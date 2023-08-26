package com.app.osca.service.admin;

import com.app.osca.dao.AdminMemberDAO;
import com.app.osca.domain.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminMemberServiceImpl implements AdminMemberService {
    final private AdminMemberDAO adminMemberDAO;

    @Override
    public List<MemberVO> getList() {
        return adminMemberDAO.findAll();
    }

    @Override
    public List<MemberVO> getUserList() {
        return adminMemberDAO.findAllStudents();
    }

    @Override
    public List<MemberVO> getCeoList() {
        return adminMemberDAO.findAllCeo();
    }

    @Override
    public List<MemberVO> getReportedUser() {
        return adminMemberDAO.findReportedUsers();
    }

    @Override
    public List<MemberVO> getBlockedUser() {
        return adminMemberDAO.findBlockedUsers();
    }

    @Override
    public void remove(Long id) {
        adminMemberDAO.updateUserBlock(id);
    }

    @Override
    public void restore(Long id) {
        adminMemberDAO.updateUserUnblock(id);
    }
}

package com.app.osca.service.admin;

import com.app.osca.dao.AdminMemberDAO;
import com.app.osca.domain.MemberVO;
import com.app.osca.domain.dto.AdminStudyDTO;
import com.app.osca.domain.paging.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminMemberServiceImpl implements AdminMemberService {
    final private AdminMemberDAO adminMemberDAO;

    //    관리자 전체 유저 목록
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<MemberVO> getList(Pagination pagination) {
        final List<MemberVO> userLists = adminMemberDAO.findAll(pagination);
        return userLists;
    }

    //   <!-- 관리자 일반 유저 목록-->
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<MemberVO> getUserList(Pagination pagination) {
        final List<MemberVO> studyUsers = adminMemberDAO.findAllStudents(pagination);
        return studyUsers;
    }
    //    <!-- 관리자 카페 유저 목록-->
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<MemberVO> getCeoList(Pagination pagination) {
        final List<MemberVO> ceoUsers = adminMemberDAO.findAllCeo(pagination);
        return ceoUsers;
    }
    //    <!-- 관리자 신고당한 유저 목록-->
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<MemberVO> getReportedUser(Pagination pagination) {
        final List<MemberVO> reportedUsers = adminMemberDAO.findReportedUsers(pagination);
        return reportedUsers;
    }
    //    <!-- 관리자 정지당한 유저 목록-->
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<MemberVO> getBlockedUser(Pagination pagination) {
        final List<MemberVO> blockedUsers = adminMemberDAO.findBlockedUsers(pagination);
        return blockedUsers;
    }


    //    <!-- 관리자 유저 정지 시키기-->
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Long id) {
        adminMemberDAO.updateUserBlock(id);
    }
    //    <!-- 관리자 유저 정지 해제 시키기-->
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void restore(Long id) {
        adminMemberDAO.updateUserUnblock(id);
    }


    //        <!-- 관리자 전체 유저 총 개수-->
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int getTotalMembers() {
        return adminMemberDAO.findCountOfMembers();
    }


    //    <!-- 관리자 정지당한 유저 총 개수-->
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int getTotalSuspendedMembers() {
        return adminMemberDAO.findCountOfSuspendedMembers();
    }

    //    <!-- 관리자 신고당한 유저 총 개수-->
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int getTotalReportedMembers() {
        return adminMemberDAO.findCountOfReportedMembers();
    }
    //    <!-- 관리자 일반 유저 총 개수-->
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int getTotalStudyMembers() {
        return adminMemberDAO.findCountOfStudyMembers();
    }
    //    <!-- 관리자 카페 유저 총 개수-->
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int getTotalCeoMembers() {
        return adminMemberDAO.findCountOfCeoMembers();
    }
}

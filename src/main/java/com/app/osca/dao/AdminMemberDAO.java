package com.app.osca.dao;


import com.app.osca.domain.MemberVO;
import com.app.osca.domain.paging.Pagination;
import com.app.osca.mapper.AdminMemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminMemberDAO {
    private final AdminMemberMapper adminMemberMapper;

    //    관리자 전체 유저 목록
    public List<MemberVO> findAll(Pagination pagination){
        return adminMemberMapper.selectAll(pagination);
    }

    //   <!-- 관리자 일반 유저 목록-->
    public List<MemberVO> findAllStudents(Pagination pagination){
        return adminMemberMapper.selectAllUserS(pagination);
    }

    //    <!-- 관리자 카페 유저 목록-->
    public List<MemberVO> findAllCeo(Pagination pagination){
        return adminMemberMapper.selectAllUserC(pagination);
    }

    //    <!-- 관리자 신고당한 유저 목록-->
    public List<MemberVO> findReportedUsers(Pagination pagination){
        return adminMemberMapper.selectUserReported(pagination);
    }

    //    <!-- 관리자 정지당한 유저 목록-->
    public List<MemberVO> findBlockedUsers(Pagination pagination){
        return adminMemberMapper.selectUserBlocked(pagination);
    }

    //    <!-- 관리자 유저 정지 시키기-->
    public void updateUserBlock(Long id){
        adminMemberMapper.updateStateBlock(id);
    }

    //    <!-- 관리자 유저 복구 시키기-->
    public void updateUserUnblock(Long id){
        adminMemberMapper.updateStateUnblock(id);
    }

    //        <!-- 관리자 전체 유저 총 개수-->
    public int findCountOfMembers(){return adminMemberMapper.selectCountOfMembers();}

    //    <!-- 관리자 정지당한 유저 총 개수-->
    public int findCountOfSuspendedMembers(){return adminMemberMapper.selectCountOfSuspendedMembers();}

    //    <!-- 관리자 신고당한 유저 총 개수-->
    public int findCountOfReportedMembers(){return adminMemberMapper.selectCountOfReportedMembers();}

    //    <!-- 관리자 일반 유저 총 개수-->
    public int findCountOfStudyMembers(){return adminMemberMapper.selectCountOfStudyMembers();}

    //    <!-- 관리자 카페 유저 총 개수-->
    public int findCountOfCeoMembers(){return adminMemberMapper.selectCountOfCeoMembers();}

}

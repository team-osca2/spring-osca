package com.app.osca.dao;


import com.app.osca.domain.MemberVO;
import com.app.osca.mapper.AdminMemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminMemberDAO {
    private final AdminMemberMapper adminMemberMapper;

    //    관리자 전체 유저 목록
    public List<MemberVO> findAll(){
        return adminMemberMapper.selectAll();
    }

    //   <!-- 관리자 일반 유저 목록-->
    public List<MemberVO> findAllStudents(){
        return adminMemberMapper.selectAllUserS();
    }

    //    <!-- 관리자 카페 유저 목록-->
    public List<MemberVO> findAllCeo(){
        return adminMemberMapper.selectAllUserC();
    }

    //    <!-- 관리자 신고당한 유저 목록-->
    public List<MemberVO> findReportedUsers(){
        return adminMemberMapper.selectUserReported();
    }

    //    <!-- 관리자 정지당한 유저 목록-->
    public List<MemberVO> findBlockedUsers(){
        return adminMemberMapper.selectUserBlocked();
    }

    //    <!-- 관리자 유저 정지 시키기-->
    public void updateUserBlock(Long id){
        adminMemberMapper.updateStateBlock(id);
    }
    //    <!-- 관리자 유저 복구 시키기-->
    public void updateUserUnblock(Long id){
        adminMemberMapper.updateStateUnblock(id);
    }


}

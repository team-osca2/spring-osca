package com.app.osca.service.admin;

import com.app.osca.domain.MemberVO;

import java.util.List;

public interface AdminMemberService {

    //    관리자 전체 유저 목록
    public List<MemberVO> getList();

    //   <!-- 관리자 일반 유저 목록-->
    public List<MemberVO> getUserList();

    //    <!-- 관리자 카페 유저 목록-->
    public List<MemberVO> getCeoList();

    //    <!-- 관리자 신고당한 유저 목록-->
    public List<MemberVO> getReportedUser();

    //    <!-- 관리자 정지당한 유저 목록-->
    public List<MemberVO> getBlockedUser();

    //    <!-- 관리자 유저 정지 시키기-->
    public void remove(Long id);

    //    <!-- 관리자 유저 복구 시키기-->
    public void restore(Long id);

}

package com.app.osca.mapper;

import com.app.osca.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AdminMemberMapper {

//    관리자 전체 유저 목록
    public List<MemberVO> selectAll();

//   <!-- 관리자 일반 유저 목록-->
    public List<MemberVO> selectAllUserS();

//    <!-- 관리자 카페 유저 목록-->
    public List<MemberVO> selectAllUserC();

//    <!-- 관리자 신고당한 유저 목록-->
    public List<MemberVO> selectUserReported();

//    <!-- 관리자 정지당한 유저 목록-->
    public List<MemberVO> selectUserBlocked();

//    <!-- 관리자 유저 정지 시키기-->
    public void updateStateBlock(Long id);

    //    <!-- 관리자 유저 복구 시키기-->
    public void updateStateUnblock(Long id);
}

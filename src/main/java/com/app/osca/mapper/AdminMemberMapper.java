package com.app.osca.mapper;

import com.app.osca.domain.MemberVO;
import com.app.osca.domain.paging.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AdminMemberMapper {

    //    관리자 전체 유저 목록
    public List<MemberVO> selectAll(@Param("pagination") Pagination pagination);

    //   <!-- 관리자 일반 유저 목록-->
    public List<MemberVO> selectAllUserS(@Param("pagination") Pagination pagination);

    //    <!-- 관리자 카페 유저 목록-->
    public List<MemberVO> selectAllUserC(@Param("pagination") Pagination pagination);

    //    <!-- 관리자 신고당한 유저 목록-->
    public List<MemberVO> selectUserReported(@Param("pagination") Pagination pagination);

    //    <!-- 관리자 정지당한 유저 목록-->
    public List<MemberVO> selectUserBlocked(@Param("pagination") Pagination pagination);

    //    <!-- 관리자 유저 정지 시키기-->
    public void updateStateBlock(Long id);

    //    <!-- 관리자 유저 복구 시키기-->
    public void updateStateUnblock(Long id);

    //        <!-- 관리자 전체 유저 총 개수-->
    public int selectCountOfMembers();

    //    <!-- 관리자 정지당한 유저 총 개수-->
    public int selectCountOfSuspendedMembers();

    //    <!-- 관리자 신고당한 유저 총 개수-->
    public int selectCountOfReportedMembers();

    //    <!-- 관리자 일반 유저 총 개수-->
    public int selectCountOfStudyMembers();

    //    <!-- 관리자 카페 유저 총 개수-->
    public int selectCountOfCeoMembers();


}

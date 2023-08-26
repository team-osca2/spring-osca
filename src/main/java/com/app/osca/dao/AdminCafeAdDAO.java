package com.app.osca.dao;

import com.app.osca.domain.dto.AdminCafeAdDTO;
import com.app.osca.mapper.AdminCafeAdMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminCafeAdDAO {
        private final AdminCafeAdMapper adminCafeAdMapper;
        //    관리자 스터디 게시글 불러오기
        public List<AdminCafeAdDTO> findAllCafePost(){
                return adminCafeAdMapper.selectAllCafePost();
        }

        //<!--    관리자 카페 글 블락-->
        public void setCafeBlock(Long id){
                adminCafeAdMapper.updateCafeBlock(id);
        }

        //<!--    관리자 카페 글 복구-->
        public void setCafeUnblock(Long id){
                adminCafeAdMapper.updateCafeUnblock(id);
        }

}

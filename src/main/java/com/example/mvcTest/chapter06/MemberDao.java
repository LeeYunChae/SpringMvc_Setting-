package com.example.mvcTest.chapter06;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDao {
    //sqlSessionTemplte 주입
    @Autowired
    private SqlSessionTemplate sst;

    public List<MemberVo> list(){
        List<MemberVo> list = sst.selectList("member.memberList");
        return list;
    }

}

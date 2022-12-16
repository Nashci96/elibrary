package com.enigmacamp.elibrary.repository;

import com.enigmacamp.elibrary.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepo extends JpaRepository<Member,Integer> {
    @Query(value = "SELECT * FROM t_member WHERE is_active = 1",nativeQuery = true)
    List<Member> getListActive();

    @Query(value = "SELECT * FROM t_member WHERE name like %?1% AND  is_active = 1 ",nativeQuery = true)
    List<Member> getListByName(String name);

}

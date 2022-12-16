package com.enigmacamp.elibrary.service;

import com.enigmacamp.elibrary.model.entity.Member;
import com.enigmacamp.elibrary.model.entity.Publisher;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    List<Member> listByActive() throws Exception;
    List<Member> listAll() throws Exception;
    List<Member> listByName(String name) throws Exception;
    Member create(Member member) throws Exception;
    Optional<Member> getById(Integer id) throws Exception;
    void update(Member member,Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}

package com.enigmacamp.elibrary.service.implementation;

import com.enigmacamp.elibrary.exception.EntityExistException;
import com.enigmacamp.elibrary.exception.NotFoundException;
import com.enigmacamp.elibrary.model.entity.Member;
import com.enigmacamp.elibrary.repository.MemberRepo;
import com.enigmacamp.elibrary.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepo memberRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<Member> listByActive() throws Exception {
        List<Member> result = memberRepo.getListActive();
        if (result.isEmpty()){
            throw new NotFoundException();
        }
        return result;
    }

    @Override
    public List<Member> listAll() throws Exception {
        List<Member> result = memberRepo.findAll();
        if (result.isEmpty()){
            throw new NotFoundException();
        }
        return result;
    }

    @Override
    public List<Member> listByName(String name) throws Exception {
        List<Member> result = memberRepo.getListByName(name);
        if (result.isEmpty()){
            throw new NotFoundException();
        }
        return result;
    }

    @Override
    public Member create(Member member) throws Exception {
        try {
            Member memberNew = memberRepo.save(member);
            return memberNew;
        } catch (Exception e) {
            throw new EntityExistException();
        }
    }

    @Override
    public Optional<Member> getById(Integer id) throws Exception {
        Optional<Member> result = memberRepo.findById(id);
        if (result.isEmpty()){
            throw new NotFoundException();
        }
        return result;
    }

    @Override
    public void update(Member member, Integer id) throws Exception {
        try {
            Optional<Member> existingMember = getById(id);
            if (existingMember.isPresent()){
                member.setId_member(id);
                memberRepo.save(member);
            }
        } catch (Exception e) {
            throw new NotFoundException("Member Not Found");
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {
            Optional<Member> existingMember = getById(id);
            memberRepo.delete(existingMember.get());
        } catch (Exception e) {
            throw new NotFoundException("Delete Failed because id not found");
        }
    }
}

package com.enigmacamp.elibrary.controller;

import com.enigmacamp.elibrary.model.entity.Member;
import com.enigmacamp.elibrary.model.request.MemberRequest;
import com.enigmacamp.elibrary.model.response.SuccessResponse;
import com.enigmacamp.elibrary.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity getAllActiveMember() throws Exception{
        List<Member> members = memberService.listByActive();
        return ResponseEntity.status(HttpStatus.OK).body(
                new SuccessResponse<>("Success Get All Member Data",members)
        );
    }

    @PostMapping
    public ResponseEntity createMember(@RequestBody MemberRequest memberRequest) throws Exception{
        Member newMember = modelMapper.map(memberRequest,Member.class);
        Member result = memberService.create(newMember);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success Created Member",result));
    }

    @GetMapping("/all")
    public ResponseEntity getAllMember() throws Exception{
        List<Member> members = memberService.listAll();
        return ResponseEntity.status(HttpStatus.OK).body(
                new SuccessResponse<>("Success Get All Member Data",members)
        );
    }

    @GetMapping("/list-by-name/{name}")
    public ResponseEntity getAllMemberByName(@PathVariable("name") String name) throws Exception{
        List<Member> members = memberService.listByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(
                new SuccessResponse<>("Success Get All Member Data",members)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) throws Exception{
        Optional<Member> member = memberService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get member by id",member));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateById(@RequestBody MemberRequest memberRequest,@PathVariable("id") Integer id) throws Exception{
        Member member = modelMapper.map(memberRequest,Member.class);
        memberService.update(member,id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success Update Member by id",member));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id) throws Exception{
        memberService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success Delete Member",null));
    }
}

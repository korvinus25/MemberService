package test.ncube.MemberService.service;

import test.ncube.MemberService.model.Member;

import java.util.List;

public interface MemberService {
    List<Member> findAll();
    Member findById(String id);
    void save(Member member);
    void delete(String id);
}

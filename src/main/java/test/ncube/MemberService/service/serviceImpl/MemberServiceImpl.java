package test.ncube.MemberService.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.ncube.MemberService.dao.MemberDao;
import test.ncube.MemberService.model.Member;
import test.ncube.MemberService.service.MemberService;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public List<Member> findAll() {
        return memberDao.findAll();
    }

    @Override
    public Member findById(String id) {
        return memberDao.findById(id).orElse(new Member());
    }

    @Override
    public void save(Member member) {
        memberDao.save(member);
    }

    @Override
    public void delete(String id) {
        memberDao.deleteById(id);
    }
}

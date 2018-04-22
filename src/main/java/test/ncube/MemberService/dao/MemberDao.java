package test.ncube.MemberService.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import test.ncube.MemberService.model.Member;


public interface MemberDao extends MongoRepository<Member, String> {
}

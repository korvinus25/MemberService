package test.ncube.MemberService.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import test.ncube.MemberService.dto.MemberDto;
import test.ncube.MemberService.model.Member;

import java.text.ParseException;

    public class ModelDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public MemberDto convertToDto(Member member){
        MemberDto memberDto = modelMapper.map(member, MemberDto.class);
        if(member.getDateOfBirth() != null){
            memberDto.setDateConverted(member.getDateOfBirth());
        }
        return memberDto;
    }

    public Member convertToModel(MemberDto memberDto) {
        Member member = modelMapper.map(memberDto, Member.class);
        if(memberDto.getDate() != null){
            try {
                member.setDateOfBirth(memberDto.getDateConverted());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return member;
    }

}

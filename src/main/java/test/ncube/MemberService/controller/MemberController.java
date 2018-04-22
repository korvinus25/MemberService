package test.ncube.MemberService.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.DateOperators;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import test.ncube.MemberService.dto.MemberDto;
import test.ncube.MemberService.model.Member;
import test.ncube.MemberService.service.MemberService;
import test.ncube.MemberService.util.ModelDtoConverter;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/member")
@Api(value="onlinestore", description="Operations pertaining to our members in DB")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ModelDtoConverter modelDtoConverter;

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    public List<MemberDto> getListOfMembers(){
        List<Member> members = memberService.findAll();
        return members.stream().map(member -> modelDtoConverter.convertToDto(member)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    public MemberDto getMember(@PathVariable String id){
        Member member = memberService.findById(id);
        return modelDtoConverter.convertToDto(member);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = {"application/json", "application/xml"})
    @ResponseStatus(value = HttpStatus.OK)
    public void addMember(@RequestBody MemberDto memberDto){
        Member member = modelDtoConverter.convertToModel(memberDto);
        memberService.save(member);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, consumes = {"application/json", "application/xml"})
    @ResponseStatus(value = HttpStatus.OK)
    public void updateMember(@PathVariable String id,
                             @RequestBody MemberDto memberDto){
        Member member = modelDtoConverter.convertToModel(memberDto);
        member.setId(id);
        memberService.save(member);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteMember(@PathVariable String id){
        memberService.delete(id);
    }
}

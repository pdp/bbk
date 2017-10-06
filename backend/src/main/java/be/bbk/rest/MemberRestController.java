package be.bbk.rest;

import be.bbk.domain.HeadLine;
import be.bbk.backend.MemberRepository;
import be.bbk.domain.Member;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import jersey.repackaged.com.google.common.collect.Lists;

import java.util.List;


/**
 * Created by peterdp on 18/08/2017.
 */
@RestController
public class MemberRestController {

    @Inject
    private MemberRepository memberRepository;

    @RequestMapping("/headlines")
    public List<HeadLine> getHeadLines() {
        return Lists.newArrayList(new HeadLine("Titel 1"), new HeadLine("Titel 2"));
    }

    @PostMapping(value="/createmember")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> createMember(@RequestBody Member member, UriComponentsBuilder ucBuilder) {
        memberRepository.save(member);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/member/{membershipNumber}").buildAndExpand(member.getMembershipNumber()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}

package hello.servlet.web.frontcontroller.v2;

import hello.servlet.domain.Member;
import hello.servlet.repository.MemberRepository;
import hello.servlet.web.frontcontroller.ControllerV2;
import hello.servlet.web.frontcontroller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {


    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        Member member = new Member(userName,age);
        memberRepository.save(member);

        request.setAttribute("member",member);
        return new MyView("/WEB-INF/views/save-result.jsp");



    }
}

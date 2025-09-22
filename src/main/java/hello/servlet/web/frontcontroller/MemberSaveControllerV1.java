package hello.servlet.web.frontcontroller;

import hello.servlet.domain.Member;
import hello.servlet.repository.MemberRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberSaveControllerV1 implements ControllerV1{

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MemberRepository memberRepository = MemberRepository.getInstance();
        String userName = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        Member member = new Member(userName,age);
        memberRepository.save(member);
        // 여기까지가 서비스
        // 여기서 부터 모델에 정보 담기
        request.setAttribute("member",member);

        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}

package tsdv.com.vn.demosimplemanager.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tsdv.com.vn.demosimplemanager.dataset.Member;
import tsdv.com.vn.demosimplemanager.service.MemberService;

@Controller
public class MpaController {
	@Autowired
	private MemberService service;

	@RequestMapping(value = "/mpa", method = RequestMethod.GET, produces = "text/html; charset=UTF-8")
	public String top() {
		return "top";
	}

	@RequestMapping(value = "/registNew", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded;charset=UTF-8", produces = "text/html; charset=UTF-8")
	public String registNew(@Validated @ModelAttribute Member member, Model model) {
		service.create(member);
		model.addAttribute("memberlist", service.findAll());
		model.addAttribute("registCompleteMessage", "Registed");

		return "result";
	}

	@RequestMapping(value = "/viewAll", method = RequestMethod.GET, produces = "text/html; charset=UTF-8")
	public String viewAll(Model model) {
		model.addAttribute("memberlist", service.findAll());
		return "result";
	}

	@RequestMapping(value = "/checkDuplication", method = RequestMethod.GET, consumes = "application/json; charset=UTF-8", produces = "html/plain; charset=UTF-8")
	@ResponseBody // (10)
	public String checkDuplication(@RequestParam String userid, // (11)
			HttpServletResponse response) {
		Optional<Member> member = service.findOne(userid);
		String result = userid;
		if (member != null) {
			response.setStatus(HttpServletResponse.SC_CONFLICT); // (12)
		}
		return result; // (13)
	}

}

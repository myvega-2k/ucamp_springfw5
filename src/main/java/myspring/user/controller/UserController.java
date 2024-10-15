package myspring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	public UserController() {
		System.out.println(this.getClass().getName() + " 컨트롤러 기본생성자 호출됨!!");
	}
	
	@RequestMapping("/getUser.do")  //GET
	public ModelAndView getUser(@RequestParam("id") String userId) {
		UserVO userVO = userService.getUser(userId);
		//viewName=userDetail, modelName="user", modelObject=userVO
		return new ModelAndView("userDetail", "user", userVO);
	}
	
	@RequestMapping("/getUserList.do")
	public String getUserList(Model model) {
		List<UserVO> userList = userService.getUserList();
		//attributeName="", attributeValue=userList
		model.addAttribute("users", userList);
		return "userList";
	}
	
}

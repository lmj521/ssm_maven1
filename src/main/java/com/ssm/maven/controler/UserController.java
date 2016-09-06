package com.ssm.maven.controler;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.maven.entity.Address;
import com.ssm.maven.entity.User;
import com.ssm.maven.service.AddressService;
import com.ssm.maven.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private AddressService addressService;

	@RequestMapping("/toPage1.htm")
	public String toPage1() {
		return "page1";

	}

	@RequestMapping("/showAllUser")
	public String toIndex(Map<String, Object> map) {
		List<User> list = userService.selectAll();
		map.put("list", list);
		return "showAllUsers";
	}

	@RequestMapping("/toSave")
	public String toAdd(Map<String, Object> map) {
		List<Address> addressList = addressService.selectAll();
		map.put("addressList", addressList);
		return "addUser";

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addUser(User user) {
		System.out.println(user.getUserId());
		int result = userService.insert(user);
		System.out.println(user.getUserId());
		return "redirect:/user/showAllUser";

	}

	@RequestMapping("/delete/{id}")
	public String del(@PathVariable("id") Integer id1) {
		int deleteByPrimaryKey = userService.deleteByPrimaryKey(id1);
		return "redirect:/user/showAllUser";
	}

	@RequestMapping("/toUpdate/{id}")
	public String toupdate(@PathVariable("id") Integer id1, Map<String, Object> map) {
		// int id = Integer.parseInt(id1);
		User user = userService.selectByPrimaryKey(id1);
		map.put("user", user);
		return "updateUser";
	}

	@RequestMapping(value = "/toUpdate/updateInfo", method = RequestMethod.POST)
	public String update(User user) {

		userService.updateByPrimaryKey(user);

		return "redirect:/user/showAllUser";
	}

}

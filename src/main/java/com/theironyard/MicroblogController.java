package com.theironyard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by macbookair on 11/9/15.
 */


@Controller
public class MicroblogController {

    @Autowired
    MessageRepository messages;

    @RequestMapping("/")
    public String home(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username);
        model.addAttribute("messages", messages.findAll());
        return "home";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, String username) {
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        return "redirect:/";
    }

    @RequestMapping("/add-message")
    public String message(String text) {
        Message message = new Message();
        message.text = text;
        messages.save(message);
        return "redirect:/";
    }

    @RequestMapping("/edit-message")
    public String editMessage(Integer id, String text) {
        Message message = messages.findOne(id);
        message.text = text;
        messages.save(message);
        return "redirect:/";
    }
}
/*
    @RequestMapping("/delete-message")
    public String delete(Integer id) {
        messages.remove(id - 1);
        int i = 1; // this thing is cool, but really only applicable when using ArrayLists.
        for (Message message : messages) {
            message.id = i;
            i++;
        }
        return "redirect:/";

*/


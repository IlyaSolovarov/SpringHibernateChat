package com.app.controllers;

import com.app.domain.Message;
import com.app.domain.User;
import com.app.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Date;

@Controller
public class MainController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("name", "user");
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        putAllMessagesToModel(model);
        return "main";
    }

    @PostMapping("/main")
    public String addMessage(@AuthenticationPrincipal User user,
                             @RequestParam String text,
                             @RequestParam(name = "tag", required = false, defaultValue = "noTag") String tag,
                             Map<String, Object> model) {
        Message message = new Message(text, tag, user, new Date());
        messageRepo.save(message);
        putAllMessagesToModel(model);
        return "main";
    }

    public void putAllMessagesToModel(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
    }

}

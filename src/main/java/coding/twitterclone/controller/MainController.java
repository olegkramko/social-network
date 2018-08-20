package coding.twitterclone.controller;

import coding.twitterclone.domain.Message;
import coding.twitterclone.domain.User;
import coding.twitterclone.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//main controller for queries
@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    //greeting page
    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    //main page
    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);
        return "main";

    }

    //add messages
    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag, user);
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
            return "main";
    }

    //filter and search messages
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {

        //show all messages if search box is empty
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.put("messages", messages);

        return "main";

    }
}

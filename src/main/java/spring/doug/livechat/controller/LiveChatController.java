package spring.doug.livechat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import spring.doug.livechat.domain.ChatInput;
import spring.doug.livechat.domain.ChatOutput;

@Controller
public class LiveChatController {

    @MessageMapping("/new-message") //input
    @SendTo("/topics/livechat") //output
    public ChatOutput newMenssage(ChatInput input){
        return new ChatOutput(HtmlUtils.htmlEscape( input.user() + ": " + input.message()));
    }
}

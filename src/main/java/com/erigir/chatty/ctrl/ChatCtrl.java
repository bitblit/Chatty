package com.erigir.chatty.ctrl;

import com.erigir.chatty.model.Message;
import com.erigir.chatty.model.MessageResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * This controller just exports content as JSON for display on the boards
 */
@Controller
public class ChatCtrl {
    private static final Logger LOG = LoggerFactory.getLogger(ChatCtrl.class);

    private List<Message> messages = new LinkedList<>();

    @RequestMapping(value = "/Message", method = RequestMethod.GET)
    public
    @ResponseBody
    MessageResponse getMessages(@RequestParam(required = false, value = "ts") final Long timestamp,
                                @RequestParam(required = false, value = "max") final Integer inMax) {
        int max = (inMax==null)?10:inMax;
        MessageResponse rval = new MessageResponse();
        rval.setTimestamp(System.currentTimeMillis());
        for (Message m:messages)
        {
            if (rval.getMsgs().size()<max) {
                if (timestamp == null || m.getTimestamp() >= timestamp) {
                    rval.addMessage(m);
                }
            }
        }

        return rval;
    }

    @RequestMapping(value = "/Message", method = RequestMethod.POST)
    public
    void newMessage(@RequestBody Message newMessage, HttpServletResponse resp)
    throws IOException {

        LOG.debug("Request : {}",newMessage);
        if (newMessage==null || StringUtils.isEmpty(newMessage.getMessage()) || StringUtils.isEmpty(newMessage.getUserid()))
        {
            resp.getWriter().println("The message and user-id must be set");
            resp.sendError(400);
        }
        else
        {
            newMessage.setTimestamp(System.currentTimeMillis());
            messages.add(newMessage);
        }
        resp.setStatus(201);
    }



}

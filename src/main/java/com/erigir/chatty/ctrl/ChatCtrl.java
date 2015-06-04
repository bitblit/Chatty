package com.erigir.chatty.ctrl;

import com.erigir.chatty.model.Message;
import com.erigir.chatty.model.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * This controller just exports content as JSON for display on the boards
 */
@Controller
public class ChatCtrl {
    private static final Logger LOG = LoggerFactory.getLogger(ChatCtrl.class);

    @RequestMapping(value = "/Message", method = RequestMethod.GET)
    public
    @ResponseBody
    MessageResponse getMessages(@RequestParam(required = false, value = "ts") final Long timestamp) {
        MessageResponse rval = new MessageResponse();
        rval.setTimestamp(System.currentTimeMillis());
        rval.setMsgs(Arrays.asList(
                new Message(System.currentTimeMillis()-10000, "Chris","Test chris msg"),
                new Message(System.currentTimeMillis()-20000, "Ayumi","Test ayumi msg")
                ));


        return rval;
    }

    @RequestMapping(value = "/Message", method = RequestMethod.POST)
    public
    @ResponseBody
    void newMessage(@RequestParam(required = false, value = "ts") final Long timestamp) {
        //return new MessageResponse();
    }


}

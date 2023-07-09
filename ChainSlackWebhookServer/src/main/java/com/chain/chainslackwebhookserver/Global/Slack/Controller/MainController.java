package com.chain.chainslackwebhookserver.Global.Slack.Controller;

import com.chain.chainslackwebhookserver.Global.Slack.domain.ServerStues;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private static final ObjectMapper om = new ObjectMapper();
    @RequestMapping("/wh/server")
    public String index() throws JsonProcessingException {
        ServerStues serverStues = ServerStues.builder()
                .targetServerId("1")
                .targetServerName("test")
                .targetServerStatus("test")
                .targetServerIp("test")
                .targetServerPort("test")
                .targetServerUserCount(1)
                .targetServerLastUpdate("test")
                .targetServerCpuUse("test")
                .targetServerMemoryUse("test")
                .build();

        return om.writer().writeValueAsString(serverStues);
    }
}

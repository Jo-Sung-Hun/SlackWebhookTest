package com.chain.chainslackwebhookserver.Global.Slack.domain;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerStues {
    private String targetServerId;
    private String targetServerName;
    private String targetServerStatus;
    private String targetServerIp;
    private String targetServerPort;
    private Integer targetServerUserCount;
    private String targetServerLastUpdate;
    private String targetServerCpuUse;
    private String targetServerMemoryUse;



}

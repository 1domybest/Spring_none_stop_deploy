package com.example.Spring_JWT.docker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@RestController
public class HealthCheckController {

    @Value("${server.env}") // blue or green
    private String env;

    @Value("${server.port}") // 서버 포트 [이거를 스와이핑하여 무중단 배포]
    private String serverPort;

    @Value("${server.serverAddress}") // 서버 주소 [localhost or 탄력적 IP]
    private String serverAddress;

    @Value("${serverName}") // 서버이름
    private String serverName;

    /**
     * 무중단 배포를 위한 상태체크 함수
     * 이 함수를 통해 라우터를 변경해줌
     * @return
     */
    @GetMapping("/hc")
    public ResponseEntity<?> healthCheck() {
        // blue -> green
        Map<String, String> responseData = new TreeMap<>();
        responseData.put("serverName", serverName);
        responseData.put("serverAddress", serverAddress);
        responseData.put("serverPort", serverPort);
        responseData.put("env", env);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/env")
    public ResponseEntity<?> getEnv() {
        return ResponseEntity.ok(env);
    }
}

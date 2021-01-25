package models;

import java.io.Serializable;

public class ClientSend implements Serializable {

    private String nickname;
    private String ip;
    private String message;

    public ClientSend(String nickname, String ip, String message) {
        this.nickname = nickname;
        this.ip = ip;
        this.message = message;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

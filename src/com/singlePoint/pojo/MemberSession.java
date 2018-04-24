package com.singlePoint.pojo;

/**
 * Created by user on 2018/4/23.
 */
public class MemberSession {
    private int id;
    private int userId;
    private String sessionId;
    private String offLineMsg;
    private int status;

    public MemberSession() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getOffLineMsg() {
        return offLineMsg;
    }

    public void setOffLineMsg(String offLineMsg) {
        this.offLineMsg = offLineMsg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemberSession)) return false;

        MemberSession that = (MemberSession) o;

        if (getId() != that.getId()) return false;
        if (getUserId() != that.getUserId()) return false;
        if (getStatus() != that.getStatus()) return false;
        if (getSessionId() != null ? !getSessionId().equals(that.getSessionId()) : that.getSessionId() != null)
            return false;
        return getOffLineMsg() != null ? getOffLineMsg().equals(that.getOffLineMsg()) : that.getOffLineMsg() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getUserId();
        result = 31 * result + (getSessionId() != null ? getSessionId().hashCode() : 0);
        result = 31 * result + (getOffLineMsg() != null ? getOffLineMsg().hashCode() : 0);
        result = 31 * result + getStatus();
        return result;
    }

    @Override
    public String toString() {
        return "MemberSession{" +
                "id=" + id +
                ", userId=" + userId +
                ", sessionId='" + sessionId + '\'' +
                ", offLineMsg='" + offLineMsg + '\'' +
                ", status=" + status +
                '}';
    }
}

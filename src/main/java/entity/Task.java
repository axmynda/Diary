package entity;


public class Task {

    private Integer id = null;
    private Integer user_id=null;
    private byte[] date;
    private String task;

    public Task(){}

    public Integer getId() {
        return id;
    }

    public void setId(int id) { this.id = id;  }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public byte[] getDate() {
        return date;
    }

    public void setDate(byte[] date) {
        this.date = date;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }


}


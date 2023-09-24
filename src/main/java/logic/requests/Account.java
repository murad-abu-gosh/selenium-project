package logic.requests;

public class Account {

    private String username;
    private String password;

    private boolean restore_account ;

    private String id_delivery_times ;




    public Account (String email , String password, boolean restore_account ,  String id_delivery_times ){
        this.username = email;
        this.password = password;
        this.restore_account = restore_account;
        this.id_delivery_times = id_delivery_times;

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRestore_account() {
        return restore_account;
    }

    public void setRestore_account(boolean restore_account) {
        this.restore_account = restore_account;
    }

    public String getId_delivery_times() {
        return id_delivery_times;
    }

    public void setId_delivery_times(String id_delivery_times) {
        this.id_delivery_times = id_delivery_times;
    }
}

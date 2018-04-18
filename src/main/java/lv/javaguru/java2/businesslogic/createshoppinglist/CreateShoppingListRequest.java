package lv.javaguru.java2.businesslogic.createshoppinglist;

public class CreateShoppingListRequest {

    private String userLogin;
    private String title;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

package user;

import java.io.Serializable;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/11/27
 */
public class User implements Serializable {
    public String name;

    public User(String name) {
        this.name = name;
    }
}

package br.com.ocpoint.model.response;

import br.com.ocpoint.model.User;
import lombok.Data;

@Data
public class UserResponse {

    public UserResponse(User createdUser) {
        this.setId(createdUser.getId());
        this.setName(createdUser.getPerson().getName());
        this.setUser(createdUser.getNameuser());
        this.setGroup(createdUser.getGroup().getName());
    }

    private Integer id;
    private String name;
    private String user;
    private String group;

}

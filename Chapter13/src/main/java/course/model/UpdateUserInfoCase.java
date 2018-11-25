package course.model;

import lombok.Data;

@Data
public class UpdateUserInfoCase {
    private  int id;
    private  int userId;
    private String uswrName;
    private String sex;
    private String age;
    private  String permission;
    private  String expected;

}

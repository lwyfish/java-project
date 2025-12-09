package javabasic.validator.demo2;

import lombok.Data;

@Data
public class User {
    /**
     * 更新操作时，ID 不能为空（属于 UpdateGroup）
     * 新增操作时，ID 由数据库生成，无需校验
     */
//    @MsNotBlank
    private Long id;

    /**
     * 新增和更新操作时，用户名都不能为空（同时属于 AddGroup 和 UpdateGroup）
     */
    @MsNotBlank
    private String username;

    /**
     * 新增操作时，密码不能为空（属于 AddGroup）
     * 更新操作时，密码可选修改，无需校验
     */
    @MsNotBlank
    private String password;

    /**
     * 无 groups 属性，默认属于 Default 分组
     */
    private String email;
}
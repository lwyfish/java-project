package javabasic.validator.demo1;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@MsObject
public class User {
    /**
     * 更新操作时，ID 不能为空（属于 UpdateGroup）
     * 新增操作时，ID 由数据库生成，无需校验
     */
    @NotNull(groups = UpdateGroup.class, message = "更新用户时ID不能为空")
    private Long id;

    /**
     * 新增和更新操作时，用户名都不能为空（同时属于 AddGroup 和 UpdateGroup）
     */
    @NotNull(groups = {AddGroup.class, UpdateGroup.class}, message = "用户名不能为空")
    private String username;

    /**
     * 新增操作时，密码不能为空（属于 AddGroup）
     * 更新操作时，密码可选修改，无需校验
     */
    @NotNull(groups = AddGroup.class, message = "新增用户时密码不能为空")
    private String password;

    /**
     * 无 groups 属性，默认属于 Default 分组
     */
    @NotNull(message = "邮箱不能为空")
    private String email;
}
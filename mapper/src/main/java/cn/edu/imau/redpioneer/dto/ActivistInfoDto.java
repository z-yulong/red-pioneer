package cn.edu.imau.redpioneer.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author: zyl
 * @date 2022/3/15 16:28
 */
@Data
public class ActivistInfoDto {
    private Integer id;
    private String account;
    private String password;
    private String name;
    private String sex;
    private String branchName;
    private String groupName;
    private Date birthday;
    private String nation;
    private String nativePlace;
    private String idCard;
    private String address;
    private String tel;
    private String email;
    private String photo;
    private String classes;
    private String train;
    private String roles;
    private Integer stateCode;
}

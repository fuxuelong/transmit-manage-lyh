package com.qk.transmit.service;

import com.qk.commonservice.sysentity.Office;
import com.qk.commonservice.sysentity.ResponseJson;
import com.qk.commonservice.sysentity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * feign调用user-service的接口
 *
 * @author caoguige
 * @date 2019/4/3
 */
@Component
@FeignClient(value = "${userApplicationName}")
//@FeignClient(value = "user-service" ,url = "10.2.73.182:7063")
public interface UserServiceClient {
    /**
     * 修改组织机构的父级机构
     *
     * @param token    令牌
     * @param officeId 组织机构id
     * @param parentId 新父级id
     * @return ResponseJson
     */
    @PostMapping(value = "/office/updateParentId")
    ResponseJson updateParentId(@RequestHeader(value = "Authorization") String token,
                                @RequestParam("officeId") String officeId,
                                @RequestParam("parentId") String parentId);

    /**
     * 获取组织机构列表
     *
     * @param token  令牌
     * @param office 组织机构实体
     * @return 组织机构列表
     */
    @PostMapping("/office/getList")
    List<Office> getList(@RequestHeader(value = "Authorization") String token,
                         @RequestBody Office office);

    /**
     * 添加组织机构
     *
     * @param token          令牌
     * @param officeParentId 父级组织机构id
     * @param office         组织机构对象
     * @param areaId         区域id
     * @return ResponseJson
     */
    @PostMapping("/office/addOffice")
    ResponseJson addOffice(@RequestHeader(value = "Authorization") String token,
                           @RequestParam("parentId") String officeParentId,
                           @RequestBody Office office,
                           @RequestParam("areaId") String areaId);

    /**
     * 修改组织机构是否可用
     *
     * @param token  令牌
     * @param office 组织机构对象
     * @return ResponseJson
     */
    @PostMapping("/office/updateUseable")
    ResponseJson updateUseable(@RequestHeader(value = "Authorization") String token,
                               @RequestBody Office office);

    /**
     * 获取组织机构信息
     *
     * @param token 凭证
     * @param names 组织机构名称串
     * @return 组织机构名称和ID的map集合，名称为key,ID为value
     */
    @PostMapping(value = "/office/getIdsByNames")
    Map<String, String> getIdsByNames(@RequestHeader(value = "Authorization") String token,
                                      @RequestParam("names") String names);

    /**
     * 上传图片
     *
     * @param token          凭证
     * @param file           前台传入的文件数据
     * @param type           上传的文件的类型 图片/文件
     * @param filePathPrefix 文件的保存路径
     * @return 操作结果
     */
    @PostMapping(value = "/user/uploadFile", consumes = "multipart/form-data")
    ResponseJson uploadFile(@RequestHeader(value = "Authorization") String token,
                            @RequestPart("file") MultipartFile file,
                            @RequestParam("type") String type,
                            @RequestParam("filePathPrefix") String filePathPrefix);

    /**
     * 删除文件
     *
     * @param token     凭证
     * @param remoteUrl FTP服务器文件路径
     * @return 操作结果
     */
    @PostMapping("/user/deleteFile")
    ResponseJson deleteFile(@RequestHeader(value = "Authorization") String token,
                            @RequestParam("remoteUrl") String remoteUrl);
    /**
     * 根据编码获取组织机构信息
     *
     * @param token 调用feign接口的凭证
     * @param code  组织机构编码
     * @return 组织机构对象
     */
    @PostMapping(value = "/office/getOfficeByCode")
    Office getOfficeByCode(@RequestHeader(value = "Authorization") String token,
                           @RequestParam("code") String code);
    /**
     * 用户添加
     *
     * @param user  用户对象
     * @param token 令牌
     * @return ResponseJson
     */
    @PostMapping("/user/addUser")
    ResponseJson addUser(@RequestHeader(value = "Authorization") String token,
                         @RequestBody User user);

    /**
     * 确定分配角色
     *
     * @param userIds 分配的用户的ID串
     * @param roleId  操作的角色ID
     * @param flag    和前台的约定
     * @param token   凭证
     * @return 返回结果ResponseCode
     */
    @PostMapping(value = "/role/allocateRole")
    Map<String, String> allocateRole(@RequestHeader(value = "Authorization") String token,
                                     @RequestParam("userIds") String userIds, @RequestParam("roleId") String roleId,
                                     @RequestParam("flag") int flag);

    /**
     * 获取用户信息
     *
     * @param info  用户ID或用户名的集合
     * @param type  判断传入的是用户名还是ID
     * @param token 令牌
     * @return 用户信息
     */
    @PostMapping("/user/getUserList")
    List<User> getUserList(@RequestHeader(value = "Authorization") String token,
                           @RequestParam("info") String info, @RequestParam("type") String type);

}


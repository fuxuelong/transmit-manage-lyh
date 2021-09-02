package com.qk.transmit.service;

import com.qk.commonservice.sysentity.Notify;
import com.qk.commonservice.sysentity.ResponseJson;
import com.qk.commonservice.sysentity.WorkFlow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 类的描述：工作流微服务Flowable-service的接口调用
 *
 * @author cgg
 * @date 2018/9/20
 */
@Component
@FeignClient(value = "${flowAbleApplicationName}")
//@FeignClient(value = "flowable-service-cgg")
public interface FlowableServiceClient {
    /**
     * 调用applicationName为flowable-service的/act/task/start请求
     *
     * @param token    调用feign接口的凭证
     * @param workFlow 流程活动对象
     * @return 返回流程实例ID
     */
    @PostMapping(value = "/act/task/start")
    String start(@RequestHeader(value = "Authorization") String token,
                 @RequestBody WorkFlow workFlow);

    /**
     * 完成任务
     *
     * @param token    令牌
     * @param workFlow 流程活动
     * @return String 流程实例id
     */
    @PostMapping(value = "/act/task/complete")
    String complete(@RequestHeader(value = "Authorization") String token, @RequestBody WorkFlow workFlow);

    /**
     * 根据流程定义key和任务定义key获取获取某一节点的流程实例id的列表
     *
     * @param token    有效的token
     * @param workFlow 流程活动,其中workFlow.proceDefKey与workFlow.taskDefKey为必填参数
     * @return List<String> 流程实例的id列表
     */
    @PostMapping(value = "/act/task/getProcInsIdList")
    List<String> getProcInsIdList(@RequestHeader(value = "Authorization") String token, @RequestBody WorkFlow workFlow);

    /**
     * 获取当前登录人已办任务的流程实例id的List集合
     *
     * @param token    有效的token
     * @param workFlow 流程活动,其中workFlow.proceDefKey为必填参数
     *                 ,可以使用workFlow.pageNum和workFlow.pageSize分页
     * @return List<String> 已办任务的流程实例id的List集合
     */
    @PostMapping(value = "/act/task/getAuditHisInsIdList")
    List<String> getAuditHisInsIdList(@RequestHeader(value = "Authorization") String token,
                                      @RequestBody WorkFlow workFlow);

    /**
     * 根据流程实例ID获取任务ID
     *
     * @param token  令牌
     * @param procId 流程实例id
     * @return List<String>  任务id集合
     */
    @PostMapping(value = "/act/task/findTaskIdByProcId")
    List<String> findTaskIdByProcId(@RequestHeader(value = "Authorization") String token,
                                    @RequestParam("procId") String procId);

    /**
     * 发送消息
     *
     * @param token  令牌
     * @param notify 通知实体
     * @return ResponseJson ResponseJson
     */
    @PostMapping("/act/notify/addNotify")
    Map<String, Object> addNotify(@RequestHeader(value = "Authorization") String token,
                                  @RequestBody Notify notify);

    /**
     * 查询某个审批组的用户列表
     *
     * @param token 令牌
     * @param code  组编码
     * @return 拥有该组的用户集合
     */
    @PostMapping("/act/group/findUserListByGroupCode")
    List<Map<String, Object>> findUserListByGroupCode(@RequestHeader(value = "Authorization") String token,
                                                      @RequestParam("code") String code);

    /**
     * 刪除流程实例
     *
     * @param token     令牌
     * @param procInsId 流程实例ID
     * @param reason    删除原因
     * @return 返回删除结果
     */
    @PostMapping(value = "/act/process/deleteProcIns")
    ResponseJson deleteProcIns(@RequestHeader(value = "Authorization") String token,
                               @RequestParam("procInsId") String procInsId,
                               @RequestParam("reason") String reason);
}

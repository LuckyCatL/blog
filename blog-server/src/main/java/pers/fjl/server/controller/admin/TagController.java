package pers.fjl.server.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pers.fjl.common.constant.MessageConstant;
import pers.fjl.common.entity.QueryPageBean;
import pers.fjl.common.entity.Result;
import pers.fjl.server.annotation.LoginRequired;
import pers.fjl.server.annotation.OptLog;
import pers.fjl.server.service.TagService;

import javax.annotation.Resource;

import static pers.fjl.common.constant.OptTypeConst.SAVE;
import static pers.fjl.common.constant.OptTypeConst.UPDATE;

/**
 * 标签管理模块
 *
 * @author fangjiale 2021年01月27日
 */

@Api(value = "后台标签管理模块", description = "标签管理模块的接口信息")
@RequestMapping("/tag")
@RestController
@CrossOrigin
public class TagController {
    @Resource
    private TagService tagService;

    @LoginRequired
    @ApiOperation(value = "个人后台标签分页查询", notes = "返回分页数据")
    @PostMapping("/findPage")
    public Result findPage(@RequestBody QueryPageBean queryPageBean) {
        return new Result(true, MessageConstant.OK, "获取分页数据成功", tagService.findPage(queryPageBean));
    }

    @ApiOperation(value = "管理员后台标签数据", notes = "返回分页数据")
    @PostMapping("/adminTag")
    public Result adminTag(@RequestBody QueryPageBean queryPageBean) {
        return new Result(true, MessageConstant.OK, "获取后台标签数据成功", tagService.adminTag(queryPageBean));
    }

//    @OptLog(optType = SAVE)
//    @PostMapping("/add")
//    public Result addType(@RequestBody Type type){
//        boolean flag = typeService.addType(type);
//        return new Result(flag,"添加成功", MessageConstant.OK);
//    }

    @GetMapping("/getTagList")
    public Result getTagList(){
        return new Result(true,MessageConstant.OK,"获取成功", tagService.getTagList());
    }


}

/*
 * Copyright 2024 XianZhi Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.xianzhi.cms.bootstrap.controller;

import io.xianzhi.cms.bootstrap.model.page.CommentPage;
import io.xianzhi.cms.bootstrap.model.vo.CommentVO;
import io.xianzhi.core.result.ListResult;
import io.xianzhi.core.result.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 评论接口
 *
 * @author Max
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    /**
     * 查询评论列表
     *
     * @param commentPage 评论查询条件
     * @return 评论列表
     * @since 1.0.0
     */
    @PostMapping("/pageCommentList")
    public ResponseResult<ListResult<CommentVO>> pageCommentList(CommentPage commentPage) {
        return ResponseResult.ok();
    }

    /**
     * 删除评论
     *
     * @param ids 评论ID
     * @return 删除结果
     */
    @PostMapping("/deletedComment")
    public ResponseResult<Object> deletedComment(List<String> ids) {
        return ResponseResult.ok();
    }
}

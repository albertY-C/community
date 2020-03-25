package chaoimi.community.controller;


import chaoimi.community.dto.CommentDTO;
import chaoimi.community.mapper.CommentMapper;
import chaoimi.community.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController {

        @Autowired
        private CommentMapper commentMapper;

        @ResponseBody
        @RequestMapping(value = "/comment", method = RequestMethod.POST)
        public Object post(@RequestBody CommentDTO commentDTO){
                Comment comment = new Comment();
                comment.setParentId(commentDTO.getParentId());
                comment.setContent(commentDTO.getContent());
                comment.setType(comment.getType());
                comment.setGmtModified(System.currentTimeMillis());
                comment.setGmtCreate(System.currentTimeMillis());
                comment.setCommentator(1);
                comment.setLikeCount(0L);
                commentMapper.insert(comment);
                return null;
        }
}
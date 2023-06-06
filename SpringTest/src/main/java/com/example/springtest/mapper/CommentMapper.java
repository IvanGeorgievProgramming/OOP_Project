package com.example.springtest.mapper;

import com.example.springtest.resources.CommentResource;
import com.example.springtest.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommentMapper {
    CommentMapper COMMENT_MAPPER = Mappers.getMapper(CommentMapper.class);

    Comment fromCommentResource(CommentResource commentResource);

    CommentResource toCommentResource(Comment comment);

    List<CommentResource> toCommentResources(List<Comment> comments);
}

package com.brian.socialmedia.service;

import com.brian.socialmedia.model.Post;

public interface CommentService {

	public void saveComment(Post post, String username, String content);

}

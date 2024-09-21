package com.jinu.jinugram.post.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jinu.jinugram.common.FileManager;
import com.jinu.jinugram.post.domain.Post;
import com.jinu.jinugram.post.dto.CardView;
import com.jinu.jinugram.post.repository.PostRepository;
import com.jinu.jinugram.user.domain.User;
import com.jinu.jinugram.user.service.UserService;

@Service // 스프링 빈으로 등록
public class PostService {
    
    private final PostRepository postRepository;
    private UserService userService;
    
    public PostService(PostRepository postRepository
    		, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }
    
    public Post addPost(int userId, String contents, MultipartFile file) {
        // 파일 저장
        String urlPath = FileManager.saveFile(userId, file);
        
        // Post 객체 생성
        Post post = Post.builder()
                    .userId(userId)
                    .contents(contents)
                    .imagePath(urlPath) 
                    .build(); 
        
        // Post 저장
        Post result = postRepository.save(post); 
        
        return result;
    }
    
    public List<CardView> getPostList(){
    	
    	List<Post> postList = postRepository.findAllByOrderByIdDesc();
    	
    	List<CardView> cardViewList = new ArrayList();
    	
    	
    	for(Post post:postList) {
    		
    		int userId = post.getUserId();
    		User user = userService.getUserById(userId);
    		
    		CardView cardView = CardView.builder()
    							.postId(post.getId())
    							.userId(userId)
    							.contents(post.getContents())
    							.imagePath(post.getImagePath())
    							.loginId(user.getLoginId())
    							.build();
    		
    		cardViewList.add(cardView);
    	}
    		
    	return cardViewList;
    }
}

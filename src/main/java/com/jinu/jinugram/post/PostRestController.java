package com.jinu.jinugram.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jinu.jinugram.post.domain.Post;
import com.jinu.jinugram.post.service.PostService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@RestController
public class PostRestController {
	
	private final PostService postService;
	
	public PostRestController(PostService postService) {
		this.postService = postService;
	}

	@PostMapping("/create")
	public Map<String, String> createPost(
			@RequestParam("contents") String contents,
			@RequestParam("imageFile") MultipartFile file,
			HttpSession session) {
		
		// 세션에서 userId 가져오기
		Integer userId = (Integer) session.getAttribute("userId");
		
		Map<String, String> resultMap = new HashMap<>();
		
		if (userId == null) {
			// 세션에 userId가 없으면 실패 처리
			resultMap.put("result", "fail");
			resultMap.put("message", "User is not logged in.");
			return resultMap;
		}
		
		// userId와 함께 포스트 추가
		Post post = postService.addPost(userId, contents, file);
		
		if (post != null) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
}

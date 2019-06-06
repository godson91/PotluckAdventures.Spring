package com.tts.PotluckAdventures.blogpost;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tts.PotluckAdventures.BlogPost;

@Controller
@RequestMapping
public class BlogPostController {
	
	@Autowired
	private BlogPostRepository BlogPostRepository;

	
	@GetMapping(value="/")
	public String index(BlogPost blogpost, Model model) {
		model.addAttribute("posts", BlogPostRepository.findAll());
		return "blogpost/index";
	}
	
	@GetMapping(value = "/blogpost/new")
    public String newNewBlog (BlogPost blogPost, Model model) {
		
        return "blogpost/new";
		
    }
	
	
	private BlogPost blogpost;

	
	
	
	@RequestMapping(value = "/destroyblogpost/{id}", method = RequestMethod.DELETE)
	public String deletePostWithId(@PathVariable Long id, BlogPost blogPost) {
		
		BlogPostRepository.deleteById(id);
		return "/blogpost/index";
		}
		
		
	
	@PostMapping(value = "/blogpost/new")
	public String addNewBlogPost(BlogPost blogPost, Model model) {
		BlogPostRepository.save(new BlogPost(blogPost.getTitle(), blogPost.getAuthor(), blogPost.getBlog_entry()));
		
		model.addAttribute("title", blogPost.getTitle());
		model.addAttribute("author", blogPost.getAuthor());
		model.addAttribute("blog_entry", blogPost.getBlog_entry());
		return "blogpost/results";
	}
	@RequestMapping(value = "/blogpost/{id}" , method = RequestMethod.GET)
	public String showPostById(@PathVariable long id, Model model) {
	BlogPost blogPost = BlogPostRepository.findById(id).orElse(null);
	model.addAttribute("posts", blogPost);
	return "blogpost/show";
	}
	@RequestMapping(value="/blopost/update/{id}", method= RequestMethod.GET)
	public String updateForm(@PathVariable long id, Model model) {
		BlogPost blogpost = BlogPostRepository.findById(id).orElse(null);
		model.addAttribute("posts", blogpost);
		return "blogpost/update";
	}
	
	@RequestMapping(value ="/blogpost/{id}", method= RequestMethod.PUT)
	public String updatePostsById(@PathVariable long id, Model model, BlogPost blogpost) {
	BlogPost editedWumbology = BlogPostRepository.findById(id).orElse(null);
	editedWumbology.setAuthor(blogpost.getAuthor());
	editedWumbology.setTitle(blogpost.getTitle());
	editedWumbology.setBlog_entry(blogpost.getBlog_entry());
	BlogPostRepository.save(editedWumbology);
	model.addAttribute("title", editedWumbology.getTitle());
	model.addAttribute("author", editedWumbology.getAuthor());
	model.addAttribute("blog_entry", editedWumbology.getBlog_entry());
	model.addAttribute("id", editedWumbology.getId());
	return "blogpost/results";

	}
	
//	@RequestMapping(value = "/blogpost/{id}" , method = RequestMethod.GET)
//	public String showPostById(@PathVariable long id, blogpost blogpost, Model model) {
//		model.addAttribute("posts", blogpost.getId());
//		model.addAttribute("posts", blogpost.getAuthor());
//		model.addAttribute("posts", blogpost.getBlog_entry());
//		model.addAttribute("posts", blogpost.getTitle());
//
//		return "blogpost/show";
//	}
	
	
	//@DeleteMapping
	
	
}



// get mappping and add requestmapping
//put
//post
//delete

//update blogpost
// - button to update form
// - update form 
// - put method
// - redirect page




// button to click - first 
// pass the id to the controller
//set the url mappingwith the @PathVariable
//find the blog post in the database
// serve the view
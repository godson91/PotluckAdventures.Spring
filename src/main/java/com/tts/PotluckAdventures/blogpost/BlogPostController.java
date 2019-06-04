package com.tts.PotluckAdventures.blogpost;

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

@Controller
@RequestMapping
public class BlogPostController {
	
	@Autowired
	private BlogPostRepository BlogPostRepository;
    private static List<blogpost> posts = new ArrayList<>();

	
	@GetMapping(value="/")
	public String index(blogpost blogpost, Model model) {
		model.addAttribute("posts", posts);
		return "blogpost/index";
	}
	
	@GetMapping(value = "/blogpost/new")
    public String newNewBlog (blogpost blogPost) {
        return "blogpost/new";
		
    }
	@RequestMapping(value = "/destroyblogpost/{id}", method = RequestMethod.DELETE)
	public String destroyBlogPostById(@PathVariable long id, blogpost blogpost, Model model) {
		BlogPostRepository.deleteById(id);
		model.addAttribute("posts", BlogPostRepository.findAll());
	return "blogpost/index";
	}
	
	
	
	private blogpost blogpost;
	@RequestMapping(value = "/blogpost/{id}", method = RequestMethod.DELETE)
	public String deletePostWithId(@PathVariable Long id, blogpost blogPost) {
		for (int i = 0; i < posts.size(); i++) {
			if (id == posts.get(i).getId()) {
				posts.remove(i);
			}
		
		BlogPostRepository.deleteById(id);
		return "blogpost/index";}
		return null;}
		
	
	@PostMapping(value = "/blogpost/new")
	public String addNewBlogPost(blogpost blogPost, Model model) {
		BlogPostRepository.save(new blogpost(blogPost.getTitle(), blogPost.getAuthor(), blogPost.getBlog_entry()));
		posts.add(blogPost);
		model.addAttribute("title", blogPost.getTitle());
		model.addAttribute("author", blogPost.getAuthor());
		model.addAttribute("blog_entry", blogPost.getBlog_entry());
		return "blogpost/results";
	}
	
	@RequestMapping(value = "/blogpost/{id}" , method = RequestMethod.GET)
	public String showPostById(@PathVariable long id, blogpost blogpost, Model model) {
		model.addAttribute("posts", BlogPostRepository.findById(id));
		return "blogpost/show";
	}
	
	
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
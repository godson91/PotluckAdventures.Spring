package com.tts.PotluckAdventures;


	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	@Entity
	public class BlogPost {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		
		private long id;
		private String author;
		private String blog_entry;
		private String title;
		
		public BlogPost() {
			
		}
		
		public BlogPost(String title, String author, String blog_entry) {
			this.title = title;
			this.author = author;
			this.blog_entry = blog_entry;
		
		}
		
		public long getId() {
			return id;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getBlog_entry() {
			return blog_entry;
		}

		public void setBlog_entry(String blog_entry) {
			this.blog_entry = blog_entry;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
		
		@Override
		public String toString() {
			return "BlogPost: id = " +id+ " Author = " + author+ "title = " +title+ " blog_entry = " +blog_entry; 
	 	}

		
		
//		1. create class attributes
//		2. create nonargument constructor
//		3. create arguement constructor
//		4. create getters and setters
	//	
	}



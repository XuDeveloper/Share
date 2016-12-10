package com.example.share.data;

import java.util.ArrayList;
import java.util.List;

import com.example.share.model.Comment;
import com.example.share.model.Like;
import com.example.share.model.ShareArticle;
import com.example.share.model.User;

public class Data {
	public static List<ShareArticle> mShareArticleList = new ArrayList<ShareArticle>();
	public static User mUser = new User();
	private static boolean ifFirst = true;
	public void init(){
		if(ifFirst){
			initUser();
			initShareArticle();
			ifFirst = false;
		}
	}
	private void initUser(){
		mUser.setmName("Raymond");
		mUser.setmSex("男");
		mUser.setmDescription("哈哈");

	}

	private void initShareArticle(){
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		user1.setmName("Allen");
		user2.setmName("Xu");
		user3.setmName("Doll");
		List<ShareArticle> mLikeArticles1 = new ArrayList<ShareArticle>();
		List<ShareArticle> mLikeArticles2 = new ArrayList<ShareArticle>();
		List<ShareArticle> mLikeArticles3 = new ArrayList<ShareArticle>();
//		user1.setmLikeArticles(mLikeArticles1);
//		user2.setmLikeArticles(mLikeArticles2);
//		user3.setmLikeArticles(mLikeArticles3);
		ShareArticle mArticle1 = new ShareArticle();
		mArticle1.setmUserName("Raymond");
		mArticle1.setContent("首先你要认真上课然后认真做作业，最重要的是考试之前那几周准备好复习资料，而这些还不是最关键的，最关键的一步就是......" +
				"首先你要认真上课然后认真做作业，最重要的是考试之前那几周准备好复习资料，而这些还不是最关键的，最关键的一步就是......" +
				"首先你要认真上课然后认真做作业，最重要的是考试之前那几周准备好复习资料，而这些还不是最关键的，最关键的一步就是......");
		mArticle1.setDate("2016/5/7/16/5");
		mArticle1.setmTitle("C++4.0全攻略");
		mArticle1.setmTag("学习");
		List<Like> likeList1 = new ArrayList<Like>(); 
		Like like1 = new Like();
		like1.setmUser(user1);
		mLikeArticles1.add(mArticle1);
		like1.setmUserName("Allen");
		like1.setmDate("2016/5/8/7/46");
		likeList1.add(like1);
		likeList1.add(like1);
		likeList1.add(like1);
		List<Comment> CommentList1 = new ArrayList<Comment>();
		Comment comment1 = new Comment();
		comment1.setmComment("我很赞同你");
		comment1.setmDate("2016/5/8/7/49");
		comment1.setmUserName("Doll");
		CommentList1.add(comment1);
		CommentList1.add(comment1);
		CommentList1.add(comment1);
		mArticle1.setmComments(CommentList1);
		mArticle1.setmLikes(likeList1);
		mShareArticleList.add(mArticle1);
		ShareArticle mArticle2 = new ShareArticle();
		mArticle2.setmUserName("XU");
		mArticle2.setContent("作为一名Java的完全自学者。我来说说吧，希望能给大家带来点帮助，如果有不同意见的大家一起来讨论，总之，希望大家可以共同进步。。废话不多说了。。进去正题。。"+
"学习Java呢如果你学过别的面向对象的语言那么通过类比我觉得你一定学起来比较轻松，当然了我们这里就从什么语言没学过的小白说起。。"+
"首先来给大家推荐几本参考书。"+
"ONE:"+
"当初java入门的时候看了一些书，现在想起来特别喜欢 head first java。读起来的感觉就是不一样。强烈推荐！！"+
"这本书我推荐对面向对象编程和其他计算机语言不熟悉的初学者，通俗易懂，讲的全是基础，不会让你被那些繁多的类，方法啥的弄的失去兴趣，因为里面全是基础大家认真看完即可。。。强力推荐这本。"+
"疯狂Java 作者:李刚"+
"这本书讲的极其细致，不过信息量太大，对于初学者来说任务太重。。如果你掌握了上面那本书的知识点，那我强烈建议你买下这本厚书好好研读，也可以将这本书作为一个类库来查阅。。总之知识点应有尽有。");
		mArticle2.setDate("2016/5/7/20/55");
		mArticle2.setmTitle("如何学习Java");
		mArticle2.setmTag("学习");
		List<Like> likeList2 = new ArrayList<Like>();
		likeList2.add(like1);
		likeList2.add(like1);
		Like like2 = new Like();
		like2.setmUser(user2);
		like2.setmUserName("Xu");
		like2.setmDate("2016/5/8/7/56");
		likeList2.add(like2);
		likeList2.add(like2);
		likeList2.add(like2);
		Comment comment2 = new Comment();
		comment2.setmComment("你说的都对");
		comment2.setmDate("2016/5/8/7/49");
		comment2.setmUserName("Raymond");
		List<Comment> commentList2 = new ArrayList<Comment>();
		commentList2.add(comment1);
		commentList2.add(comment1);
		commentList2.add(comment2);
		commentList2.add(comment2);
		commentList2.add(comment2);
		mArticle2.setmLikes(likeList2);
		mArticle2.setmComments(commentList2);
		mShareArticleList.add(mArticle2);
		ShareArticle mArticle3 = new ShareArticle();
		mArticle3.setmUserName("Raymond");
		mArticle3.setDate("2016/5/7/21/5");
		mArticle3.setmTag("运动");
		mArticle3.setmTitle("运动受伤怎么办");
		mArticle3.setContent("扭伤是生活中难免发生的问题，尤其是脚踝关节是最容易扭伤的部位，一旦扭到，最直接的反应就是「痛」，然后才会依扭伤的程度，" +
				"看看是否会有肿胀或是瘀血的情形。对于这种伤害，许多人常不以为意，而常常旧疾未愈，新伤复发，成为习惯性反复扭伤，影响运动机能与日常生活。");
		List<Like> likeList3 = new ArrayList<Like>();
		List<Comment> commentList4 = new ArrayList<Comment>();
		likeList3.add(like1);
		mArticle3.setmLikes(likeList3);
		mArticle3.setmComments(commentList4);
		mShareArticleList.add(mArticle3);
		mArticle2.setDate("2016/5/7/22/5");
		List<Like> likeList4 = new ArrayList<Like>();
		likeList4.add(like1);
		likeList4.add(like1);
		likeList4.add(like1);
		likeList4.add(like1);
		likeList4.add(like2);
		likeList4.add(like2);
		List<Comment> commentList3 = new ArrayList<Comment>();
		commentList3.add(comment1);
		commentList3.add(comment1);
		commentList3.add(comment1);
		commentList3.add(comment1);
		commentList3.add(comment1);
		commentList3.add(comment2);
		commentList3.add(comment2);
		commentList3.add(comment2);
		commentList3.add(comment2);
		mArticle2.setmLikes(likeList4);
		mArticle2.setmComments(commentList3);
		mShareArticleList.add(mArticle2);
		mLikeArticles1.add(mArticle2);
		mLikeArticles2.add(mArticle1);
		mLikeArticles2.add(mArticle2);
		mLikeArticles2.add(mArticle3);
		user1.setmLikeArticles(mLikeArticles1);
		user2.setmLikeArticles(mLikeArticles2);
		List<ShareArticle> mLikeArticles = new ArrayList<ShareArticle>();
		mLikeArticles.add(mArticle1);
		mLikeArticles.add(mArticle2);
		mUser.setmLikeArticles(mLikeArticles);
	}
}

package com.example.share.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.share.model.Like;
import com.example.share.model.ShareArticle;
import com.example.share.model.User;

//使用：调用rank函数，传入当前用户和某条分享，返回此分享的分数，分数越大，推荐度越高��������Խ���Ƽ���Խ��
public class Rank {

	
	public static double rank(User user, ShareArticle shareArticle) throws ParseException {
		List<Like> likes = shareArticle.getmLikes();
		double total = 0;
		double k = 1;
		for (Like l: likes) {
			User u = l.getmUser();
			double tempWeight = user.getmLikeArticles().size() + u.getmLikeArticles().size() + 1.0;
			List<ShareArticle> uArticle = new ArrayList<>();
			uArticle.addAll(u.getmLikeArticles());
			uArticle.retainAll(user.getmLikeArticles());
			if (uArticle.size() == 0) continue;
			double weight = uArticle.size() + 1.0;
			k++;
			weight /= tempWeight;
			total += weight;
		}
		if (total == 0) return 1.0;
		Calendar now = Calendar.getInstance();
		Calendar past = Calendar.getInstance();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		past.setTime(sim.parse(setTime(shareArticle.getDate())));
		double time = 3.4;
		double t = (now.get(Calendar.YEAR) - past.get(Calendar.YEAR)) * 365 * 24 * 60 +
				(now.get(Calendar.MONTH) - past.get(Calendar.MONTH)) * 30 * 24 * 60 +
				(now.get(Calendar.HOUR) - past.get(Calendar.HOUR)) * 60 +
				(now.get(Calendar.MINUTE) - past.get(Calendar.MINUTE));
		time -= t * 0.1;
		if (time < 1)
			time = 3.4 / k;
		total *= time;
		return total;
	}
	private static String setTime(String time){
		String[] str = time.split("/");
		return str[0] + "-" + str[1] + "-" + str[2] + " " + str[3] + ":" + str[4];
	}
}
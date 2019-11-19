package com.training.streamapiassignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class NewsDao {
	
	
//	public static Optional<Integer> getNewsIdmaxComment(List<News> news)
//	{
//		Optional<Integer> getNewsIdMaxComment=
//				news.stream()
//				.map(n->n.getNewsId())
//                .collect(Collectors.maxBy((trans1,trans2)->trans1.getComment().compareTo(trans2.getComment())));
//			   
//			  
//				
//		return getNewsIdMaxComment;
//
//		
//				
//	}
	/**
	 * 
	 * @param news
	 * @return long
	 */
	public static long getMaxCountofWordBudegetFromUserComment(List<News>news)
	{
		long countBudget=news.stream()
				.filter(n->n.getCommentByUser().contains("budget"))
				.count();
		return countBudget;
	}
    
//	public static List<String> getUserWhoPostedMaxiumComments(List<News> news)
//	{
//		News userPostedMaxComment=news.stream()
//				.map(n->n.getPostedByUser())
// 			    .max((n1,n2)->)
//			    .get();
//
//	}
	/**
	 * 
	 * @param news
	 * @param commentByUser
	 * @return long
	 */
	public static long getCommentByUserwiseNumberOfComments(List<News> news,String commentByUser)
	{
		long numberOfComments=news.stream()
				.filter(n->n.getCommentByUser().equals(commentByUser))
				.count();
		return numberOfComments;

				
				
	}
	public static  HashMap<String, ArrayList<String>> mapByColor(List<News>news){


        HashMap<String, ArrayList<String>> parts = new HashMap<String, ArrayList<String>>();


        news.stream()
              .forEach(n -> {
                  if (parts.containsKey(n.getCommentByUser())) {
                      ArrayList<String> obj = parts.get(n.getCommentByUser());
                      obj.add(n.getComment());
                      parts.put(n.getCommentByUser(), obj);
                  } else {
                      ArrayList<String> obj = new ArrayList<String>();
                      obj.add(n.getComment());
                      parts.put(n.getCommentByUser(), obj);
                  }
              });
        return parts;
    }


	
	
}

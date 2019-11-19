package com.training.streamapiassignment.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.training.streamapiassignment.News;
import com.training.streamapiassignment.NewsDao;

public class NewsTest {
	List<News> news;
	@Before
	public void setUp() {
		news=Arrays.asList(
		new News(101,"Priya Pathak","Great News","Good News "),
		new News(102,"Prisha Naik","budget is hiking ","budget Issue increasing"),
		new News(103,"Yashika","budget chart","very good chart"));
	}

	@Test
	public void testGetMaxCountofWordBudegetFromUserComment() {
		long expected=2;
		assertEquals(expected,NewsDao.getMaxCountofWordBudegetFromUserComment(news));

	}
   @Test
   public void testGetCommentByUserwiseNumberOfComments() {
	   long expected=1;
	   assertEquals(expected,NewsDao.getCommentByUserwiseNumberOfComments(news, "Prisha Naik"));
   }
   
//   @Test
//   public void testGetNewsIdmaxComment() {
//	   System.out.println(NewsDao.getNewsIdmaxComment(news));
//   }
}

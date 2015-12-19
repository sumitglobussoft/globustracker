/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ranktracker.service.KeywordsService;
import ranktracker.service.KeywordsServiceImpl;

/**
 *
 * @author GLB-131
 */
@Controller
public class AjaxController {

	@RequestMapping(value = "/refreshSerpsGoogleKeyword.htm", method = RequestMethod.GET)
	public @ResponseBody
	String refreshSerpsGoogleKeyword(@RequestParam(value = "jString") String jString, HttpServletRequest objRequest) {
		HttpSession objSession;
		KeywordsService objKeywordsService = new KeywordsServiceImpl();
		JSONObject json = new JSONObject();
		String message = "";

		//initializing http session object
		objSession = objRequest.getSession();
		System.out.println("" + objSession.getAttribute("customerID"));
		//checking for 'customerID' attribute in session
		if (objSession.getAttribute("customerID") != null) {
			String[] data = jString.split(":");
			Integer keywordId = Integer.parseInt(data[0]);
			System.out.println("keywordId ------------------= " + keywordId);
			String keywordName = data[1];
			System.out.println("keywordName --------------= " + keywordName);

			Integer customerID = Integer.parseInt(objSession.getAttribute("customerID").toString());
			System.out.println("customerID = " + customerID);

			//now invoking the refreshKeyword() method of KeywordServiceImpl
			try {
				int updated = objKeywordsService.refreshGoogleKeyword(keywordId);
				if (updated == 1) {
					message = "'" + keywordName + "' keyword will get updated, just wait for few minutes";
					System.out.println("message = " + message);
					json.put("message", message);
				} else {
					message = "Sorry Keyword Name '" + keywordName + "' cannot be refreshed!! You can refresh a keyword once a day!!  Try it tomorrow";
					System.out.println("message = " + message);
					json.put("message", message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return json.toString();
	}

	@RequestMapping(value = "/refreshSerpsYahooKeyword.htm", method = RequestMethod.GET)
	public @ResponseBody
	String refreshSerpsYahooKeyword(@RequestParam(value = "jString") String jString, HttpServletRequest objRequest) {
		HttpSession objSession;
		KeywordsService objKeywordsService = new KeywordsServiceImpl();
		JSONObject json = new JSONObject();
		String message = "";

		//initializing http session object
		objSession = objRequest.getSession();
		System.out.println("" + objSession.getAttribute("customerID"));
		//checking for 'customerID' attribute in session
		if (objSession.getAttribute("customerID") != null) {
			String[] data = jString.split(":");
			Integer keywordId = Integer.parseInt(data[0]);
			System.out.println("keywordId ------------------= " + keywordId);
			String keywordName = data[1];
			System.out.println("keywordName --------------= " + keywordName);

			Integer customerID = Integer.parseInt(objSession.getAttribute("customerID").toString());
			System.out.println("customerID = " + customerID);

			//now invoking the refreshKeyword() method of KeywordServiceImpl
			try {
				int updated = objKeywordsService.refreshYahooKeyword(keywordId);
				if (updated == 1) {
					message = "'" + keywordName + "' keyword will get updated, just wait for few minutes";
					System.out.println("message = " + message);
					json.put("message", message);
				} else {
					message = "Sorry Keyword Name '" + keywordName + "' cannot be refreshed!! You can refresh a keyword once a day!!  Try it tomorrow";
					System.out.println("message = " + message);
					json.put("message", message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return json.toString();
	}
	
	@RequestMapping(value = "/refreshSerpsBingKeyword.htm", method = RequestMethod.GET)
	public @ResponseBody
	String refreshSerpsBingKeyword(@RequestParam(value = "jString") String jString, HttpServletRequest objRequest) {
		HttpSession objSession;
		KeywordsService objKeywordsService = new KeywordsServiceImpl();
		JSONObject json = new JSONObject();
		String message = "";

		//initializing http session object
		objSession = objRequest.getSession();
		System.out.println("" + objSession.getAttribute("customerID"));
		//checking for 'customerID' attribute in session
		if (objSession.getAttribute("customerID") != null) {
			String[] data = jString.split(":");
			Integer keywordId = Integer.parseInt(data[0]);
			System.out.println("keywordId ------------------= " + keywordId);
			String keywordName = data[1];
			System.out.println("keywordName --------------= " + keywordName);

			Integer customerID = Integer.parseInt(objSession.getAttribute("customerID").toString());
			System.out.println("customerID = " + customerID);

			//now invoking the refreshKeyword() method of KeywordServiceImpl
			try {
				int updated = objKeywordsService.refreshBingKeyword(keywordId);
				if (updated == 1) {
					message = "'" + keywordName + "' keyword will get updated, just wait for few minutes";
					System.out.println("message = " + message);
					json.put("message", message);
				} else {
					message = "Sorry Keyword Name '" + keywordName + "' cannot be refreshed!! You can refresh a keyword once a day!!  Try it tomorrow";
					System.out.println("message = " + message);
					json.put("message", message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return json.toString();
	}
}

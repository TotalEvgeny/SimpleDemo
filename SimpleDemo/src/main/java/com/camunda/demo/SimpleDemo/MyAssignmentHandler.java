package com.camunda.demo.SimpleDemo;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;


public class MyAssignmentHandler implements TaskListener {
	
	private final static Logger LOG = Logger.getLogger(MyAssignmentHandler.class.getName());
	
	  public void notify(DelegateTask delegateTask) {
	    // Execute custom identity lookups here
	    // and then for example call following methods:
		  
		 Map<String,Object> variables = delegateTask.getVariables();
		 LOG.info("get assign"+variables.get("assigns"));
		 List<Object> assigns = (List<Object>) variables.get("assigns");
		 for (Object assign : assigns) {
			 //LOG.info("for get assign"+assign);
	        }
		 
		 LOG.info("get userId"+variables.get("userId"));

		//List<String> assigns =  
		String assignUser = variables.get("userId").toString();
	    delegateTask.setAssignee(assignUser);
	    
	    delegateTask.setVariable("thisOk", "123");
	     LOG.info("\n\n\n    param thisOk "+ delegateTask.getVariable("thisOk") +"\n\n\n");
	     LOG.info("\n\n\n    param thisOk_new "+ delegateTask.getVariable("thisOk_new") +"\n\n\n");
	    //delegateTask.addCandidateUser("fozzie");
	    //delegateTask.addCandidateGroup("management");
	    
	  }
	}
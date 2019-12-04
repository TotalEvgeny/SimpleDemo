package com.camunda.demo.SimpleDemo;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import java.util.logging.Logger;

public class CreateTask implements JavaDelegate {

	private final static Logger LOG = Logger.getLogger(CreateTask.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		LOG.info("\n\n\n    Start cewate task "+"\n\n\n");

		// IdentityService identityService = Context.getProcessEngineConfiguration().getIdentityService();
	    // User user = identityService.createUserQuery().userId(assignee).singleResult();
	    
	  // check if the first task listener was executed
	     List<String> assigneeList = new ArrayList<>();//InformAssigneeTaskListener.assigneeList;
	     assigneeList.add("demo");
	     assigneeList.add("test");
	     execution.setVariable("assigns", assigneeList);
	     LOG.info("\n\n\n    Start cewate task "+assigneeList.toString() +"\n\n\n");
	     //assertThat(assigneeList.size(), is(1));
	     //assertThat(assigneeList.get(0), is("Kermit"));

	     execution.setVariable("thisOk_new", "123456");
	     // complete first user task
	     //Task task = taskService.createTaskQuery().singleResult();
	     //taskService.complete(task.getId());

	}

}

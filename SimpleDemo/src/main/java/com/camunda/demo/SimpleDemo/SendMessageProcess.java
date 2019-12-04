package com.camunda.demo.SimpleDemo;

import java.util.logging.Logger;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

public class SendMessageProcess implements TaskListener {

	private final static Logger LOG = Logger.getLogger(SendMessageProcess.class.getName());
	@Override
	public void notify(DelegateTask delegateTask) {
		// TODO Auto-generated method stub
		LOG.info("\n\n\n    Send MEssage for  finish task " +"\n\n\n");
		// broadcast signal
		RuntimeService runtimeService = delegateTask.getProcessEngineServices().getRuntimeService();
		runtimeService
		  .createSignalEvent("Signal_1tfma1c")
		  //.setVariables(variables)
		  .send();
		  
		// deliver a signal to a single execution
		/*runtimeService
		  .createSignalEvent("signalName")
		  .executionId(executionId)
		  .setVariables(variables)
		  .send(); */
		//RuntimeService runtimeService = delegateTask.getProcessEngineServices().getRuntimeService();
		//runtimeService.startProcessInstanceByMessage("instantiationMessage");
	}

}

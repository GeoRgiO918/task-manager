package com.georgiiHadzhiev.component.task.strategy.execution;

import com.georgiiHadzhiev.entity.task.Task;

public interface TaskExecuteStrategy {

    public void execute(Task task);

    public Class<? extends Task> getSupportedType();

}

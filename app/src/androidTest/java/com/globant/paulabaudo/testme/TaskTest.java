package com.globant.paulabaudo.testme;

import junit.framework.TestCase;

/**
 * Created by paula.baudo on 8/6/2015.
 */
public class TaskTest extends TestCase {
    final static String TEST_TASK_NAME = "Test task";
    final static String TEST_TASK_DONE_STRING = "Test task: Done";
    final static String TEST_TASK_NOT_DONE_STRING = "Test task: Not done";

    Task mTask; //sut - System under test

    @Override
    public void setUp() throws Exception {
        super.setUp();
        mTask = new Task();
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testDoneStatusIsDisplayedProperly() throws Exception {
        // Arrange
        mTask.setName(TEST_TASK_NAME);
        mTask.setDone(true);

        // Act
        String taskString = mTask.toString();

        // Assert
        assertEquals("String must use the format <task name>: Done", taskString, TEST_TASK_DONE_STRING);
    }
}

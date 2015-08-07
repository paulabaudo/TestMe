package com.globant.paulabaudo.testme;

import junit.framework.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by paula.baudo on 8/6/2015.
 */
public class TaskTest extends TestCase {
    final static String TEST_TASK_NAME = "Test task";
    final static String TEST_TASK_DONE_STRING = "Test task: Done";
    final static String TEST_TASK_NOT_DONE_STRING = "Test task: Not done";
    final static Integer TEST_TASK_TIME_SPENT = 12;
    final static long CURRENT_DATE = (long) 2548752l;

    public static class TestableTask extends Task{
        @Override
        protected Date getCurrentDate() {
            return new Date(CURRENT_DATE);
        }
    }

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

    public void testNotDoneStatusIsDisplayedProperly() throws Exception {
        mTask.setName(TEST_TASK_NAME);
        mTask.setDone(false);

        assertEquals("String must use the format <task name>: Not done", mTask.toString(), TEST_TASK_NOT_DONE_STRING);
    }

    public void testTwentyHoursSpent() throws Exception {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(7);

        Integer timeSpent = 0;
        for (int i = 0; i < numbers.size(); i++){
            timeSpent += numbers.get(i);
        }

        assertEquals("Time spent must be 12 hours", TEST_TASK_TIME_SPENT, timeSpent);
    }

    public void testDoneDateIsSetToCurrentDateWhenTaskIsDone() throws Exception {
        TestableTask testableTask = new TestableTask();
        testableTask.setDone(true);
        assertEquals(testableTask.getDoneDate(), new Date(CURRENT_DATE));
    }
}

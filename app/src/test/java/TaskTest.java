import com.globant.paulabaudo.testme.Task;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by paula.baudo on 8/6/2015.
 */
public class TaskTest {
    final static String TEST_TASK_NAME = "Test task";
    final static String TEST_TASK_DONE_STRING = "Test task: Done";
    final static String TEST_TASK_NOT_DONE_STRING = "Test task: Not done";
    final static Integer TEST_TASK_TIME_SPENT = 12;
    final static long CURRENT_DATE = (long) 2548752l;

    public static class TestableTask extends Task {
        @Override
        protected Date getCurrentDate() {
            return new Date(CURRENT_DATE);
        }
    }

    Task mTask; //sut - System under test

    @Before
    public void init() throws Exception {
        mTask = new Task();
    }

    @After
    public void destroy() throws Exception {
        mTask = null;
    }

    @Ignore
    @Test
    public void doneStatusIsDisplayedProperly() throws Exception {
        // Arrange
        mTask.setName(TEST_TASK_NAME);
        mTask.setDone(true);

        // Act
        String taskString = mTask.toString();

        // Assert
        assertEquals("String must use the format <task name>: Done", taskString, TEST_TASK_DONE_STRING);
    }

    @Test
    public void notDoneStatusIsDisplayedProperly() throws Exception {
        mTask.setName(TEST_TASK_NAME);
        mTask.setDone(false);

        assertEquals("String must use the format <task name>: Not done", mTask.toString(), TEST_TASK_NOT_DONE_STRING);
    }

    @Test
    public void twentyHoursSpent() throws Exception {
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

    @Test
    public void doneDateIsSetToCurrentDateWhenTaskIsDone() throws Exception {
        TestableTask testableTask = new TestableTask();
        testableTask.setDone(true);
        assertEquals(testableTask.getDoneDate(), new Date(CURRENT_DATE));
    }
}

package ru.st.selenium.test.data;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private int retryCount = 0;
    private int maxRetryCount = 1;

    // Below method returns 'true' if the test method has to be retried else 'false' 
    //and it takes the 'Result' as parameter of the test method that just ran
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            System.out.println("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " time(s).");
            retryCount++;
            return true;
        }
        return false;
    }

    public String getResultStatusName(int status) {
        String resultName = null;
        if (status == 1)
            resultName = "SUCCESS";
        if (status == 2)
            resultName = "FAILURE";
        if (status == 3)
            resultName = "SKIP";
        return resultName;
    }
}

   /* private int count = 0;
    private int maxCount = 2;  // retry a failed test 2 additional times

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            if (count < maxCount) {
                count++;
                result.setStatus(ITestResult.SUCCESS_PERCENTAGE_FAILURE);
                String message = Thread.currentThread().getName()
                        + "Error in '" + result.getName() + "' with status '"
                        + result.getStatus() + "'. Retrying '" + count
                        + "' times.";
                System.out.println(message);
                return true;
            }
        }

        return false;
    } */


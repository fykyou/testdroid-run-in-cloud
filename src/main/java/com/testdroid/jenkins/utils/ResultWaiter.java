package com.testdroid.jenkins.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Krzysztof Fonal <krzysztof.fonal@bitbar.com>
 */
public class ResultWaiter {

    private static ResultWaiter instance;

    private Map<Long, Object> runIdWaitingObjectsMap = new HashMap<Long, Object>();

    public static ResultWaiter getInstance() {
        if (instance == null) {
            instance = new ResultWaiter();
        }

        return instance;
    }

    public void removeFromWaitList(Long testRunId) {
        runIdWaitingObjectsMap.remove(testRunId);
    }

    public void putToWaitList(Long testRunId, Object waitingObject) {
        runIdWaitingObjectsMap.put(testRunId, waitingObject);
    }

    public void notifyWaitingObject(Long testRunId) {
        Object waitingObject = runIdWaitingObjectsMap.get(testRunId);
        if (waitingObject != null) {
            synchronized (waitingObject) {
                waitingObject.notify();
            }
        }
    }
}

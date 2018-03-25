package com.bgu.workground.assignment1;

public class Assignment1Tester {

    public static void main(String[] args) throws Exception{
        testPart1();
        testPart2();
        System.out.println("All tests passed!");

    }

    private static void testPart2() throws Exception {
        int []arr4k = new int[]{30, 35, 40, 45, 1, 5, 10, 15, 20, 25};
        int []sortedArray = new int[]{1, 5, 10, 15, 20, 25, 30, 35,40, 45};
        int []sortedArray2 = new int[]{2, 2, 2};
        //assertion(Tasks.getIndex(arr4k,35) == 1, getLineNumber());
        assertion(Tasks.getIndex(arr4k,15) == 7, getLineNumber());
        assertion(Tasks.getIndex(sortedArray,15) == 3, getLineNumber());
        assertion(Tasks.getIndex(arr4k,100) == -1, getLineNumber());
        assertion(Tasks.getIndex(sortedArray,100) == -1, getLineNumber());
        assertion(Tasks.getIndex(arr4k,32) == -1, getLineNumber());
        assertion(Tasks.getIndex(sortedArray,32) == -1, getLineNumber());
        assertion(Tasks.getIndex(new int[]{},10) == -1, getLineNumber());
        assertion(Tasks.getIndex(sortedArray2,2) != -1, getLineNumber());

    }

    private static void testPart1() throws Exception {
        int []A1 = new int[]{22, 5, 4, 15, 5, 25, 30, 35, 40, 17};
        int []A2 = new int[]{11, 3, 9, 6, 7, 8, 11, 90, 3, 20};
        assertion(Tasks.isSumExist(41,A1,A2).equals("YES"), getLineNumber());
        assertion(Tasks.isSumExist(100,A1,A2).equals("NO"), getLineNumber());
        assertion(Tasks.isSumExist(3,A1,A2).equals("NO"), getLineNumber());

    }

    public static void assertion(boolean value, int lineNumber) throws Exception {
        if(!value) throw new Exception("Failed test at line: " + lineNumber);
    }

    public static int getLineNumber() {
        return strictlyNamedMethodForGettingLineNumber();
    }

    private static int strictlyNamedMethodForGettingLineNumber() {
        boolean thisOne = false;
        int thisOneCountDown = 1;
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        for(StackTraceElement element : elements) {
            String methodName = element.getMethodName();
            int lineNum = element.getLineNumber();
            if(thisOne && (thisOneCountDown == 0)) {
                return lineNum;
            } else if(thisOne) {
                thisOneCountDown--;
            }
            if(methodName.equals("strictlyNamedMethodForGettingLineNumber")) {
                thisOne = true;
            }
        }
        return -1;
    }
}

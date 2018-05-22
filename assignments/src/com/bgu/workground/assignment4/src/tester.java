package com.bgu.workground.assignment4.src;

public class tester {

    public static void main(String[] args) throws Exception{
        //PrintTree();
        testPart1();
        //testPart2();
        //System.out.println("All tests passed!");

    }

    //private void

    public static void PrintTree(String treeLayout) {
        String strTree = treeLayout;//toString();
        String[] treeLevels = strTree.split("#");
        for (int i = 0; i < treeLevels.length; i++) {
            String[] level = treeLevels[i].split("\\|");
            for (int j = 0; j < Math.pow(2, treeLevels.length - i); j++)
                System.out.print("  ");
            for (int k = 0; k < level.length; k++) {
                if (level[k].contains("^")) {
                    String[] level2 = level[k].split("\\^");
                    System.out.print("[" + level2[0] + "]");
                    for (int j = 0; j < Math.pow(3, treeLevels.length - i); j++)
                        System.out.print("_");
                    System.out.print("[" + level2[1] + "]");
                } else
                    System.out.print("[" + level[k] + "]");
                for (int j = 0; j < Math.pow(2, treeLevels.length - i); j++)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void testPart1() throws Exception{
        BTree btree = createTree("2");

        //Get the BFS representation of the btree
        String treeLayout = btree.toString();
        PrintTree(treeLayout);
        //Messages messages = createArrayOfMessages();

        //For each message, create a hash table based on the words in the message.
        //messages.createHashTables(args[1]);
    }

    private static void testPart2() throws Exception{

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

    private static BTree createTree(String tVal) {
        BTree btree = new BTree(tVal);
        btree.createFullTree(System.getProperty("user.dir")+"/friends.txt");
        return btree;
    }
}

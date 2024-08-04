package org.dsa.LinkedList;

public class L25DesignBrowserHistory {
//    https://leetcode.com/problems/design-browser-history/
//    class BrowserHistory {
//        private Node currentPage;
//
//        public BrowserHistory(String homepage) {
//            currentPage = new Node(homepage);
//        }
//
//        public void visit(String url) {
//            currentPage.next = new Node(url);
//            currentPage.next.back = currentPage;
//            currentPage = currentPage.next;
//        }
//
//        public String back(int steps) {
//            while(currentPage.back!= null && steps != 0){
//                currentPage = currentPage.back;
//                steps--;
//            }
//            return currentPage.val;
//        }
//
//        public String forward(int steps) {
//            while(currentPage.next!= null && steps != 0){
//                currentPage = currentPage.next;
//                steps--;
//            }
//            return currentPage.val;
//        }
//    }
}

public class LeetCode_002 {

    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersFirst(l1, l2);
    }

    // 第一种方法 暴力求解 先算出结果，再根据结果创捷链表
    public static ListNode addTwoNumbersFirst(ListNode l1, ListNode l2) {
        // 遍历每一个链表，获取其数字
        String l1Number = getNumber(l1);
        String l2Number = getNumber(l2);
        // 如果是前导0，则进行截取
        String l1CutStr = cutStr(l1Number);
        String l2CutStr = cutStr(l2Number);
        // 然后两大数相加
        String sum = getSum(l1CutStr, l2CutStr);
        // 然后对结果进行截取，避免前导0
        String cutStr = cutStr(sum);
        // 最后构建ListNode
        return construct(cutStr);
    }


    public static String getNumber(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            node = node.next;
        }
        sb.reverse();
        return sb.toString();
    }

    public static String cutStr(String s) {
        int begin = 0;
        if (s.length() > 1) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != 0) {
                    begin = i;
                    break;
                }
            }
        }
        return s.substring(begin);
    }

    public static String getSum(String strOne, String strTwo) {
        int oneEnd = strOne.length() - 1, twoEnd = strTwo.length() - 1, add = 0;
        StringBuilder sb = new StringBuilder();
        while (oneEnd >= 0 && twoEnd >= 0) {
            int one = strOne.charAt(oneEnd--) - '0', two = strTwo.charAt(twoEnd--) - '0';
            int sum = one + two + add;
            sb.append(sum % 10);
            add = sum / 10;
        }

        while (oneEnd >= 0) {
            int one = strTwo.charAt(oneEnd) - '0';
            int sum = one + add;
            sb.append(sum % 10);
            add = sum / 10;
            oneEnd--;
        }

        while (twoEnd >= 0) {
            int two = strOne.charAt(twoEnd) - '0';
            int sum = two + add;
            sb.append(sum % 10);
            add = sum / 10;
            twoEnd--;
        }

        if (add == 1) sb.append(1);
        return sb.reverse().toString();
    }

    public static ListNode construct(String str){
        int begin = 0;
        ListNode head = new ListNode(str.charAt(begin++));
        while (begin < str.length()){
            head.next = new ListNode(str.charAt(begin++));
            head = head.next;
        }
        return head;
    }

}

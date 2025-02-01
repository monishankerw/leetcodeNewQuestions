Here is a curated list of 30 LeetCode questions that are commonly asked in Paytm interviews, categorized by topic:

### **1. Array and String (7 Questions)**
1. [Two Sum](https://leetcode.com/problems/two-sum/)
2. [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
3. [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
4. [Maximum Subarray (Kadane's Algorithm)](https://leetcode.com/problems/maximum-subarray/)
5. [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)
6. [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/)
7. [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)


---

### **1. Two Sum**
**Problem:** Find two indices where their values sum to a target.  
**Approach:**
- Use a **hashmap** to store `(value → index)` pairs.
- For each element `nums[i]`, check if `target - nums[i]` exists in the hashmap.
- If found, return `[map.get(target - nums[i]), i]`.  
  **Complexity:**
- **Time:** O(n)
- **Space:** O(n)  
  **Key Insight:** The hashmap allows O(1) lookups to track complements efficiently.

---

### **2. Best Time to Buy and Sell Stock**
**Problem:** Maximize profit from one buy/sell transaction.  
**Approach:**
- Track the **minimum price** seen so far.
- Calculate profit as `current_price - min_price` and update **max_profit**.  
  **Complexity:**
- **Time:** O(n)
- **Space:** O(1)  
  **Key Insight:** The optimal sell day is always after the minimum buy day.

---

### **3. Longest Substring Without Repeating Characters**
**Problem:** Find the longest substring with unique characters.  
**Approach:**
- **Sliding Window** with two pointers (`left`, `right`) and a **hashmap** to track the last seen index of each character.
- If a duplicate is found, move `left` to `max(left, last_seen_index + 1)`.  
  **Complexity:**
- **Time:** O(n)
- **Space:** O(1) (fixed-size ASCII hashmap)  
  **Key Insight:** The window adjusts to exclude duplicates while tracking maximum length.

---

### **4. Maximum Subarray (Kadane's Algorithm)**
**Problem:** Find the subarray with the largest sum.  
**Approach:**
- Track `current_max` (max subarray ending at `i`) and `global_max`.
- Update `current_max = max(nums[i], current_max + nums[i])`.
- Update `global_max` if `current_max` is larger.  
  **Complexity:**
- **Time:** O(n)
- **Space:** O(1)  
  **Key Insight:** Negative subarrays are discarded to reset the running sum.

---

### **5. Product of Array Except Self**
**Problem:** Compute an array where each element is the product of all elements except itself.  
**Approach:**
- **Two passes**:
    1. Left-to-right: Compute products of elements to the **left**.
    2. Right-to-left: Multiply by products of elements to the **right**.  
       **Complexity:**
- **Time:** O(n)
- **Space:** O(1) (if output array is not counted)  
  **Key Insight:** Split the product into left and right parts to avoid division.

---

### **6. Find the Duplicate Number**
**Problem:** Find the duplicate number in an array with O(1) space and no array modification.  
**Approach:**
- **Floyd's Tortoise and Hare**:
    1. Detect intersection of slow (1 step) and fast (2 steps) pointers.
    2. Find the entrance to the cycle (duplicate) using a second slow pointer.  
       **Complexity:**
- **Time:** O(n)
- **Space:** O(1)  
  **Key Insight:** Treat the array as a linked list with a cycle; the duplicate is the cycle's entrance.

---

### **7. Trapping Rain Water**
**Problem:** Compute total rainwater trapped between bars.  
**Approach:**
- **Two pointers** (`left`, `right`) tracking `max_left` and `max_right`.
- Move the pointer with the smaller max height.
- Add trapped water as `min(max_left, max_right) - current_height`.  
  **Complexity:**
- **Time:** O(n)
- **Space:** O(1)  
  **Key Insight:** Water trapped at a position depends on the minimum of the tallest bars to its left and right.

---

### **Interview Tips**
1. **Edge Cases:**
    - Empty arrays, all negative numbers (Kadane's), duplicates at boundaries (Two Sum).
2. **Optimization:** Always mention brute force first, then optimize.
3. **Space-Time Tradeoffs:** Explain why your approach is optimal (e.g., hashmap for O(1) lookups).
4. **Examples:** Walk through a sample input to demonstrate logic (e.g., `[3,1,3,4,2]` for the duplicate problem).


### **2. Linked List (5 Questions)**
8. [Reverse a Linked List](https://leetcode.com/problems/reverse-linked-list/)
9. [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)
10. [Cycle Detection in a Linked List](https://leetcode.com/problems/linked-list-cycle/)
11. [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
12. [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)

### **3. Stack & Queue (4 Questions)**
13. [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
14. [Implement LRU Cache](https://leetcode.com/problems/lru-cache/)
15. [Min Stack](https://leetcode.com/problems/min-stack/)
16. [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)

### **4. Binary Tree & Binary Search Tree (5 Questions)**
17. [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)
18. [Lowest Common Ancestor of a BST](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
19. [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)
20. [Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)
21. [Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)

### **5. Recursion & Backtracking (3 Questions)**
22. [Subset Sum](https://leetcode.com/problems/subsets/)
23. [Word Search](https://leetcode.com/problems/word-search/)
24. [Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)

### **6. Dynamic Programming (3 Questions)**
25. [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
26. [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)
27. [Coin Change](https://leetcode.com/problems/coin-change/)

### **7. Graphs (3 Questions)**
28. [Number of Islands](https://leetcode.com/problems/number-of-islands/)
29. [Course Schedule (Topological Sort)](https://leetcode.com/problems/course-schedule/)
30. [Shortest Path in a Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/)

